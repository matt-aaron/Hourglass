package app.hglass.backend.model.te2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Implements a POI class to represent data from the TE2 service as an object. This class is used as part of the
 * <code>update()</code> method in <code>UpdateController</code>.
 *
 * @author Matt Aaron
 * @version 0.0.3
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class POI {
	/**
	 * TE2 platform identifier
	 */
	private String id;

	/**
	 * Attraction type
	 */
	private String type;

	/**
	 * Attraction label
	 */
	private String label;

	/**
	 * Attraction status
	 */
	private Status status;

	/**
	 * Get TE2 platform identifier
	 *
	 * @return TE2 platform identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * Get attraction type
	 *
	 * @return attraction type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get attraction label
	 *
	 * @return attraction label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Get attraction status
	 *
	 * @return attraction status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Check if this attraction has a <code>Status</code>
	 *
	 * @return true if set, false otherwise
	 */
	@JsonIgnore
	public boolean isStatusSet() {
		return status != null;
	}
}
