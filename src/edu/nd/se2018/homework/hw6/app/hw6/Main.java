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
	public int level;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane base = new AnchorPane();
			Scene scene = new Scene(base,625,625);
			gameGrid = map.buildLevel(2);
			map.drawLevel(root,scale,base);
			//System.out.println("level 2");
			
			primaryStage.setScene(scene);
			primaryStage.show();
			// build chip into the map
			chip _chip1 = new chip(base);
			level = 0;
			System.out.print(gameGrid[20][20]);
			_chip1.playChips(base, gameGrid, scene,level);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			/*}
			gameGrid = map.buildLevel(2);
			map.drawLevel(root, scale,base);
			level = 1;
			while(level == 1) {
				_chip1.playChips(base, gameGrid, scene,level);
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			if(level == 2) {
				// insert win behavior here
			}*/
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
