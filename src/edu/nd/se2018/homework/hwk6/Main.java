package edu.nd.se2018.homework.hwk6;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import edu.nd.se2018.homework.hwk6.controller.ChipController;
import edu.nd.se2018.homework.hwk6.controller.MonsterController;
import edu.nd.se2018.homework.hwk6.controller.MoveHorizontal;
import edu.nd.se2018.homework.hwk6.controller.MoveVertical;
import edu.nd.se2018.homework.hwk6.model.MonsterModel;
import edu.nd.se2018.homework.hwk6.view.*;

public class Main extends Application {
	AnchorPane root;
	Scene scene;
	MapDisplay gameMap;
	ImageView[][] tiles;
	Image tileImage;
	int scale = 20;
	ChipView chipView;
	ChipController chipController;
	MonsterController monsterController1, monsterController2;
	MonsterModel monster1, monster2;
	int level = 1;

	@Override
	public void start(Stage gameStage) throws Exception {
		root = new AnchorPane();
		Scene scene = new Scene(root, 500, 500);
		gameMap = new MapDisplay();
		
		gameMap.setBlocks();
		gameMap.setLevel(level);
		gameMap.drawMap(root.getChildren(), 20);


		chipController = new ChipController(gameMap);
		monsterController1 = new MonsterController(gameMap, new MoveVertical(), 20, 10);
		monsterController2 = new MonsterController(gameMap, new MoveHorizontal(), 10, 15);
		
		monster1 = monsterController1.getModel();
		monster1.addObserver(chipController.getModel());
		
		monster2 = monsterController2.getModel();
		monster2.addObserver(chipController.getModel());
		
		root.getChildren().add(chipController.getImageView());
		root.getChildren().add(monsterController1.getImageView());
		root.getChildren().add(monsterController2.getImageView());
		
		gameStage.setScene(scene);
		gameStage.setTitle("Chip's Challenge");
		gameStage.show();
		
		 gameStage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
		        if (event.getCode() == KeyCode.ESCAPE) {
		            gameStage.close();
		        }
		    });
		
		startGame(scene);
		
		new AnimationTimer(){
			//@Override
			int count = 0;
			public void handle(long now) {
				if (count % 10 == 0) {
					monsterController1.runStrategy();
					monsterController2.runStrategy();
				}
				count++;
			}
		}.start();
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
