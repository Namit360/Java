package com.spring.model;

public class Inventory
{
	int inventoryId;
	int no_Of_Blankets;
	int no_Of_Towels;
	int no_Of_Toiletries;
	int no_Of_WaterBottles;
	public Inventory() {}
	public Inventory(int inventoryId, int no_Of_Blankets, int no_Of_Towels, int no_Of_Toiletries,
			int no_Of_WaterBottles) {
		this.inventoryId = inventoryId;
		this.no_Of_Blankets = no_Of_Blankets;
		this.no_Of_Towels = no_Of_Towels;
		this.no_Of_Toiletries = no_Of_Toiletries;
		this.no_Of_WaterBottles = no_Of_WaterBottles;
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public int getNo_Of_Blankets() {
		return no_Of_Blankets;
	}
	public void setNo_Of_Blankets(int no_Of_Blankets) {
		this.no_Of_Blankets = no_Of_Blankets;
	}
	public int getNo_Of_Towels() {
		return no_Of_Towels;
	}
	public void setNo_Of_Towels(int no_Of_Towels) {
		this.no_Of_Towels = no_Of_Towels;
	}
	public int getNo_Of_Toiletries() {
		return no_Of_Toiletries;
	}
	public void setNo_Of_Toiletries(int no_Of_Toiletries) {
		this.no_Of_Toiletries = no_Of_Toiletries;
	}
	public int getNo_Of_WaterBottles() {
		return no_Of_WaterBottles;
	}
	public void setNo_Of_WaterBottles(int no_Of_WaterBottles) {
		this.no_Of_WaterBottles = no_Of_WaterBottles;
	}	
}