package hw6;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import hw6.MapBuilder;

public class Main extends Application {
	ObservableList<Node> root = FXCollections.observableArrayList();
	MapBuilder map = new MapBuilder();
	int[][] gameGrid = new int[25][25];
	int scale = 25;
	public int level = 1;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane base = new AnchorPane();
			Scene scene = new Scene(base,625,625);
			gameGrid = map.buildLevel(level);
			map.drawLevel(root,scale,base);
			//System.out.println("level 2");
			
			primaryStage.setScene(scene);
			primaryStage.show();
			// build chip into the map
			chip _chip1 = new chip(base);
			alien _alien = new alien(base,gameGrid);
			_chip1.addObserver(_alien);
			//System.out.print(gameGrid[20][20]);
			_chip1.playChips(base, gameGrid, scene,level,primaryStage);
		

			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
