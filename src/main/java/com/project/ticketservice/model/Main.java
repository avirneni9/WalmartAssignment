package com.project.ticketservice.model;
/**
 * @author Avirneni.Lakshman
 *This is a Main level class
 */
public class Main extends LevelVO {
	/**
	 * This is a constructor of Main level class
	 * 
	 */
	public Main(String levelId, String LevelName, Integer price, Integer totalRows, Integer seatsPerRow) {
		super(levelId, LevelName, price, totalRows, seatsPerRow);
	}
}
