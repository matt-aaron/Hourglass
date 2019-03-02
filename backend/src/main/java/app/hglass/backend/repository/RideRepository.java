package app.hglass.backend.repository;

import app.hglass.backend.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implements a repository for accessing ride information from the database.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
public interface RideRepository extends JpaRepository<Ride, Integer> {
	/**
	 * Get ride by TE2 platform identifier
	 *
	 * @param platformId TE2 platform identifier
	 * @return target ride
	 */
	Ride findByPlatformId(String platformId);
}
