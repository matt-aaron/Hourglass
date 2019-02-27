package app.hglass.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Implements an entity class representing the daily schedule for an amusement park.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@Entity
@Table(name = "park_schedules")
public class ParkSchedule {
	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;

	/**
	 * Many-to-one relationship to <code>Park</code>
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Park park;

	/**
	 * Operating status
	 */
	private boolean isOpen;

	/**
	 * Hours date
	 */
	@Temporal(TemporalType.DATE)
	@JsonIgnore
	private Date date;

	/**
	 * Start timestamp
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
	private Date start;

	/**
	 * End timestamp
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
	private Date end;

	/**
	 * Get unique identifier
	 *
	 * @return unique identifier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get <code>Park</code> to which this refers
	 *
	 * @return corresponding <code>Park</code>
	 */
	public Park getPark() {
		return park;
	}

	/**
	 * Get operating status
	 *
	 * @return true if open, false if closed
	 */
	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * Get hours date
	 *
	 * @return hours date
	 */
	public Date getDate() {
		return date;
	}

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
