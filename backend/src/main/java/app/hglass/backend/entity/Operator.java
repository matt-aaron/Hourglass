package app.hglass.backend.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Implements a class representing an amusement park operator. This class maintains the relationships necessary to
 * tie information from the database together.
 *
 * @author Matt Aaron
 * @version 0.0.2
 */
@Entity
@Table(name = "operators")
public class Operator {
	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Operator name
	 */
	private String name;

	/**
	 * Operator one-to-many relationship witn parks
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "operator")
	@OrderBy("id ASC")
	private List<Park> parks;

	/**
	 * Get unique identifier
	 *
	 * @return unique identifier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get operator name
	 *
	 * @return operator name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get list of parks run by operator
	 *
	 * @return list of parks
	 */
	public List<Park> getParks() {
		return parks;
	}
}
