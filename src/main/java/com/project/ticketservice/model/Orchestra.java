package com.project.ticketservice.model;
/**
 * @author Avirneni.Lakshman
 *This is a Orchestra level class
 */
public class Orchestra extends LevelVO {
	/**
	 * This is a constructor of Orchestra level class
	 * 
	 */
	public Orchestra(String levelId, String LevelName, Integer price, Integer totalRows, Integer seatsPerRow) {
		super(levelId, LevelName, price, totalRows, seatsPerRow);
	}
}
