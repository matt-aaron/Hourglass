package app.hglass.backend.model.te2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * Implements a Day class as a part of the representation of the operating schedule data from the TE2 service.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {
	/**
	 * Date of the hours
	 */
	private Date date;

	/**
	 * List of the hours on this date. Represented as a list because each venue can have hours for multiple parks,
	 * for example, dry park and water park
	 */
	private List<Hours> hours;

	/**
	 * Get date of hours
	 *
	 * @return date of hours
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Get list of hours
	 *
	 * @return list of hours
	 */
	public List<Hours> getHours() {
		return hours;
	}
}
