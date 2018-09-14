package edu.nd.se2018.homework.hwk3;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import edu.nd.se2018.homework.hwk3.OceanMap;

public class OceanExplorer extends Application {
	AnchorPane root;
	Scene scene;
	OceanMap oceanMap;
	ImageView shipImageView;
	Image shipImage;
	

	@Override
	public void start(Stage oceanStage) throws Exception {
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 500, 500);
		oceanMap = new OceanMap();
		
		
		oceanMap.drawMap(root.getChildren(), 50);
		
		// Load Images
		shipImage = new Image("images\\ColombusShip.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oceanMap.getShipLocation()[0]*50);
		shipImageView.setY(oceanMap.getShipLocation()[1]*50);
		root.getChildren().add(shipImageView);
		
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ocean");
		oceanStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		

	}
}
