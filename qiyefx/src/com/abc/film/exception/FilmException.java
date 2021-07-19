/**
 * 
 */
package com.abc.film.exception;

/**
 * 
 * @author joeyang ong
 *
 */
public class FilmException extends RuntimeException {

	/**
	 * 
	 */
	public FilmException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public FilmException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public FilmException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FilmException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FilmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
