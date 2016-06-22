package com.project.ticketservice.service;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.project.ticketservice.exception.TicketServiceException;
import com.project.ticketservice.model.LevelVO;
import com.project.ticketservice.model.Row;
import com.project.ticketservice.model.Seat;
import com.project.ticketservice.model.SeatHold;
import com.project.ticketservice.model.VenueLevel;

/**
 * @author Avirneni.Sai
 * This class reserve the seats that are on hold based on the SeatHoldId provided
 */
public class SeatReserve {
	private static LevelVO[] detailsArray = VenueLevel.getDetailsArray();
	private static  Map<Integer, SeatHold> seatHoldMap = SeatFindHold.seatHoldMap;
	
	/**
	 * @param seatHoldId
	 * @param customerEmail
	 * @return true if seatHold Id exists or false
	 */
	public static boolean seatHoldVerification(int seatHoldId, String customerEmail){
		//check seatHold Id present in seatHoldMap
		try{
		if(seatHoldMap.containsKey(new Integer(seatHoldId))){
			SeatHold seatHold = seatHoldMap.get(seatHoldId);
			if(seatHold.getEmailId().matches(customerEmail)){ //check mail id provided matches with the existing one
				return true;
			}
		}else{
			return false;
		}
		}catch(Exception ex){
			System.out.println("Exception Cause:"+ex.getCause());
			System.out.println("Exception Message:"+ex.getMessage());
			System.exit(0);
	}
		
		return false;
		
	}
	
	/**
	 * @param seatHoldId
	 * @param customerEmail
	 * @return confirmation code
	 */
	@SuppressWarnings("rawtypes")
	public static String reserveSeats(int seatHoldId, String customerEmail)
	{
		String errorMessage; //error message to store to display
		try{		
		if(seatHoldVerification(seatHoldId, customerEmail))	{ 
		//Declaring and initializing variables	
		int numOfSeats=0;	
		SeatHold seatHold = seatHoldMap.get(seatHoldId);
		Map<String, String> reservedSeats = seatHold.getReservedSeats();
		Set<Map.Entry<String, String>> entrySet = reservedSeats.entrySet();
			try{
			for (Entry entry : entrySet)
				{
				   String rowId = (String) entry.getKey();
				   String strReservedSeats = (String) entry.getValue();
				   String[] arrStrReservedSeats = strReservedSeats.split(",");
				   LevelVO genericVO = detailsArray[seatHold.getLevelId() - 1];
				   Row row = genericVO.getRows()[Integer.parseInt(rowId)-1];
				   Seat[] arrSeats = row.getSeats();
							for(int index = 0; index < arrStrReservedSeats.length; index++) {
							Seat seat = arrSeats[Integer.parseInt(arrStrReservedSeats[index]) - 1];
							if(seat.getIsHold().equals("Y") && seat.getIsReserved().equals("N")) {
									seat.setIsReserved("Y");
									numOfSeats++;
								}
							}
				}
			
				seatHoldMap.remove(seatHoldId);
				if(numOfSeats>0){
				return String.valueOf(seatHold.getSequenceId());
				}else{
					return "NOSEATS"; //returns if no seats are on hold
				}
			}
			catch(ArrayIndexOutOfBoundsException ex){
				errorMessage="Error occured while processing";
				throw new TicketServiceException(errorMessage,ex.getCause());
			}catch(Exception ex){
				errorMessage="Error occured while processing";
				throw new TicketServiceException(errorMessage,ex.getCause());
			}
		}
		}catch(TicketServiceException ex){
			System.out.println("Exception Cause:"+ex.getCause());
			System.out.println("Exception Message:"+ex.getMessage());
			System.exit(0);
		}
		return "NOSEATS";

}
}
