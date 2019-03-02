package app.hglass.backend.repository;

import app.hglass.backend.entity.RideStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implements a repository for accessing ride status information from the database.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
public interface RideStatusRepository extends JpaRepository<RideStatus, Integer> {
}
