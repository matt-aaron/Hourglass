package app.hglass.backend.model.te2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Implements an Hours class as a part of the representation of the operating schedule information from the TE2 service.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hours {
	/**
	 * Hours label for what these hours are representing, typically "Park"
	 */
	private String label;

	/**
	 * Operating status of the park for these particular hours, represented as a <code>String</code> with a value of
	 * "OPEN" or "CLOSED"
	 */
	private String status;

	/**
	 * <code>Schedule</code> containing the start and end timestamps of the hours
	 */
	private Schedule schedule;

	/**
	 * Get label
	 *
	 * @return label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Get operating status
	 *
	 * @return OPEN if open and CLOSED if closed
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * <code>Schedule</code> containing the start and end timestamps
	 *
	 * @return schedule
	 */
	public Schedule getSchedule() {
		return schedule;
	}
}
