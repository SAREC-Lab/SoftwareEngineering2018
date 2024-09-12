import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Node;
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
		Scene scene = new Scene(root, 675, 675);
		Stage level1 = new Stage();
		level1 = chipStage;
			
		// Initialize Level 1
		level1.setScene(scene);
		level1.setTitle("My Chip Game Level 1");
			
		GridMap map = new GridMap();
		map.drawMap(root.getChildren(), scale, 1);
			
		level1.show();
			
		Chip chip = new Chip();
		
		// Draw Chip
		Image chipImage = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/chip/chipsChallenge/src/textures/chipDown.png", scale, scale, true, true);
		ImageView chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getPosition().getX());
		chipImageView.setY(chip.getPosition().getY());
		root.getChildren().add(chipImageView);
			
		// Play Level 1
		playChips(scene, chip, chipImageView, map, root.getChildren(), level1);
		
		// Initialize Level 2
		Stage level2 = new Stage();
		level2 = chipStage;
		
		level2.setScene(scene);
		level2.setTitle("My Chip Game Level 2");
				
		GridMap map2 = new GridMap();
		map2.drawMap(root.getChildren(), scale, 1);
				
		level2.show();
			
		Chip chip2 = new Chip();
				
		// Draw Chip
		Image chipImage2 = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/chip/chipsChallenge/src/textures/chipDown.png", scale, scale, true, true);
		ImageView chipImageView2 = new ImageView(chipImage2);
		chipImageView2.setX(chip2.getPosition().getX());
		chipImageView2.setY(chip2.getPosition().getY());
		root.getChildren().add(chipImageView2);
				
		// Play Level 1
		playChips(scene, chip2, chipImageView2, map2, root.getChildren(), level2);
				
	}
	
	public void playChips(Scene scene, Chip chip, ImageView chipImageView, GridMap map, ObservableList<Node> root, Stage gameStage)
	{
		///
		Image chipRight = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/chip/chipsChallenge/src/textures/chipRight.png", scale, scale, true, true);
		Image chipLeft = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/chip/chipsChallenge/src/textures/chipLeft.png", scale, scale, true, true);
		Image chipUp = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/chip/chipsChallenge/src/textures/chipUp.png", scale, scale, true, true);
		Image chipDown = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/chip/chipsChallenge/src/textures/chipDown.png", scale, scale, true, true);
		//int positionValue = 0;
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			//@Override
			public void handle(KeyEvent ke)
			{
				switch (ke.getCode())
				{
					case RIGHT:
						int positionValue = map.getStatus((int)chip.getPosition().getX()+1, (int)chip.getPosition().getY());
						if (positionValue == 1)
						{
							chip.goRight();
							chipImageView.setImage(chipRight);
						}
						else if (positionValue == 3)
						{
							chip.goRight();
							map.removeKey((int)chip.getPosition().getX()+1, (int)chip.getPosition().getY(), 3);
							chip.addKey(3);
							chipImageView.setImage(chipRight);
							chipImageView.toFront();
						}
						else if (positionValue == 5)
						{
							chip.goRight();
							map.removeKey((int)chip.getPosition().getX()+1, (int)chip.getPosition().getY(), 5);
							chip.addKey(5);
							chipImageView.setImage(chipRight);
							chipImageView.toFront();
						}
						else if (positionValue == 7)
						{
							chip.goRight();
							map.removeKey((int)chip.getPosition().getX()+1, (int)chip.getPosition().getY(), 7);
							chip.addKey(7);
							chipImageView.setImage(chipRight);
							chipImageView.toFront();
						}
						else if (positionValue == 9)
						{
							chip.goRight();
							map.removeKey((int)chip.getPosition().getX()+1, (int)chip.getPosition().getY(), 9);
							chip.addKey(9);
							chipImageView.setImage(chipRight);
							chipImageView.toFront();
						}
						else if (positionValue == 10)
						{
							chip.goRight();
							chipImageView.setImage(chipRight);
							foundPortal(gameStage);
						}
						else if (positionValue % 2 == 0)
						{
							if (chip.getKeys().contains(positionValue))
							{
								openWall((int)chip.getPosition().getX()+1, (int)chip.getPosition().getY(), map, root);
								chip.goRight();
								chipImageView.setImage(chipRight);
								chipImageView.toFront();
							}
						}
						break;
						
					case LEFT:
						int positionValue1 = map.getStatus((int)chip.getPosition().getX()-1, (int)chip.getPosition().getY());
						if (positionValue1 == 1)
						{
							chip.goLeft();
							chipImageView.setImage(chipLeft);
						}
						else if (positionValue1 == 3)
						{
							chip.goLeft();
							map.removeKey((int)chip.getPosition().getX()-1, (int)chip.getPosition().getY(), 3);
							chip.addKey(3);
							chipImageView.setImage(chipLeft);
							chipImageView.toFront();
						}
						else if (positionValue1 == 5)
						{
							chip.goLeft();
							map.removeKey((int)chip.getPosition().getX()-1, (int)chip.getPosition().getY(), 5);
							chip.addKey(5);
							chipImageView.setImage(chipLeft);
							chipImageView.toFront();
							
						}
						else if (positionValue1 == 7)
						{
							chip.goLeft();
							map.removeKey((int)chip.getPosition().getX()-1, (int)chip.getPosition().getY(), 7);
							chip.addKey(7);
							chipImageView.setImage(chipLeft);
							chipImageView.toFront();
						}
						else if (positionValue1 == 9)
						{
							chip.goLeft();
							map.removeKey((int)chip.getPosition().getX()-1, (int)chip.getPosition().getY(), 9);
							chip.addKey(9);
							chipImageView.setImage(chipLeft);
							chipImageView.toFront();
							
						}
						else if (positionValue1 == 10)
						{
							chip.goLeft();
							chipImageView.setImage(chipLeft);
							foundPortal(gameStage);
						}
						else if (positionValue1 % 2 == 0)
						{
							if (chip.getKeys().contains(positionValue1))
							{
								openWall((int)chip.getPosition().getX()-1, (int)chip.getPosition().getY(), map, root);
								chip.goLeft();
								chipImageView.setImage(chipLeft);
								chipImageView.toFront(); 
							}
						}
						break;
						
					case UP:
						int positionValue2 = map.getStatus((int)chip.getPosition().getX(), (int)chip.getPosition().getY()-1);
						if (positionValue2 == 1)
						{
							chip.goUp();
							chipImageView.setImage(chipUp);
						}
						else if (positionValue2 == 3)
						{
							chip.goUp();
							map.removeKey((int)chip.getPosition().getX(), (int)chip.getPosition().getY()-1, 3);
							chip.addKey(3);
							chipImageView.setImage(chipUp);
							chipImageView.toFront();
						}
						else if (positionValue2 == 5)
						{
							chip.goUp();
							map.removeKey((int)chip.getPosition().getX(), (int)chip.getPosition().getY()-1, 5);
							chip.addKey(5);
							chipImageView.setImage(chipUp);
							chipImageView.toFront();
						}
						else if (positionValue2 == 7)
						{
							chip.goUp();
							map.removeKey((int)chip.getPosition().getX(), (int)chip.getPosition().getY()-1, 7);
							chip.addKey(7);
							chipImageView.setImage(chipUp);
							chipImageView.toFront();
						}
						else if (positionValue2 == 9)
						{
							chip.goUp();
							map.removeKey((int)chip.getPosition().getX(), (int)chip.getPosition().getY()-1, 9);
							chip.addKey(9);
							chipImageView.setImage(chipUp);
							chipImageView.toFront();
						}
						else if (positionValue2 == 10)
						{
							chip.goUp();
							chipImageView.setImage(chipUp);
							foundPortal(gameStage);
						}
						else if (positionValue2 % 2 == 0)
						{
							if (chip.getKeys().contains(positionValue2))
							{
								openWall((int)chip.getPosition().getX(), (int)chip.getPosition().getY()-1, map, root);
								chip.goUp();
								chipImageView.setImage(chipUp);
								chipImageView.toFront();
							}
						}
						break;
						
					case DOWN:
						int positionValue3 = map.getStatus((int)chip.getPosition().getX(), (int)chip.getPosition().getY()+1);
						if (positionValue3 == 1)
						{
							chip.goDown();
							chipImageView.setImage(chipDown);
						}
						else if (positionValue3 == 3)
						{
							chip.goDown();
							map.removeKey((int)chip.getPosition().getX(), (int)chip.getPosition().getY()+1, 3);
							chip.addKey(3);
							chipImageView.setImage(chipDown);
							chipImageView.toFront();
						}
						else if (positionValue3 == 5)
						{
							chip.goDown();
							map.removeKey((int)chip.getPosition().getX(), (int)chip.getPosition().getY()+1, 5);
							chip.addKey(5);
							chipImageView.setImage(chipDown);
							chipImageView.toFront();
						}
						else if (positionValue3 == 7)
						{
							chip.goDown();
							map.removeKey((int)chip.getPosition().getX(), (int)chip.getPosition().getY()+1, 7);
							chip.addKey(7);
							chipImageView.setImage(chipDown);
							chipImageView.toFront();
						}
						else if (positionValue3 == 9)
						{
							chip.goDown();
							map.removeKey((int)chip.getPosition().getX(), (int)chip.getPosition().getY()+1, 9);
							chip.addKey(9);
							chipImageView.setImage(chipDown);
							chipImageView.toFront();
						}
						else if (positionValue3 == 10)
						{
							chip.goDown();
							chipImageView.setImage(chipDown);
							foundPortal(gameStage);
						}
						else if (positionValue3 % 2 == 0)
						{
							if (chip.getKeys().contains(positionValue3))
							{
								openWall((int)chip.getPosition().getX(), (int)chip.getPosition().getY()+1, map, root);
								chip.goDown();
								chipImageView.setImage(chipDown);
								chipImageView.toFront();
							}
						}
						break;
						
					case ESCAPE:
						gameStage.close();
						break;
						
					default:
						break;
				}
				chipImageView.setX(chip.getPosition().getX()*scale);
				chipImageView.setY(chip.getPosition().getY()*scale);
			}
		});
	}
	
	public void openWall(int x, int y, GridMap map, ObservableList<Node> root)
	{
		map.setStatus(x, y, 1);
		blankBlock tile = new blankBlock();
		tile.setPosition(x * scale, y * scale);
		root.add(tile.getImageView());
		tile.getImageView().toFront();
		//map.drawMap(root, scale, 0);
		
	}
	
	public void foundPortal(Stage gameStage)
	{
		gameStage.close();
	}
}