package edu.nd.se2018.homework.hwk6.view;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.model.ChipModel;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChipView implements Observer {
	private ImageView view;
	private Image chipImage;
	
	
	public ChipView(ChipModel chip) {
		chipImage = new Image("/images/chip/textures/chipDown.png", 50, 50, true, true);
		view = new ImageView(chipImage);
		view.setFitHeight(20);
		view.setFitWidth(20);
		int[] pos = chip.getPosition();
		view.setX(pos[0] * 20);
		view.setY(pos[1] * 20);
	}
	
	public Node getView() {
		return(view);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		int[] pos = ((ChipModel)o).getPosition();
		view.setX(pos[0] * 20);
		view.setY(pos[1] * 20);
		
		
	}

}
