package app.hglass.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Implements an entity class representing the status entries for a ride in the database.
 *
 * @author Matt Aaron
 * @version 0.0.2
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

	/**
	 * Get unique identifier
	 *
	 * @return unique identifier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get <code>Ride</code>
	 *
	 * @return <code>Ride</code>
	 */
	public Ride getRide() {
		return ride;
	}

	/**
	 * Set <code>Ride</code>
	 *
	 * @param ride new <code>Ride</code>
	 */
	public void setRide(Ride ride) {
		this.ride = ride;
	}

	/**
	 * Get operating status
	 *
	 * @return true if operating, false otherwise
	 */
	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * Set operating status
	 *
	 * @param open new operating status
	 */
	public void setOpen(boolean open) {
		isOpen = open;
	}

	/**
	 * Get wait time
	 *
	 * @return wait time
	 */
	public int getWaitTime() {
		return waitTime;
	}

	/**
	 * Set wait time
	 *
	 * @param waitTime new wait time
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	/**
	 * Get last update timestamp
	 *
	 * @return last update timestamp
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Set last updated timestamp
	 *
	 * @param updatedAt new last updated timestamp
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Get entry timestamp
	 *
	 * @return entry timestamp
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
}
