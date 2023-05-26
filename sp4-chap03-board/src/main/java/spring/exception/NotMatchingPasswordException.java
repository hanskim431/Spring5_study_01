package spring.exception;

public class NotMatchingPasswordException extends RuntimeException {

	public NotMatchingPasswordException(String message) {
		super(message);
	}

}
