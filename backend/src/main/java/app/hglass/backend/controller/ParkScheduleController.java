package app.hglass.backend.controller;

import app.hglass.backend.entity.Park;
import app.hglass.backend.entity.ParkSchedule;
import app.hglass.backend.repository.ParkRepository;
import app.hglass.backend.repository.ParkScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

/**
 * Implements a REST controller providing park schedule endpoints.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@RestController
public class ParkScheduleController {
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
	 * Get park schedule by park ID
	 *
	 * @param id park ID
	 * @return active <code>ParkSchedule</code>
	 */
	@GetMapping("/park/{id}/hours")
	public ParkSchedule getScheduleByParkId(@PathVariable(value = "id") int id) {
		Park park = parkRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Park not found. Park ID: " + id));

		Date now = new Date();
		Optional<ParkSchedule> schedule = parkScheduleRepository.findByParkAndStartBeforeAndEndAfter(park, now, now);
		if (schedule.isPresent()) {
			return schedule.get();
		}

		return parkScheduleRepository.findByParkAndDate(park, now)
				.orElseThrow(() -> new RuntimeException("Current date not found in schedules. Park ID: " + id));
	}
}
