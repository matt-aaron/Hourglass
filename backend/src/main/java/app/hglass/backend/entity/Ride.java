package app.hglass.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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
}
