package app.hglass.backend.controller;

import app.hglass.backend.entity.Park;
import app.hglass.backend.entity.Ride;
import app.hglass.backend.entity.RideType;
import app.hglass.backend.repository.ParkRepository;
import app.hglass.backend.repository.RideStatusRepository;
import app.hglass.backend.repository.RideTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implements a REST controller providing ride type endpoints.
 *
 * @author Matt Aaron
 * @version 0.0.2
 */
@RestController
public class RideTypeController {
	/**
	 * Park repository
	 */
	@Autowired
	ParkRepository parkRepository;

	/**
	 * Ride repository
	 */
	@Autowired
	RideTypeRepository rideTypeRepository;

	/**
	 * Ride status repository
	 */
	@Autowired
	RideStatusRepository rideStatusRepository;

	/**
	 * Get a list of all ride types by park ID
	 *
	 * @param id Park ID
	 * @return list of all ride types
	 */
	@GetMapping("/park/{id}/rides")
	public List<RideType> getRideTypesById(@PathVariable(value = "id") int id) {
		Park park = parkRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Park not found. Park ID: " + id));

		List<RideType> rideTypes = rideTypeRepository.findByPark(park);
		for (RideType rideType : rideTypes) {
			for (Ride ride : rideType.getRides()) {
				ride.setStatus(rideStatusRepository.getTopByRideOrderByCreatedAt(ride));
			}
		}

		return rideTypes;
	}
}
