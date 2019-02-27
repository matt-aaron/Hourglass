package app.hglass.backend.repository;

import app.hglass.backend.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Implements a repository for operator information from the database.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {

}
