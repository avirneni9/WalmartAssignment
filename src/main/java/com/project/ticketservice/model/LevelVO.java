package com.project.ticketservice.model;
/**
 * @author Avirneni.Lakshman
 * This is a model object for venue level
 */
public class LevelVO {
	/**
	 * Variables which represent the properties of GenericVO. 
	 */
	//Id of a venue level ranges from 1 to 4
	private String levelId; 
	//Name of a venue level Orchestra, Main, Balcony1, Balcony2
	private String levelName;
	//price of each seat depends on the level
	private Integer price;
	//Rows present in a particular level
	private Integer totalRows;
	//Number of seats per each row per in a particular level
	private Integer seatsPerRow;
	//Array of rows in a level
	private Row[] rows = null;
	/**
	 * Constructor of GenericVO class 
	 */
	public LevelVO(String levelId, String LevelName, Integer price, Integer totalRows, Integer seatsPerRow) {
		this.levelId = levelId;
		this.levelName = LevelName;
		this.price = price;
		this.totalRows = totalRows;
		this.seatsPerRow = seatsPerRow;
		rows = new Row[this.totalRows];
		for(int index = 0; index < rows.length; index++) {
			rows[index] = new Row(index, seatsPerRow);
		}
	}
	/**
	 * Getters and Setters for the Class variables.
	 * 
	 */
	public String getLevelId() {
		return levelId;
	}
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	public Integer getSeatsPerRow() {
		return seatsPerRow;
	}
	public void setSeatsPerRow(Integer seatsPerRow) {
		this.seatsPerRow = seatsPerRow;
	}
	public Row[] getRows() {
		return rows;
	}
	public void setRows(Row[] rows) {
		this.rows = rows;
	}
}


