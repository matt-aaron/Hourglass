package app.hglass.backend.controller;

import app.hglass.backend.entity.Operator;
import app.hglass.backend.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implements a REST controller to provide operator endpoints to the API.
 *
 * @author Matt Aaron
 * @version 0.0.1
 */
@RestController
public class OperatorController {
	/**
	 * Operator repository
	 */
	@Autowired
	OperatorRepository operatorRepository;

	/**
	 * Get a list of all operators
	 *
	 * @return a list of all operators
	 */
	@GetMapping("/operators")
	public List<Operator> getAllOperators() {
		return operatorRepository.findAll();
	}
}
