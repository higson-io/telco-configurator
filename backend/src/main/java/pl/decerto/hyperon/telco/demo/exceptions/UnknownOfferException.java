package pl.decerto.hyperon.telco.demo.exceptions;

/**
 * @author Maciej Główka on 11.03.2019
 */
public class UnknownOfferException extends RuntimeException {
	public UnknownOfferException(String message) {
		super(message);
	}
}
