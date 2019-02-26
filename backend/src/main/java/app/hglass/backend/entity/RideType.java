package app.hglass.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Implements an entity class representing the various ride types/categories which are assigned to rides for easy
 * grouping.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@Entity
@Table(name = "ride_types")
public class RideType {
	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Many-to-one relationship with <code>Park</code>
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Park park;

	/**
	 * TE2 platform identifier
	 */
	private String platformId;

	/**
	 * Display name
	 */
	private String name;

	/**
	 * One-to-many relationship with <code>Ride</code>s
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	private List<Ride> rides;

	/**
	 * Get unique identifier
	 *
	 * @return unique identifier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the <code>Park</code> to which this refers
	 *
	 * @return related <code>Park</code> object
	 */
	public Park getPark() {
		return park;
	}

	/**
	 * Get the TE2 platform identifier
	 *
	 * @return TE2 platform identifier
	 */
	public String getPlatformId() {
		return platformId;
	}

	/**
	 * Get the display name
	 *
	 * @return display name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the <code>Ride</code>s belonging to this
	 *
	 * @return List of <code>Ride</code>s
	 */
	public List<Ride> getRides() {
		return rides;
	}
}
