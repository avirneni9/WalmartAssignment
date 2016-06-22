package com.project.ticketservice.model;

import java.util.HashMap;
import java.util.Map;
/**
 * @author Avirneni.Sai
 * THis is a model object for SeatHold
 * 
 */
public class SeatHold {
	/**
	 * Variables which represent the properties of SeatHold. 
	 */
	private Integer levelId = null;						//Id of the level in which seat is hold
	private String emailId;								//Email Id of the person to hold
	private static Integer seatHoldId = 5000;			//Id for seat hold transaction
	private Map<String, String> reservedSeats = null;	//Map of row as a key and array of seats as value
	private String message="";							//Seat hold message
	/**
	 * Getters and Setters for the variables.
	 * 
	 */
	public Map<String, String> getReservedSeats()
	{
		if(null == reservedSeats)
			reservedSeats = new HashMap<String, String>();
		return reservedSeats;
	}

	public void setReservedSeats(Map<String, String> reservedSeats) {
		this.reservedSeats = reservedSeats;
	} 

	public int getSeatHoldId() {
		return seatHoldId;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	@SuppressWarnings("static-access")
	public void setSeatHoldId(Integer seatHoldId) {
		this.seatHoldId = seatHoldId;
	}
	/**
	 * This is a method to generate a seat hold ID
	 */
	@SuppressWarnings("static-access")
	public synchronized int getSequenceId() {
		return this.seatHoldId+1;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
