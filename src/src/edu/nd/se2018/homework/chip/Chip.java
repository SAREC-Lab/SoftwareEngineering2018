package chip;

import chip.Moveable;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Chip implements Moveable {
	
	public ImageView ivChip;
	private int positionX;
	private int positionY;
	private Image downImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/chipDown.png", 25, 25, false, false);
	private Image upImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/chipUp.png", 25, 25, false, false);
	private Image leftImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/chipLeft.png", 25, 25, false, false);
	private Image rightImage = new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/chipRight.png", 25, 25, false, false);
	final private int scale = 25;
	public int numKeysGathered = 0;
	
	public Chip(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.ivChip = new ImageView(new Image("file:/Users/danielburns/Documents/School/Software Development/SoftwareEngineering2018/chip/textures/chipDown.png", 25, 25, false, false));
		this.ivChip.setX(getPositionX());
		this.ivChip.setY(getPositionY());
	}
	
	public Node getImageView() {
		return ivChip;
	}
	
	public void setImageView(int direction) {
		switch (direction) {
		case 1:
			this.ivChip.setImage(this.downImage);
			break;
		case 2:
			this.ivChip.setImage(this.upImage);
			break;
		case 3:
			this.ivChip.setImage(this.rightImage);
			break;
		case 4:
			this.ivChip.setImage(this.leftImage);
			break;
		default:
			break;
		}
	}
		
	public void moveLeft() {
		setImageView(4);
		this.positionX -= scale;
		this.ivChip.setX(getPositionX());
	}
	
	public void moveRight() {
		setImageView(3);
		this.positionX += scale;
		this.ivChip.setX(getPositionX());
	}
	
	public void moveUp() {
		setImageView(2);
		this.positionY -= scale;
		this.ivChip.setY(getPositionY());
	}
	
	public void moveDown() {
		setImageView(1);
		this.positionY += scale;
		this.ivChip.setY(getPositionY());
	}
	
	public void drawChip(ObservableList<Node> root) {
			root.add(this.getImageView());
	}
	
	public int getPositionX() { return this.positionX; }
	
	public int getPositionY() { return this.positionY; }
	
}