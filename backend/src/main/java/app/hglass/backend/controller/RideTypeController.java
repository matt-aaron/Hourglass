package app.hglass.backend.controller;

import app.hglass.backend.entity.Park;
import app.hglass.backend.entity.RideType;
import app.hglass.backend.repository.ParkRepository;
import app.hglass.backend.repository.RideTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implements a REST controller to provide ride type endpoints to the API.
 *
 * @author Matt Aaron
 * @version 0.0.1
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
	 * Get a list of all ride types by park ID
	 *
	 * @param id Park ID
	 * @return list of all ride types
	 */
	@GetMapping("/park/{id}/rides")
	public List<RideType> getRideTypesById(@PathVariable(value = "id") int id) {
		Park park = parkRepository.findById(id)
				.orElseThrow(() -> new RuntimeException());

		return rideTypeRepository.findByPark(park);
	}
}
