package com.project.ticketservice.userview;

/**
 * @author Avirneni.Sai
 * This is the main class for execution
 */
public class UserStart {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		int option=0;
		TicketServiceOptions options=new TicketServiceOptions();
		do{
			option=options.startMenu();
			switch(option){
			case 1:
					int optedLevel=options.availableMenu();
					if(optedLevel==0){
						System.out.println("Thank you");
						System.exit(0);
					}
					options.seatsAvailabiltyOption(optedLevel);
					break;
			case 2:
				options.findAndHoldOption();
					break;
					
			case 3:
				options.reserveOption();
					break;
					
			case 0:
					System.out.println("Thank you");
					System.exit(0);
					break;
					
			default: System.out.println("Invalid Input");
					break;
					
			}
			
		}while(option!=0);
		
	}
}
