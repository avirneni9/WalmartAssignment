package com.project.ticketservice.model;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @author Avirneni.Lakshman
 * THis is a model object for Seat
 * This class also start the timer to hold the seat for a given time (in Seconds)
 */
public class Seat {
	/**
	 * Variables which represent the properties of Product. 
	 */
	private Timer timer;		//Timer to hold the seat
	private Integer seatNumber;	//Number of a seat
	private String isHold = "N";//Hold status of a seat
	private String isReserved = "N";//Reserve status of a seat
	/**
	 * Getters and Setters for the variables.
	 * 
	 */
	public Seat(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Integer getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getIsHold() {
		return isHold;
	}
	public void setIsHold(String isHold) {
		this.isHold = isHold;
	}
	public String getIsReserved() {
		return isReserved;
	}
	public void setIsReserved(String isReserved) {
		this.isReserved = isReserved;
	}
	@Override
	public String toString() {
		return " SeatNumber [" + seatNumber + "], IsHold [" + isHold + "], IsReserved [" + isReserved + "] ";
	}
	/**
	 * This method set the hold status to "Y" and 
	 * start the timer to hold
	 */
	public void putOnHold() {
		this.isHold = "Y";
		execute(60);
	}
	private void execute(int seconds) {
		timer = new Timer();
		timer.schedule(new ToDoTask(), seconds * 1000);
	}
	/**
	 * This is a timer run class
	 */
	class ToDoTask extends TimerTask {
		public void run() {
			timer.cancel();
			isHold = "N";
			}
	}

}
