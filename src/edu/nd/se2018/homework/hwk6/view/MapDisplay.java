package edu.nd.se2018.homework.hwk6.view;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Collection;
import java.util.Random;

import edu.nd.se2018.homework.hwk3.PirateShip;
import edu.nd.se2018.homework.hwk3.Ship;

public class MapDisplay {
	public int[][] map = new int[25][25];
	final int dimensions = 25;
	ImageView tileImageView, keyImageView;
	Image tileImage, keyImage;
	public int level = 1;
	ObservableList<Node> root;
	
	public void setBlocks( ) {
		Random random = new Random();
		for (int i = 0; i < 25; i++) {
			int x = random.ints(0, 24).findFirst().getAsInt();
			int y =  random.ints(0, 24).findFirst().getAsInt();
			while ((x == 0) && (y == 0)) {
				x = random.ints(0, 24).findFirst().getAsInt();
				y =  random.ints(0, 24).findFirst().getAsInt();
			}
			this.map[x][y]= 1;
		}
	}
	
	public void setLevel(int l) {
		level = l;
		int chips = level*5;
		Random random = new Random();
		for (int i = 0; i < chips; i++) {
			int x = random.ints(0, 24).findFirst().getAsInt();
			int y =  random.ints(0, 24).findFirst().getAsInt();
			while ((x == 0) && (y == 0) && (map[x][y] == 1)) {
				x = random.ints(0, 24).findFirst().getAsInt();
				y =  random.ints(0, 24).findFirst().getAsInt();
			}
			this.map[x][y] = 2;
		}
	}
	
	public void drawMap(ObservableList<Node> r, int scale) {
		root = r;
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				
				tileImage = new Image("/images/chip/textures/BlankTile.png", 50, 50, true, true);
				tileImageView = new ImageView(tileImage);
				tileImageView.setX(x * scale);
				tileImageView.setY(y * scale);
				root.add(tileImageView);
				
				/*if (map[x][y] != 1) {
					tileImage = new Image("/images/chip/textures/BlankTile.png", 50, 50, true, true);
					tileImageView = new ImageView(tileImage);
					tileImageView.setX(x * scale);
					tileImageView.setY(y * scale);
					root.add(tileImageView);
					this.map[x][y] = 0;
				}*/
				
				if (map[x][y] == 2) {
					keyImage = new Image("/images/chip/textures/chipItem.png", 50, 50, true, true);
					keyImageView = new ImageView(keyImage);
		
					keyImageView.setFitHeight(20);
					keyImageView.setFitWidth(20);
					keyImageView.setX(x * scale);
					keyImageView.setY(y * scale);
					root.add(keyImageView);
					
				}
				
				if (map[x][y] == 1) {
					rect.setFill(Color.BROWN);
					root.add(rect);
				}
				
				else if (map[x][y] != 2) {
					this.map[x][y] = 0;
				}
				/*if (map[x][y] == 0) {
					tileImage = new Image("/images/chip/textures/BlankTile.png", 50, 50, true, true);
					tileImageView = new ImageView(tileImage);
					tileImageView.setX(x * scale);
					tileImageView.setY(y * scale);
					root.add(tileImageView);
					this.map[x][y] = 0;
				}*/
			}
		}
	}
	
	public int[][] getMap() {
		return(this.map);
	}
	
	public void setMap(int x, int y, int value) {
		this.map[x][y] = value;
		//tileImage = new Image("/images/chip/textures/BlankTile.png", 50, 50, true, true);
		//tileImageView = new ImageView(tileImage);
		//root.remove(keyImage);
		//tileImageView.setFitHeight(20);
		//tileImageView.setFitWidth(20);
		//tileImageView.setX(x * 20);
		//tileImageView.setY(y * 20);
		//root.add(tileImageView);
		//drawMap(root, 20);
	}
	
	public void removeKey(int x, int y) {
		tileImage = new Image("/images/chip/textures/BlankTile.png", 50, 50, true, true);
		tileImageView = new ImageView(tileImage);
		//root.remove(keyImage);
		tileImageView.setFitHeight(20);
		tileImageView.setFitWidth(20);
		tileImageView.setX(x * 20);
		tileImageView.setY(y * 20);
		root.add(tileImageView);
	}
	
	public int getLevel() {
		return(this.level);
	}
	
}
