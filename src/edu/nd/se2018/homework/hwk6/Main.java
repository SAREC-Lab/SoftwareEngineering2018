package edu.nd.se2018.homework.hwk6;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.stage.Stage;
import edu.nd.se2018.homework.hwk6.controller.ChipController;
import edu.nd.se2018.homework.hwk6.model.ChipModel;
import edu.nd.se2018.homework.hwk6.view.*;

public class Main extends Application {
	AnchorPane root;
	Scene scene;
	MapDisplay gameMap;
	ImageView[][] tiles;
	Image tileImage;
	int scale = 20;
	//ChipModel chip;
	ChipView chipView;
	ChipController chipController;

	@Override
	public void start(Stage gameStage) throws Exception {
		root = new AnchorPane();
		Scene scene = new Scene(root, 500, 500);
		gameMap = new MapDisplay();
		
		gameMap.setBlocks();
		gameMap.drawMap(root.getChildren(), 20);

		/*chip = new ChipModel(0, 0, gameMap.getMap());
		chipView = new ChipView(chip);
		chip.attachView(chipView);*/
		chipController = new ChipController(gameMap.getMap());
		
		
		root.getChildren().add(chipController.getImageView());
		
		
		gameStage.setScene(scene);
		gameStage.setTitle("Chip's Challenge");
		gameStage.show();
		
		startGame(scene);
	}
	
	private void startGame(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				chipController.moveEvent(event);
				
	}
			
		});
		
	}

	
	public static void main(String[] args) {
		launch(args);

	}


}
