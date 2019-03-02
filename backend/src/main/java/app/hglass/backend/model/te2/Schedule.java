package app.hglass.backend.model.te2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Implements a Schedule class as a part of the representation of the operating schedule information from the TE2
 * service.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {
	/**
	 * Start timestamp
	 */
	private Date start;

	/**
	 * End timestamp
	 */
	private Date end;

	/**
	 * Get start timestamp
	 *
	 * @return start timestamp
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * Get end timestamp
	 *
	 * @return end timestamp
	 */
	public Date getEnd() {
		return end;
	}
}
