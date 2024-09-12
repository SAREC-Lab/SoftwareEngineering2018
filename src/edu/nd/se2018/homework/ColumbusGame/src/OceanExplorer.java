import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class OceanExplorer extends Application 
{
	final int scale = 25;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception 
	{
		// Generate New Pane
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 625, 625);
		oceanStage.setScene(scene);
		oceanStage.setTitle("My Island");
		
		OceanMap map = new OceanMap();
		map.drawMap(root.getChildren(), scale);
		oceanStage.show();
		
		// Instantiate Ship
		Ship ship = new Ship();
		
		// Draw the Ship
		Image shipImage = new Image("file:/Users/Dchao88/Documents/Software Engineering/ColumbusGame/src/Images/ColumbusShip.png", 25, 25, true, true);
		ImageView shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().getX());
		shipImageView.setY(ship.getShipLocation().getY());
		root.getChildren().add(shipImageView);
		
		// Generate Pirates
		PirateShip pirate1 = new PirateShip(scale);
		PirateShip pirate2 = new PirateShip(scale);
		
		ship.addObserver(pirate1);
		ship.addObserver(pirate2);
		root.getChildren().add(pirate1.getImageView());
		root.getChildren().add(pirate2.getImageView());
		
				
		startSailing(scene, ship, shipImageView, map);
	}
	
	private void startSailing(Scene scene, Ship ship, ImageView shipImageView, OceanMap map)
	{
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			//@Override
			public void handle(KeyEvent ke)
			{
				switch (ke.getCode())
				{
					case RIGHT:
						if (map.getStatus((int)ship.getShipLocation().getX()+1, (int)ship.getShipLocation().getY()) != 1)
							ship.goEast();
						break;
						
					case LEFT:
						if (map.getStatus((int)ship.getShipLocation().getX()-1, (int)ship.getShipLocation().getY()) != 1)
							ship.goWest();
						break;
						
					case UP:
						if (map.getStatus((int)ship.getShipLocation().getX(), (int)ship.getShipLocation().getY()-1) != 1)
							ship.goNorth();
						break;
						
					case DOWN:
						if (map.getStatus((int)ship.getShipLocation().getX(), (int)ship.getShipLocation().getY()+1) != 1)
							ship.goSouth();
						break;
						
					default:
						break;
				}
				shipImageView.setX(ship.getShipLocation().getX()*scale);
				shipImageView.setY(ship.getShipLocation().getY()*scale);
			}
		});
		
	}

}
