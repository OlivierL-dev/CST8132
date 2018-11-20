/*
 * Name: Olivier Lauzon
 * Student ID: 040918796
 * Course & Section: CST8132 303
 * Assignment: Lab 8
 * Date: Nov 19, 2018
 */

/**
 * An exception that is thrown when the capacity is smaller than the size
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class CapacityOutOfBoundsException extends RuntimeException {
	/**
	 * serial for the exception
	 */
	private static final long serialVersionUID = 6519267501534016754L;

	CapacityOutOfBoundsException(){
		super();
	}
	
	CapacityOutOfBoundsException(String s){
		super(s);
	} 
}
