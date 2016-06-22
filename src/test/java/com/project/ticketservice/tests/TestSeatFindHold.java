package com.project.ticketservice.tests;
import org.junit.Test;

import com.project.ticketservice.model.SeatHold;
import com.project.ticketservice.serviceimpl.TicketService;
import com.project.ticketservice.serviceimpl.TicketServiceImpl;

import static org.junit.Assert.*;

import java.util.Optional;

public class TestSeatFindHold {
	private TicketService ticketService = new TicketServiceImpl();
	@Test
	   public void testOneSeatFindHold() {
	      Optional<Integer> minLevel=Optional.of(new Integer(1));
	      Optional<Integer> maxLevel=Optional.of(new Integer(1));
	      int numSeats=2500;
	      String eMailId="test@wipro.com";
	      SeatHold seatHold=ticketService.findAndHoldSeats(numSeats, minLevel, maxLevel, eMailId);
	      assertEquals("NOSEATS", seatHold.getMessage());
	   }
	
	@Test
	   public void testTwoSeatFindHold() {
	      Optional<Integer> minLevel=Optional.of(new Integer(2));
	      Optional<Integer> maxLevel=Optional.of(new Integer(3));
	      int numSeats=10;
	      String eMailId="test@wipro.com";
	      SeatHold seatHold=ticketService.findAndHoldSeats(numSeats, minLevel, maxLevel, eMailId);
	      assertEquals("SUCCESS", seatHold.getMessage());
	   }
	
	@Test
	   public void testThreeSeatFindHold() {
	      Optional<Integer> minLevel=Optional.of(new Integer(2));
	      Optional<Integer> maxLevel=Optional.of(new Integer(3));
	      int numSeats=5000;
	      String eMailId="test@wipro.com";
	      SeatHold seatHold=ticketService.findAndHoldSeats(numSeats, minLevel, maxLevel, eMailId);
	      assertEquals("NOSEATS", seatHold.getMessage());
	   }
	
	@Test
	   public void testFourSeatFindHold() {
	      Optional<Integer> minLevel=Optional.of(new Integer(1));
	      Optional<Integer> maxLevel=Optional.of(new Integer(1));
	      int numSeats=10;
	      String eMailId="test@wipro.com";
	      SeatHold seatHold=ticketService.findAndHoldSeats(numSeats, minLevel, maxLevel, eMailId);
	      assertEquals("SUCCESS", seatHold.getMessage());
	   }
}
