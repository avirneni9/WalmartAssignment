package com.project.ticketservice.userview;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.ticketservice.model.SeatHold;
import com.project.ticketservice.serviceimpl.TicketService;
import com.project.ticketservice.serviceimpl.TicketServiceImpl;
import com.project.ticketservice.util.TicketServiceUtil;

/**
 * @author Avirneni.Sai
 * This class is for the options that are displayed
 */
public class TicketServiceOptions {
	private TicketService ticketService = new TicketServiceImpl();
	Scanner input = new Scanner(System.in);
	int userInput=0;
	
	/**
	 * @return the user input
	 */
	public int startMenu(){
		do{
			System.out.println("Please select the service below : \n1. View Available seats\n2. Hold\n3. Reserve\nZero to Exit");
			while (!input.hasNextInt()) 
			{        
				input.next(); // Read and discard offending non-int input
			    System.out.print("Please enter an integer: "); // Re-prompt
			}
			userInput=input.nextInt();
		}while(userInput<0 || userInput>3);
		return userInput;
	}
	
	/**
	 * @return level entered by the user
	 */
	public int availableMenu(){
		do{
			System.out.println("Please select the Level to view the available seats"+
					"\n1 - Orchestra\n2 - Main\n3 - Balcony 1\n4 - Balacony 2");
			while (!input.hasNextInt()) 
			{        
				input.next(); // Read and discard offending non-int input
			    System.out.print("Please enter an integer: "); // Re-prompt
			}
			userInput=input.nextInt();
		}while(userInput<1 || userInput>4);
		return userInput;
	}
	
	/**
	 * @return minimum level to hold
	 */
	public int holdMinLevel(){
		int minLevel=0;
				
		do{
			System.out.println("Please select the Minimum Level to be available to hold from below levels "+
					"\n1 - Orchestra\n2 - Main\n3 - Balcony 1\n4 - Balacony 2\nZero to Exit");
			while (!input.hasNextInt()) 
			{        
				input.next(); // Read and discard offending non-int input
			    System.out.print("Please enter an integer: "); // Re-prompt
			}
			minLevel=input.nextInt();
		}while(minLevel<0 || minLevel>4);
		return minLevel;
	}
	
	/**
	 * @param minLevel
	 * @return max level to hold
	 */
	public int holdMaxLevel(int minLevel){
		int maxLevel=0;
		do{
			System.out.println("Please select the Maximum Level to be available to hold from below levels "+
					"\n1 - Orchestra\n2 - Main\n3 - Balcony 1\n4 - Balacony 2\nZero to Exit");
			while (!input.hasNextInt()) 
			{        
				input.next(); // Read and discard offending non-int input
			    System.out.print("Please enter an integer: "); // Re-prompt
			}
			maxLevel=input.nextInt();
		}while((maxLevel<0 || maxLevel>4) || (maxLevel<minLevel));
		return maxLevel;
	}
	
	
	/**
	 * this method is process the reserve option
	 */
	public void reserveOption() {
		try{
		String eMail;
		String confirmationCode="";
		int seatHoldId=0;
		System.out.println("Please enter valid Seat Hold Id option");
		while (!input.hasNextInt()) 
		{        
			input.next(); // Read and discard offending non-int input
		    System.out.print("Please enter an integer: "); // Re-prompt
		}
		seatHoldId=input.nextInt();
		do{
			System.out.println("Please enter valid email address");
			eMail=input.next();
		}while(!TicketServiceUtil.emailIdValidation(eMail));
		//call reserveSeats method to process
		confirmationCode = ticketService.reserveSeats(seatHoldId, eMail);
		if(confirmationCode.equals("NOSEATS")){
			System.out.println("No Seats found with the details provided");
		}else{
		System.out.println("confirmationCode : " + confirmationCode);
		}
		}catch(InputMismatchException ex){
			System.out.println("Exception Cause:"+ex.getCause());
			System.out.println("Exception Message:"+ex.getMessage());
			System.exit(0);
		}catch(Exception ex){
			System.out.println("Exception Cause:"+ex.getCause());
			System.out.println("Exception Message:"+ex.getMessage());
			System.exit(0);
		}
	}

	/**
	 * this method is to process the findAndHold option
	 */
	public void findAndHoldOption() {
		try{
		String eMail;
		int numberOfSeats = 0;
		int maxLevel=0;
		int minLevel=this.holdMinLevel();
		if(minLevel==0){
			System.out.println("Thank you");
			System.exit(0);
		}
		maxLevel=this.holdMaxLevel(minLevel);
		if(maxLevel==0){
			System.out.println("Thank you");
			System.exit(0);
		}
		do{
		System.out.println("Please enter number of seats (maxmum number of seats to hold is 5):");
		while (!input.hasNextInt()) 
		{        
			input.next(); // Read and discard offending non-int input
		    System.out.print("Please enter an integer: "); // Re-prompt
		}
		numberOfSeats=input.nextInt();
		}while(numberOfSeats<0 || numberOfSeats>5);
		do{
			System.out.println("Please enter valid email address");
			eMail=input.next();
		}while(!TicketServiceUtil.emailIdValidation(eMail));
		//call findAndHoldSeats to process
		SeatHold seatHold = ticketService.findAndHoldSeats(new Integer(numberOfSeats), 
							TicketServiceUtil.optionalConverter(minLevel), 
							TicketServiceUtil.optionalConverter(maxLevel), 
							eMail);
		if(!seatHold.getMessage().equals("NOSEATS")){
		System.out.println(" Hold Id : " + seatHold.getSeatHoldId());
		}
		else{
			System.out.println("No Available seats for your choice");
		}
		}catch(Exception ex){
				System.out.println("Exception Cause:"+ex.getCause());
				System.out.println("Exception Message:"+ex.getMessage());
				System.exit(0);
		}
	}

	
	/**
	 * This method to process seats available option
	 * @param venueLevel
	 */
	public void seatsAvailabiltyOption(int venueLevel) {
		//call numSeatsAvailable method to process
		try{
		int availableSeats=ticketService.numSeatsAvailable(TicketServiceUtil.optionalConverter(venueLevel-1));
		System.out.println("Available seats in level " + venueLevel + " : " + availableSeats);
	}catch(Exception ex){
		System.out.println("Exception Cause:"+ex.getCause());
		System.out.println("Exception Message:"+ex.getMessage());
		System.exit(0);
}
	}
		
		
		
}
