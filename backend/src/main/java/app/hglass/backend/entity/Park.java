package app.hglass.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Implements a class representing an amusement park. This class maintains the relationships necessary to tie
 * information from the database together, such as rides and wait times.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@Entity
@Table(name = "parks")
public class Park {
	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Park name
	 */
	private String name;

	/**
	 * Park many-to-one relationship with operators
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Operator operator;
}
