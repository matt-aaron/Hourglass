package app.hglass.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Implements an entity class representing the status entries for a ride in the database.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@Entity
@Table(name = "ride_statuses")
public class RideStatus {
	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Many-to-one relationship with <code>Ride</code>
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Ride ride;

	/**
	 * Operating status
	 */
	private boolean isOpen;

	/**
	 * Wait time
	 */
	private int waitTime;

	/**
	 * Last update time
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	/**
	 * Entry timestamp
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date createdAt;


}
