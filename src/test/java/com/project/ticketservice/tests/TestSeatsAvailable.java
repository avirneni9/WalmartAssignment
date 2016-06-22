/**
 * 
 */
package com.project.ticketservice.tests;

import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

import com.project.ticketservice.serviceimpl.TicketService;
import com.project.ticketservice.serviceimpl.TicketServiceImpl;

/**
 * @author Avirneni.Sai
 *
 */
public class TestSeatsAvailable {
	private TicketService ticketService = new TicketServiceImpl();
	@Test
	   public void testOneSeatsAvailable() {
	      Optional<Integer> venueLevel=Optional.of(new Integer(1));
	      int numOfSeats=ticketService.numSeatsAvailable(venueLevel);
	      assertEquals(1990, numOfSeats);
	   }
	
	@Test
	   public void testTwoSeatsAvailable() {
	      Optional<Integer> venueLevel=Optional.of(new Integer(3));
	      int numOfSeats=ticketService.numSeatsAvailable(venueLevel);
	      assertEquals(1500, numOfSeats);
	   }
	
}
