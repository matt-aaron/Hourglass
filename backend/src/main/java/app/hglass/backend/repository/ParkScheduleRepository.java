package app.hglass.backend.repository;

import app.hglass.backend.entity.Park;
import app.hglass.backend.entity.ParkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

/**
 * Implements a repository for accessing park schedule information from the database.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
public interface ParkScheduleRepository extends JpaRepository<ParkSchedule, Integer> {
	/**
	 * Find park active schedule by <code>Park</code> and the current date
	 *
	 * @param park  target <code>Park</code>
	 * @param end   Current <code>Date</code> timestamp
	 * @param start Current <code>Date</code> timestamp
	 * @return optional park schedule
	 */
	Optional<ParkSchedule> findByParkAndStartBeforeAndEndAfter(Park park, Date end, Date start);

	/**
	 * Find park schedule by <code>Park</code> and the current date
	 *
	 * @param park target <code>Park</code>
	 * @param date Current <code>Date</code> (not timestamp)
	 * @return optional park schedule
	 */
	Optional<ParkSchedule> findByParkAndDate(Park park, Date date);
}
