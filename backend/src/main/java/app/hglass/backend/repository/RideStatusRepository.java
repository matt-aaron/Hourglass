package app.hglass.backend.repository;

import app.hglass.backend.entity.Ride;
import app.hglass.backend.entity.RideStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implements a repository for accessing ride status information from the database.
 *
 * @author Matt Aaron
 * @version 0.0.2
 */
public interface RideStatusRepository extends JpaRepository<RideStatus, Integer> {
	/**
	 * Get the latest status for a given <code>Ride</code>
	 *
	 * @param ride target <code>Ride</code>
	 * @return latest status
	 */
	RideStatus getTopByRideOrderByCreatedAt(Ride ride);
}
