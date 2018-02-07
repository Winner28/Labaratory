package spring.db.dao;

public class CountryNotFoundException extends RuntimeException {
	public CountryNotFoundException(String message) {
		super(message);
	}
}
