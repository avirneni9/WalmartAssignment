package com.project.ticketservice.exception;
/**
 * @author Avirneni.Sai
 * This class is a customized user defined exception class 
 * to display exceptional messages
 */
public class TicketServiceException extends Exception {

	private static final long serialVersionUID = 1677989903590065345L;
	
	/**
	 * Default Constructor.
	 */
	public TicketServiceException()
	{
	}
	
	/**
	 * Constructor with custom message.
	 * @param message
	 */
	public TicketServiceException(String message)
	{
		super(message);
	}
	
	/**
	 * Constructor with custom message and exception cause as parameters.
	 * @param message
	 * @param cause
	 */
	public TicketServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}
	/**
	 * Constructor with exception cause as parameter.
	 * @param cause
	 */
	public TicketServiceException(Throwable cause)
	{
		super(cause);
	}
}
