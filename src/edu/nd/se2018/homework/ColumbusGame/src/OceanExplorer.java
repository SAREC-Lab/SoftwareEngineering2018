import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OceanExplorer extends Application
{
	public static int WIDTH = 750;
	public static int HEIGHT = 750;
	
	private AnchorPane pane;
	private Scene scene;
	private OceanMap map;
	private Ship ship;
	private Pirate pirate;
	private ImageView shipImageView;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		pane = new AnchorPane();
		
		map = new OceanMap();
		map.drawMap(pane.getChildren(), 10);
		
		ship = new Ship(10, 10, map.getOceanMap());
		Image shipImg = new Image("file:main/resources/ColumbusShip.png", 30, 30, true, true);
		shipImageView = new ImageView(shipImg);
		shipImageView.setX(ship.getShipLocation().getX()*OceanMap.SCALING_FACTOR);
		shipImageView.setY(ship.getShipLocation().getY()*OceanMap.SCALING_FACTOR);
		pane.getChildren().add(shipImageView);
		
		pirate = new Pirate(0, 0, map.getOceanMap());
		pane.getChildren().add(pirate.getImageView());
		ship.addPirate(pirate);
		
		scene = new Scene(pane, WIDTH, HEIGHT);
		oceanStage.setScene(scene);
		oceanStage.setTitle("My Island");
		oceanStage.show();
		
		startSailing();
	}
	
	private void startSailing()
	{
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				}
				shipImageView.setX(ship.getShipLocation().x*OceanMap.SCALING_FACTOR);
				shipImageView.setY(ship.getShipLocation().y*OceanMap.SCALING_FACTOR);
				pirate.setImageViewPos();
			}
		});
	}
}

