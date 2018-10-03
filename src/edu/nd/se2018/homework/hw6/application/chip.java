package application;

import java.util.Observable;

public class chip extends Observable{
	
	int xLocal = 240;
	int yLocal = 240;
	int keys = 0;
	
	public int getX() {
		return xLocal;
	}
	public int getY() {
		return yLocal;
	}
	public int getKey() {
		return keys;
	}

}
