package hwk4;

import java.awt.Point;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.layout.AnchorPane;

public class OceanExplorer extends Application {
	AnchorPane root;
	final private int cellSize = 28;
	final private int mazeSize = 23;
	boolean foundTarget = false;
	Scene scene;
	ImageView shipImageView, pirate1ImageView, pirate2ImageView;
	Image shipImage, pirate1Image, pirate2Image;
	OceanMap map = new OceanMap();
    Circle target;
    //Pane root;
    Point targetPoint;
    Ship columbusShip;
    Thread thread;
    int x = 10;
    int y = 10;
    int p1x;
    int p2x;
    int p1y;
    int p2y;
    Random rx = new Random();
    Random ry = new Random();
    PirateShip pirate1, pirate2;
    //scene = new Scene(root,mazeSize*cellSize + cellSize*2,mazeSize*cellSize + cellSize*2);
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();

		ObservableList<Node> myList = root.getChildren();
		map.drawMap(myList, cellSize);
		//columbusShip = new Ship(x, y, cellSize, map);
		map.drawIslands(myList, cellSize, x, y);
		columbusShip = new Ship(x, y, cellSize, map);

		int madeIsland = 0;
		while(madeIsland == 0) {
			p1x = rx.nextInt(25);
			p1y = ry.nextInt(25);
			if(map.seeSpace(p1x, p1y) == 0 && (p1x != x && p1y != y)) {
				pirate1 = new PirateShip(p1x, p1y, cellSize, map);
				madeIsland = 1;
			}
		}
		madeIsland = 0;
		while(madeIsland == 0) {
			p2x = rx.nextInt(25);
			p2y = ry.nextInt(25);
			if(map.seeSpace(p2x, p2y) == 0 && (p2x != x && p2y != y)) {
				pirate2 = new PirateShip(p2x, p2y, cellSize, map);
				madeIsland = 1;
			}
		}
		columbusShip.addObserver(pirate1);
		columbusShip.addObserver(pirate2);
		loadImages();
		scene = new Scene(root,mazeSize*cellSize + cellSize*2,mazeSize*cellSize + cellSize*2);
		stage.setTitle("Columbus Game");
		stage.setScene(scene);

		stage.show();
		startSailing(stage);
	}

	private void loadImages(){



		pirate1Image = new Image("hwk4\\images\\pirateship.gif",cellSize, cellSize, false, true);
		pirate1ImageView = new ImageView(pirate1Image);
		pirate1ImageView.setX(pirate1.getLocation().x*cellSize);
		pirate1ImageView.setY(pirate1.getLocation().y*cellSize);

		root.getChildren().add(pirate1ImageView);

		pirate2Image = new Image("hwk4\\images\\pirateship.gif",cellSize, cellSize, false, true);
		pirate2ImageView = new ImageView(pirate2Image);
		pirate2ImageView.setX(pirate2.getLocation().x*cellSize);
		pirate2ImageView.setY(pirate2.getLocation().y*cellSize);

		// Load "found" target image
		//foundImage = new Image("hwk4\\images\\ColumbusShip.png",cellSize, cellSize, false, true);
		//foundImageView = new ImageView(foundImage);
		//foundImageView.setX(columbusShip.getLocation().x*cellSize);
		//foundImageView.setY(columbusShip.getLocation().y*cellSize);
		// set current target image to "not found yet" image
		root.getChildren().add(pirate2ImageView);

		shipImage = new Image("hwk4\\images\\ColumbusShip.png",cellSize, cellSize, false, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(columbusShip.getLocation().x*cellSize);
		shipImageView.setY(columbusShip.getLocation().y*cellSize);

		// Load "found" target image

		// set current target image to "not found yet" image
		root.getChildren().add(shipImageView);

    }

	private void startSailing(Stage stage){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		@Override
		public void handle(KeyEvent ke) {
			switch(ke.getCode()){
				case RIGHT:
					columbusShip.goEast();
					break;
				case LEFT:
					columbusShip.goWest();
					break;
				case UP:
					columbusShip.goNorth();
					break;
				case DOWN:
					columbusShip.goSouth();
					break;
				default:
					break;
			}
			shipImageView.setX(columbusShip.getLocation().x*cellSize);
			shipImageView.setY(columbusShip.getLocation().y*cellSize);

			pirate1ImageView.setX(pirate1.getLocation().x*cellSize);
			pirate1ImageView.setY(pirate1.getLocation().y*cellSize);

			pirate2ImageView.setX(pirate2.getLocation().x*cellSize);
			pirate2ImageView.setY(pirate2.getLocation().y*cellSize);

			if(columbusShip.getLocation().x == pirate1.getLocation().x && columbusShip.getLocation().y == pirate1.getLocation().y) {
				try {
		            Thread.sleep(1500);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
				stage.close();
			}
			if(columbusShip.getLocation().x == pirate2.getLocation().x && columbusShip.getLocation().y == pirate2.getLocation().y) {
				try {
		            Thread.sleep(1500);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
				stage.close();
			}

		}
	});
	}
	public static void main(String[] args) {
     	launch(args);
    }
}
