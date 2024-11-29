package edu.nd.se2018.homework.ChipsChallenge;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Monster implements Observer{
	
	Image monsterLeftImage;
	Image monsterRightImage;
	Image monsterSleepImage;
	ImageView monsterImageView;
	ChipsMap map;
	int scale;
	int triggerPoint;
	int xLocation;
	int yLocation;
	String direction;
	
	private IMonsterState monsterSleeping;
	private IMonsterState monsterLeft;
	private IMonsterState monsterRight;
	private IMonsterState currState;
	
	
	public Monster(){}
	
	public Monster(ChipsMap chipsmap, String direction, int x, int y, int scalingFactor) {
		this.scale = scalingFactor;
		this.direction = direction;
		map = chipsmap;
		triggerPoint = 4;
		xLocation = x;
		yLocation = y;
		
		monsterLeftImage = new Image("images\\MonsterLeft.png",scale, scale, false, true);
		monsterRightImage = new Image("images\\MonsterRight.png",scale, scale, false, true);
		monsterSleepImage = new Image("images\\MonsterSleep.png",scale, scale, false, true);
		monsterImageView = new ImageView(monsterSleepImage);
		
		monsterSleeping = new MonsterSleeping(this);
		monsterLeft = new MonsterLeft(this);
		monsterRight = new MonsterRight(this);
		currState = monsterSleeping;
		
	}
	
	public void move() {
		if (currState == monsterLeft) {
			monsterImageView.setImage(monsterLeftImage);
			xLocation -= 1;
		}else if (currState == monsterRight) {
			monsterImageView.setImage(monsterRightImage);
			xLocation += 1;
		}else if (currState == monsterSleeping) {
			monsterImageView.setImage(monsterSleepImage);
		}
			
	}
	
	public void canMove() {
		if (currState == monsterLeft) {
			if(xLocation > 0) {
				if(map.chipsGrid[xLocation - 1][yLocation] == 1)
					currState.hitBarrier();
			}else {
				currState.hitBarrier();
			}
		}else if (currState == monsterRight) {
			if(xLocation < 24) {
				if(map.chipsGrid[xLocation + 1][yLocation] == 1)
					currState.hitBarrier();
			}else {
				currState.hitBarrier();
			}
		}
	}
	
	public void setImageView() {
		monsterImageView.setX(xLocation*scale);
		monsterImageView.setY(yLocation*scale);
	}
	
	public int getX() {
		return xLocation;
	}
	public int getY() {
		return yLocation;
	}
	
	public ImageView getImageView() {
		return monsterImageView;
	}
	
	public IMonsterState getMonsterSleepingState() {
		return monsterSleeping;
	}
	public IMonsterState getDirectionState() {
		if (direction == "Left")
			return monsterLeft;
		else
			return monsterRight;
	}
	public IMonsterState getMonsterLeftState() {
		return monsterLeft;
	}
	public IMonsterState getMonsterRightState() {
		return monsterRight;
	}
	public void setMonsterState(IMonsterState newState) {
		currState = newState;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Chip){
			Chip chip = (Chip)o;
			if (Math.abs(chip.getChipLocation().x - xLocation) > triggerPoint || Math.abs(chip.getChipLocation().y - yLocation) > triggerPoint)
				currState.leaveRange();
			else if(Math.abs(chip.getChipLocation().x - xLocation) <= triggerPoint || Math.abs(chip.getChipLocation().y - yLocation) <= triggerPoint){
				currState.approachRange();
			} 
		}
	}


}
