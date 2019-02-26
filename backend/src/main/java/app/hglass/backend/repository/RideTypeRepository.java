package app.hglass.backend.repository;

import app.hglass.backend.entity.Park;
import app.hglass.backend.entity.RideType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implements a repository for accessing ride type information from the database.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@Repository
public interface RideTypeRepository extends JpaRepository<RideType, Integer> {
	/**
	 * Get a list of ride types by park
	 *
	 * @param park target <code>Park</code>
	 * @return list of ride types
	 */
	List<RideType> findByPark(Park park);
}
