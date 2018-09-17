package edu.nd.se2018.homework.ColumbusGame;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class OceanExplorer extends Application{
	
	Pane root;
	
	public static void main(String [ ] args) {
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		// TODO Auto-generated method stub
		// Step 2b
		root = new Pane();
		OceanMap oceanMap = new OceanMap();
		int scale = 5;
		// Step 2c
		Scene scene = new Scene(root, 800, 800);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ship Explorer");
		
		oceanStage.show();
	}
}
