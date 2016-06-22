package com.project.ticketservice.model;

/**
 * @author Avirneni.Lakshman
 * This is a model object for Row
 */
public class Row {
	/**
	 * Variables which represent the properties of Row. 
	 */
	private Integer rowId; 	//Id for each row in a level
	private Seat[] seats;	//Array of seats in a row
	/**
	 * Constructor of Row 
	 */
	public Row(Integer rowId, Integer numberOfSeats) {
		this.rowId = rowId + 1;
		this.seats = new Seat[numberOfSeats];

		for(int index = 0; index < seats.length; index++)
			this.seats[index] = new Seat(index + 1);
	}
	/**
	 * Getters and Setters for the variables.
	 * 
	 */
	public Integer getRowId() {
		return rowId;
	}
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	public Seat[] getSeats() {
		return seats;
	}

	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}
	
}
