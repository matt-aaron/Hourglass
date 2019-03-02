package app.hglass.backend.controller;

import app.hglass.backend.entity.*;
import app.hglass.backend.model.te2.*;
import app.hglass.backend.repository.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Implements a REST controller to allow for updating information in the database from the TE2 service.
 *
 * @author Matt Aaron
 * @version 0.1.0
 */
@RestController
public class UpdateController {
	/**
	 * TE2 service base URL
	 */
	private static final String TE2_BASE_URL = "https://cf.te2.biz";

	/**
	 * Park repository
	 */
	@Autowired
	ParkRepository parkRepository;

	/**
	 * Park schedule repository
	 */
	@Autowired
	ParkScheduleRepository parkScheduleRepository;

	/**
	 * Ride repository
	 */
	@Autowired
	RideRepository rideRepository;

	/**
	 * Ride type repository
	 */
	@Autowired
	RideTypeRepository rideTypeRepository;

	/**
	 * Ride status repository
	 */
	@Autowired
	RideStatusRepository rideStatusRepository;

	/**
	 * Fetch updated data from TE2 endpoints and save them to the database.
	 */
	@GetMapping("/te2/update")
	public List<POI> update() {
		List<Park> parks = parkRepository.findAll();

		for (Park park : parks) {
			boolean openNow = false;

			// Hours
			VenueHours venueHours = getVenueHours(park);
			for (Day day : venueHours.getDays()) {
				for (Hours hours : day.getHours()) {
					Schedule schedule = hours.getSchedule();

					Optional<ParkSchedule> optSched = parkScheduleRepository.findByParkAndDate(park, day.getDate());
					ParkSchedule parkSchedule = null;
					if (optSched.isPresent()) {
						parkSchedule = optSched.get();
					}
					else {
						parkSchedule = new ParkSchedule();
					}

					parkSchedule.setPark(park);
					parkSchedule.setOpen(false);
					parkSchedule.setDate(day.getDate());
					parkSchedule.setStart(schedule.getStart());
					parkSchedule.setEnd(schedule.getEnd());
					parkScheduleRepository.save(parkSchedule);
				}
			}

			// Set openNow
			Date now = new Date();
			Optional<ParkSchedule> schedule = parkScheduleRepository.findByParkAndStartBeforeAndEndAfter(park, now, now);
			if (schedule.isPresent()) {
				openNow = schedule.get().isOpen();
			}

			// Rides
			List<RideType> rideTypes = rideTypeRepository.findByPark(park);
			List<POI> attractions = getAttractionsByPark(park);

			for (RideType rideType : rideTypes) {
				for (POI attraction : attractions) {
					// Not one of our categories
					if (!rideType.getPlatformId().equals(attraction.getType())) {
						continue;
					}

					// No status
					if (!attraction.isStatusSet()) {
						continue;
					}

					// No wait time
					if (!attraction.getStatus().isWaitTimeSet()) {
						continue;
					}

					// Save the ride to the database
					Ride ride = rideRepository.findByPlatformId(attraction.getId());
					if (ride == null) {
						ride = new Ride();
					}

					ride.setPark(park);
					ride.setPlatformId(attraction.getId());
					ride.setType(rideType);
					ride.setName(attraction.getLabel());
					rideRepository.save(ride);

					RideStatus rideStatus = new RideStatus();
					rideStatus.setRide(ride);
					rideStatus.setOpen(openNow && attraction.getStatus().isOpen());
					rideStatus.setWaitTime(openNow ? attraction.getStatus().getWaitTime() : 0);
					rideStatus.setUpdatedAt(attraction.getStatus().getLastChanged());
					rideStatusRepository.save(rideStatus);
				}
			}
		}

		return null;
	}

	/**
	 * Get a <code>List</code> of POI by park
	 *
	 * @param park target <code>Park</code>
	 * @return list of attractions
	 */
	private static List<POI> getAttractionsByPark(Park park) {
		String credentials = "Mobile_API:merl4yU2";
		// Encode the credentials
		byte[] credentialsBytes = credentials.getBytes();
		byte[] base64CredentialBytes = Base64.encodeBase64(credentialsBytes);
		String base64Credentials = new String(base64CredentialBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Credentials);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<List<POI>> response =
				restTemplate.exchange(TE2_BASE_URL + "/rest/venue/" + park.getPlatformId() + "/poi/all",
						HttpMethod.GET, request, new ParameterizedTypeReference<List<POI>>() {
						});

		return response.getBody();
	}

	private static VenueHours getVenueHours(Park park) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(TE2_BASE_URL + "/v2/venues/" + park.getPlatformId() + "/venue-hours?days=7",
				VenueHours.class);
	}
}
