package edu.nd.se2018.homework.chip;

public class Chip {
	
	private int positionX;
	private int positionY;
	
	public Chip(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
		
	public void moveLeft() {
		this.positionX--;
	}
	
	public void moveRight() {
		this.positionX++;
	}
	
	public void moveUp() {
		this.positionY--;
	}
	
	public void moveDown() {
		this.positionY++;
	}
	
	public int getPositionX() { return this.positionX; }
	
	public int getPositionY() { return this.positionY; }
	
}
