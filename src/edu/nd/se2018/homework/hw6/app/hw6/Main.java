package hw6;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import hw6.MapBuilder;

public class Main extends Application {
	ObservableList<Node> root = FXCollections.observableArrayList();
	MapBuilder map = new MapBuilder();
	int[][] gameGrid = new int[25][25];
	int scale = 25;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane base = new BorderPane();
			Scene scene = new Scene(base,625,625);
			gameGrid = map.buildLevel(2);
			map.drawLevel(root, scale);
			System.out.println("level 2");
			base.getChildren().addAll(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
