package app.hglass.backend.view;

/**
 * Implements a simple class used to represent different "views", providing a way to dynamically serialize entities.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
public class Views {
	/**
	 * Implements an interface to represent a park overview view.
	 *
	 * @author Matt Aaron
	 * @version 0.0.1
	 */
	public interface ParkOverview {
	}

	/**
	 * Implements an interface to present a detailed park view.
	 *
	 * @author Matt Aaron
	 * @version 0.0.1
	 */
	public interface ParkDetailed extends ParkOverview {

	}
}
