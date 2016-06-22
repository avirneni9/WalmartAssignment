package com.project.ticketservice.model;

/**
 * @author Avirneni.Sai
 * This is a model object for venue level details
 */
public class VenueLevel {
	private static LevelVO[] detailsArray = new LevelVO[4];
	
	public VenueLevel() {
		detailsArray[0] = new Orchestra("1", "Orchestra", 100, 25, 50);
		detailsArray[1] = new Main("2", "Main", 75, 20, 100);
		detailsArray[2] = new BalconyOne("3", "Balcony1", 50, 15, 100);
		detailsArray[3] = new BalconyTwo("4", "Balcony2", 40, 15, 100);
	}
	/**
	 * Getters and Setters for the variables.
	 * 
	 */
	public static LevelVO[] getDetailsArray() {
		return detailsArray;
	}
	public static void setDetailsArray(LevelVO[] detailsArray) {
		VenueLevel.detailsArray = detailsArray;
	}

}
