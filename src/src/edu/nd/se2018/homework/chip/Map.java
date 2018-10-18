package chip;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import chip.LevelMapLayouts;


public class Map {
	
	final int dimensions = 25;
	public int[][] mapGrid = new int[dimensions][dimensions];
	
	public void drawMap(ObservableList<Node> root, int scale, Chip chip) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				if (x == chip.getPositionX() && y == chip.getPositionY()) {
					continue;
				}
				if (mapGrid[x][y] == 0) {
					Image blankTileImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/BlankTile.png", 25, 25, false, false);
					ImageView ivBlankTile = new ImageView(blankTileImage);
					ivBlankTile.setX(x*dimensions);
					ivBlankTile.setY(y*dimensions);
					root.add(ivBlankTile);
				}
				else if (mapGrid[x][y] == 1) {
					Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.DARKGRAY);
					root.add(rect);
				}
				else if (mapGrid[x][y] == 2) {
					Image blueKeyWallImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/blueKeyWall.png", 25, 25, false, false);
					ImageView ivBlueKeyWall = new ImageView(blueKeyWallImage);
					ivBlueKeyWall.setX(x*dimensions);
					ivBlueKeyWall.setY(y*dimensions);
					root.add(ivBlueKeyWall);
				}
				else if (mapGrid[x][y] == 3) {
					Image redKeyWallImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/redKeyWall.png", 25, 25, false, false);
					ImageView ivRedKeyWall = new ImageView(redKeyWallImage);
					ivRedKeyWall.setX(x*dimensions);
					ivRedKeyWall.setY(y*dimensions);
					root.add(ivRedKeyWall);
				}
				else if (mapGrid[x][y] == 4) {
					Image yellowKeyWallImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/yellowKeyWall.png", 25, 25, false, false);
					ImageView ivYellowKeyWall = new ImageView(yellowKeyWallImage);
					ivYellowKeyWall.setX(x*dimensions);
					ivYellowKeyWall.setY(y*dimensions);
					root.add(ivYellowKeyWall);
				}
				else if (mapGrid[x][y] == 5) {
					Image greenKeyWallImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/greenKeyWall.png", 25, 25, false, false);
					ImageView ivGreenKeyWall = new ImageView(greenKeyWallImage);
					ivGreenKeyWall.setX(x*dimensions);
					ivGreenKeyWall.setY(y*dimensions);
					root.add(ivGreenKeyWall);
				}
				else if (mapGrid[x][y] == 6) {
					Image blueKeyImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/blueKey.png", 25, 25, false, false);
					ImageView ivBlueKey = new ImageView(blueKeyImage);
					ivBlueKey.setX(x*dimensions);
					ivBlueKey.setY(y*dimensions);
					root.add(ivBlueKey);
				}
				else if (mapGrid[x][y] == 7) {
					Image redKeyImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/redKey.png", 25, 25, false, false);
					ImageView ivRedKey = new ImageView(redKeyImage);
					ivRedKey.setX(x*dimensions);
					ivRedKey.setY(y*dimensions);
					root.add(ivRedKey);
				}
				else if (mapGrid[x][y] == 8) {
					Image yellowKeyImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/yellowKey.png", 25, 25, false, false);
					ImageView ivYellowKey = new ImageView(yellowKeyImage);
					ivYellowKey.setX(x*dimensions);
					ivYellowKey.setY(y*dimensions);
					root.add(ivYellowKey);
				}
				else if (mapGrid[x][y] == 9) {
					Image greenKeyImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/greenKey.png", 25, 25, false, false);
					ImageView ivGreenKey = new ImageView(greenKeyImage);
					ivGreenKey.setX(x*dimensions);
					ivGreenKey.setY(y*dimensions);
					root.add(ivGreenKey);
				}
				else if (mapGrid[x][y] == 10) {
					Image chipTileImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/chipItem.png", 25, 25, false, false);
					ImageView ivChipTile = new ImageView(chipTileImage);
					ivChipTile.setX(x*dimensions);
					ivChipTile.setY(y*dimensions);
					root.add(ivChipTile);
				}
				else if (mapGrid[x][y] == 11) {
					Image portalImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/portal.png", 25, 25, false, false);
					ImageView ivPortal = new ImageView(portalImage);
					ivPortal.setX(x*dimensions);
					ivPortal.setY(y*dimensions);
					root.add(ivPortal);
				}
			}
		}
	}
	
	public void setMapLevel(int[][] mapLevelGrid) {
		this.mapGrid = mapLevelGrid;
	}
	
}
