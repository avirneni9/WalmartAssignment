package com.project.ticketservice.serviceimpl;

import java.util.Optional;
import com.project.ticketservice.model.SeatHold;
import com.project.ticketservice.service.SeatFindHold;
import com.project.ticketservice.service.SeatReserve;
import com.project.ticketservice.service.SeatsAvailable;

public class TicketServiceImpl implements TicketService {
	/**
	* The number of seats in the requested level that are neither held nor reserved
	*
	* @param venueLevel a numeric venue level identifier to limit the search
	* @return the number of tickets available on the provided level
	*/
	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		return SeatsAvailable.numSeatsAvailable(venueLevel);
	}
	
	/**
	* Find and hold the best available seats for a customer
	*
	* @param numSeats the number of seats to find and hold
	* @param minLevel the minimum venue level
	* @param maxLevel the maximum venue level
	* @param customerEmail unique identifier for the customer
	* @return a SeatHold object identifying the specific seats and related
	information
	*/
	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel, String customerEmail) {
		return SeatFindHold.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmail);
	}
	
	/**
	* Commit seats held for a specific customer
	*
	* @param seatHoldId the seat hold identifier
	* @param customerEmail the email address of the customer to which the seat hold
	is assigned
	* @return a reservation confirmation code
	*/
	public String reserveSeats(int seatHoldId, String customerEmail) {
		return SeatReserve.reserveSeats(seatHoldId, customerEmail);
	}
}
