package app.hglass.backend.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Implements a class representing an amusement park operator. This class maintains the relationships necessary to
 * tie information from the database together.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@Entity
@Table(name = "operators")
public class Operator {
	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Operator name
	 */
	private String name;

	/**
	 * Operator one-to-many relationship witn parks
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "operator")
	private List<Park> parks;
}
