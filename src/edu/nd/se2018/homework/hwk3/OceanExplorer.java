package edu.nd.se2018.homework.hwk3;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
	AnchorPane root;
	Scene scene;
	

	@Override
	public void start(Stage oceanStage) throws Exception {
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 500, 500);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ocean");
		oceanStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		

	}
}
