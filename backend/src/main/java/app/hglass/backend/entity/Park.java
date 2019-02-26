package app.hglass.backend.entity;

import app.hglass.backend.model.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Implements a class representing an amusement park. This class maintains the relationships necessary to tie
 * information from the database together, such as rides and wait times.
 *
 * @author Matt Aaron
 * @version 0.0.3
 */
@Entity
@Table(name = "parks")
public class Park {
	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Park name
	 */
	private String name;

	/**
	 * Embedded <code>Location</code> object
	 */
	@Embedded
	private Location location;

	/**
	 * Many-to-one relationship with <code>Operator</code>
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Operator operator;

	/**
	 * One-to-many relationship with <code>RideType</code>s
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "park")
	@JsonIgnore
	private List<RideType> rideTypes;

	/**
	 * Get unique identifier
	 *
	 * @return unique identifier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get park name
	 *
	 * @return park name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get park <code>Location</code>
	 *
	 * @return park <code>Location</code>
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Get park <code>Operator</code>
	 *
	 * @return park <code>Operator</code>
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * Get list of the ride types/categories
	 *
	 * @return list of <code>RideType</code>s
	 */
	public List<RideType> getRideTypes() {
		return rideTypes;
	}
}
