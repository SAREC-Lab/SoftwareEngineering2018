package edu.nd.se2018.homework.hwk6.view;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.model.MonsterModel;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MonsterView implements Observer {
	public ImageView view;
	private Image monsterImage;
	
	public MonsterView(MonsterModel monster) {
		monsterImage = new Image("/images/chip/textures/bugUp.png", 50, 50, true, true);
		view = new ImageView(monsterImage);
		view.setFitHeight(20);
		view.setFitWidth(20);
		int[] pos = new int[2];
		pos = monster.getPosition();
		view.setX(pos[0] * 20);
		view.setY(pos[1] * 20);
	}

	public Node getView() {
		return(view);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		int[] pos = new int[2];
		pos = ((MonsterModel)o).getPosition();
		view.setX(pos[0] * 20);
		view.setY(pos[1] * 20);
		
	}

}
