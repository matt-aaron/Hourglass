package app.hglass.backend.model;

import javax.persistence.Embeddable;

/**
 * Implements an embeddable class used to represent the coordinates of a location.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@Embeddable
public class Location {
	/**
	 * Latitude component
	 */
	private double latitude;

	/**
	 * Longitude component
	 */
	private double longitude;

	/**
	 * Get latitude component
	 *
	 * @return latitude component
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Get longitude component
	 *
	 * @return longitude component
	 */
	public double getLongitude() {
		return longitude;
	}
}
