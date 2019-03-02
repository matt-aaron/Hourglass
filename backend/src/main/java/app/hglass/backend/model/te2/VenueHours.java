package app.hglass.backend.model.te2;

import java.util.List;

/**
 * Implements a class representing the root of the venue hours TE2 endpoint. This class is used as part of the
 * <code>update()</code> method in <code>UpdateController</code>.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
public class VenueHours {
	/**
	 * List of the days
	 */
	private List<Day> days;

	/**
	 * List of days
	 *
	 * @return list of days
	 */
	public List<Day> getDays() {
		return days;
	}
}
