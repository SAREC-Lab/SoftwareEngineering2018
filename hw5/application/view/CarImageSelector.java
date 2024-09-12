package application.view;

import javafx.scene.image.Image;

public class CarImageSelector {
	

	public static Image getImage(){
		int imageSize = 20;
		int pickNum = (int)(Math.random() * 4);
		Image img;
		switch(pickNum){
		case 0: img = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/hw5/application/Images/bluecar.PNG",imageSize,imageSize,false,true);
		break;
		case 2: img = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/hw5/application/Images/graycar.PNG",imageSize,imageSize,false,true);
		break;
		case 3: img = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/hw5/application/Images/greencar.PNG",imageSize,imageSize,false,true);
		break;
		default: img = new Image("file:/Users/Dchao88/git/SoftwareEngineering2018/hw5/application/Images/redcar.PNG",imageSize,imageSize,false,true);	
		}
		return img;	
	}
}
