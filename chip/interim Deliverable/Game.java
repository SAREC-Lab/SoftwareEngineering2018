import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class Game extends Application 
{
	final int scale = 25;
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage chipStage) throws Exception 
	{
		// Generate New Pane
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 625, 625);
		chipStage.setScene(scene);
		chipStage.setTitle("My Chip Game");
		
		GridMap map = new GridMap();
		map.drawMap(root.getChildren(), scale);
		GridMap.drawMap();
	}
}
