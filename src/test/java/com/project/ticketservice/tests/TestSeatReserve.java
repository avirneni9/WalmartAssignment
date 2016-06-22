package com.project.ticketservice.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.project.ticketservice.serviceimpl.TicketService;
import com.project.ticketservice.serviceimpl.TicketServiceImpl;

public class TestSeatReserve {
	private TicketService ticketService = new TicketServiceImpl();
	@Test
	   public void testOneSeatReserve() {
	      int seatHoldId=5001;
	      String eMailId="test@wipro.com";
	      String confirmation=ticketService.reserveSeats(seatHoldId,eMailId);
	      assertEquals("NOSEATS", confirmation);
	   }
	
	@Test
	   public void testTwoSeatReserve() {
	      int seatHoldId=7001;
	      String eMailId="test@wipro.com";
	      String confirmation=ticketService.reserveSeats(seatHoldId,eMailId);
	      assertEquals("NOSEATS", confirmation);
	   }
	
	@Test
	   public void testThreeSeatReserve() {
	      int seatHoldId=5001;
	      String eMailId="test@wipro.com";
	      String confirmation=ticketService.reserveSeats(seatHoldId,eMailId);
	      assertEquals("NOSEATS", confirmation);
	   }
}
