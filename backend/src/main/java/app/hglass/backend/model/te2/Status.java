package app.hglass.backend.model.te2;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Implements a class to represent POI status from the TE2 service.
 *
 * @author Matt Aaron
 * @version 0.0.4
 */
public class Status {
	/**
	 * Attraction operating status
	 */
	private boolean isOpen;

	/**
	 * Attraction wait time
	 */
	private Integer waitTime;

	/**
	 * Last update timestamp
	 */
	private Date lastChanged;

	/**
	 * Get attraction operating status
	 *
	 * @return true if operating, false otherwise
	 */
	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * Get attraction wait time
	 *
	 * @return wait time
	 */
	public Integer getWaitTime() {
		return waitTime;
	}

	/**
	 * Check if the wait time exists for this attraction
	 *
	 * @return true if set, false otherwise
	 */
	@JsonIgnore
	public boolean isWaitTimeSet() {
		return waitTime != null;
	}

	/**
	 * Get last wait time update timestamp
	 *
	 * @return last wait time update timestamp
	 */
	public Date getLastChanged() {
		return lastChanged;
	}
}
