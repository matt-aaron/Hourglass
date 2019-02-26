package app.hglass.backend.repository;

import app.hglass.backend.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Implements a repository for accessing park information from the database.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@Repository
public interface ParkRepository extends JpaRepository<Park, Integer> {
	/**
	 * Find a park by unique identifier
	 *
	 * @param id Unique identifier
	 * @return <code>Park</code> object
	 */
	Optional<Park> findById(int id);
}
