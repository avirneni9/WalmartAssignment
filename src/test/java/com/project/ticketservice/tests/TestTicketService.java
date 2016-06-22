package com.project.ticketservice.tests;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import com.project.ticketservice.model.SeatHold;
import com.project.ticketservice.serviceimpl.TicketService;
import com.project.ticketservice.serviceimpl.TicketServiceImpl;

public class TestTicketService {
	private TicketService ticketService = new TicketServiceImpl();
	@Test
	   public void testOneTicketService() throws InterruptedException {
	      Optional<Integer> venueLevel=Optional.of(new Integer(3));
	      int numOfSeats=ticketService.numSeatsAvailable(venueLevel);
	      assertEquals(18, numOfSeats);
	      String eMailId="test@wipro.com";
	      SeatHold seatHold=ticketService.findAndHoldSeats(numOfSeats, venueLevel, venueLevel, eMailId);
	      assertEquals("SUCCESS", seatHold.getMessage());
	      Thread.sleep(100000);
	      String confirmation=ticketService.reserveSeats(seatHold.getSeatHoldId(),eMailId);
	      assertEquals("NOSEATS", confirmation);
	      seatHold=ticketService.findAndHoldSeats(numOfSeats, venueLevel, venueLevel, eMailId);
	      assertEquals("SUCCESS", seatHold.getMessage());
	      
	      
	   }
}
