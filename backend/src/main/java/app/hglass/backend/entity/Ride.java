package app.hglass.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Implements an entity class representing rides from the database.
 *
 * @author Matt Aaron
 * @version 0.0.3
 */
@Entity
@Table(name = "rides")
public class Ride {
	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Name
	 */
	private String name;

	/**
	 * TE2 platform identifier
	 */
	private String platformId;

	/**
	 * Many-to-one relationship to the <code>Park</code> of which this belongs
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Park park;

	/**
	 * Many-to-one relationship to the <code>RideType</code> of which this belongs
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ride_type_id")
	@JsonIgnore
	private RideType type;

	/**
	 * Ride status
	 */
	@Transient
	private RideStatus status;

	/**
	 * Get unique identifier
	 *
	 * @return ride unique identifier
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get name
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 *
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get TE2 platform identifier
	 *
	 * @return TE2 platform identifier
	 */
	public String getPlatformId() {
		return platformId;
	}

	/**
	 * Set TE2 platform identifier
	 *
	 * @param platformId new TE2 platform identifier
	 */
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	/**
	 * Get <code>Park</code>
	 *
	 * @return <code>Park</code>
	 */
	public Park getPark() {
		return park;
	}

	/**
	 * Set <code>Park</code>
	 *
	 * @param park new <code>Park</code>
	 */
	public void setPark(Park park) {
		this.park = park;
	}

	/**
	 * Get <code>RideType</code>
	 *
	 * @return <code>RideType</code>
	 */
	public RideType getType() {
		return type;
	}

	/**
	 * Set <code>RideType</code>
	 *
	 * @param type new <code>RideType</code>
	 */
	public void setType(RideType type) {
		this.type = type;
	}

	/**
	 * Get <code>RideStatus</code>. This field is initialized by the REST controller.
	 *
	 * @return <code>RideStatus</code>
	 */
	public RideStatus getStatus() {
		return status;
	}

	/**
	 * Set <code>RideStatus</code>
	 *
	 * @param status new <code>RideStatus</code>
	 */
	public void setStatus(RideStatus status) {
		this.status = status;
	}
}
