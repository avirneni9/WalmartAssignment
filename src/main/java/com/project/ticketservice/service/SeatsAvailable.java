package com.project.ticketservice.service;

import java.util.Optional;

import com.project.ticketservice.exception.TicketServiceException;
import com.project.ticketservice.model.LevelVO;
import com.project.ticketservice.model.Row;
import com.project.ticketservice.model.Seat;
import com.project.ticketservice.model.VenueLevel;

/**
 * @author Avirneni.Sai
 * This class identifies the available seats in the venue level
 */
public class SeatsAvailable {
	@SuppressWarnings("static-access")
	private static LevelVO[] detailsArray = new VenueLevel().getDetailsArray();
	
	/**
	 * @param venueLevel
	 * @return number of available seats
	 */
	public static int numSeatsAvailable(Optional<Integer> venueLevel)
		{
		int totalNumberOfSeats = 0;
		int optedLevel=0;
		String errorMessage;
		try{
		if(venueLevel.isPresent()){
			optedLevel=venueLevel.get();
		}
		LevelVO genericVO = detailsArray[optedLevel];
		try{
		for(Row row : genericVO.getRows()){
			for(Seat seat: row.getSeats()){
				if(seat.getIsHold().equals("N") && seat.getIsReserved().equals("N")){
					totalNumberOfSeats++;
				}
			}
		}
		}catch(ArrayIndexOutOfBoundsException ex){
			errorMessage="Exception occurred while processing ";
			throw new TicketServiceException(errorMessage,ex.getCause());
		}catch(NullPointerException ex){
			errorMessage="Exception occurred while processing ";
			throw new TicketServiceException(errorMessage,ex.getCause());
		}catch(Exception ex){
			errorMessage="Exception occurred while processing ";
			throw new TicketServiceException(errorMessage,ex.getCause());
		}
		}catch(TicketServiceException ex){
		System.out.println("Exception Cause:"+ex.getCause());
		System.out.println("Exception Message:"+ex.getMessage());
		System.exit(0);
		}
		return totalNumberOfSeats;
	}
	
}
