package com.project.ticketservice.service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.project.ticketservice.exception.TicketServiceException;
import com.project.ticketservice.model.LevelVO;
import com.project.ticketservice.model.Row;
import com.project.ticketservice.model.Seat;
import com.project.ticketservice.model.SeatHold;
import com.project.ticketservice.model.VenueLevel;
import com.project.ticketservice.util.TicketServiceUtil;
/**
 * @author Avirneni.Sai
 * This class to find the unreserved and free seat and hold the seat
 */
public class SeatFindHold {
	public static Map<Integer, SeatHold> seatHoldMap = new HashMap<Integer, SeatHold>(); //Map to hold seatHold Id and seatHold Object
	private static LevelVO[] detailsArray = VenueLevel.getDetailsArray();				 //Array of venue level details
	/**
	 * This is a method to find the free seats and hold them for a particular time
	 * @param numberOfSeats
	 * @param minLevel
	 * @param maxLevel
	 * @param customerEmail
	 * @return SeatHold Object
	 */
	public static SeatHold findAndHoldSeats(int numberOfSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel, String customerEmail)
	{	
		//Declaring and initializing the variables
		LevelVO genericVO = null;
		int totalReserverdSeats = 0;
		String strReserverdSeats = null;
		int levelMin=0;
		int levelMax=0;
		String errorMessage;
		SeatHold seatHold = new SeatHold();
		Map<String, String> reservedSeats = seatHold.getReservedSeats();
		try 
		{
			if(minLevel.isPresent()){
				levelMin=minLevel.get();
				levelMin = levelMin - 1;
			}
			if(maxLevel.isPresent()){
				levelMax=maxLevel.get();
				levelMax = levelMax - 1;
			}
			try{
				do {
					// Calling numSeatsAvailable method to know the number of seats available in the level
					if(SeatsAvailable.numSeatsAvailable(TicketServiceUtil.optionalConverter(levelMin)) >= numberOfSeats)
					{
						genericVO = detailsArray[levelMin];
						//Iterating the rows
						for(Row row : genericVO.getRows())
						{
							//Iterating the seats
							for(Seat seat : row.getSeats())
							{
								if(totalReserverdSeats==numberOfSeats){
									//if number of seats hold equal to number of seats required to hold
									seatHold.setLevelId(Integer.parseInt(genericVO.getLevelId()));
									seatHold.setSeatHoldId(seatHold.getSequenceId()); //setting seathold Id
									seatHold.setEmailId(customerEmail); //setting mail id
									seatHold.setMessage("SUCCESS");
									seatHoldMap.put(seatHold.getSeatHoldId(), seatHold);
									//returns SeatHold object
									return seatHold;
								}
								//check hold status and reserved status
								if (seat.getIsHold().equals("N") && seat.getIsReserved().equals("N"))
								{
									seat.putOnHold();
									if(strReserverdSeats == null)
										strReserverdSeats = String.valueOf(seat.getSeatNumber());
									else
										strReserverdSeats = strReserverdSeats + "," + seat.getSeatNumber();
									totalReserverdSeats++;
								}
							}
							reservedSeats.put(String.valueOf(row.getRowId()), strReserverdSeats);
							
 							if(totalReserverdSeats < numberOfSeats) {
								strReserverdSeats = null;
 							} else if(totalReserverdSeats==numberOfSeats){
 								break;
 							}
 							}
						if(totalReserverdSeats==numberOfSeats){
							//if number of seats hold equal to number of seats required to hold
							seatHold.setLevelId(Integer.parseInt(genericVO.getLevelId()));
							seatHold.setSeatHoldId(seatHold.getSequenceId()); //setting seathold Id
							seatHold.setEmailId(customerEmail); //setting mail id
							seatHold.setMessage("SUCCESS");
							seatHoldMap.put(seatHold.getSeatHoldId(), seatHold);
							System.out.println(seatHoldMap.get(seatHold.getSeatHoldId()).getEmailId());
							//returns SeatHold object
							return seatHold;
						}
					}else {
						levelMin++;
					}
				} while(levelMin <= levelMax);
			
				if(totalReserverdSeats==numberOfSeats){
			seatHold.setLevelId(Integer.parseInt(genericVO.getLevelId()));
			seatHold.setSeatHoldId(seatHold.getSequenceId());
			seatHold.setEmailId(customerEmail);
			seatHoldMap.put(seatHold.getSeatHoldId(), seatHold);
				}else{
					seatHold.setMessage("NOSEATS"); // No seats found to hold
				}
				
		}catch(ArrayIndexOutOfBoundsException ex){//catch block
			errorMessage="Error occured while processing";
			throw new TicketServiceException(errorMessage,ex.getCause());
		}
		}catch(TicketServiceException ex){
			System.out.println("Exception Cause:"+ex.getCause());
			System.out.println("Exception Message:"+ex.getMessage());
			System.exit(0);
			}
		return seatHold;
	}

}
