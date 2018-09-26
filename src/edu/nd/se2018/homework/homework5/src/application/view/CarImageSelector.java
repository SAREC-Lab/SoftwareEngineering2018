package application.view;

import javafx.scene.image.Image;

public class CarImageSelector {
	

	public static Image getImage(){
		int imageSize = 20;
		int pickNum = (int)(Math.random() * 4);
		Image img;
		switch(pickNum){
		case 0: img = new Image("file:/Users/danielburns/git/SoftwareEngineering2018/src/images/bluecar.PNG",imageSize,imageSize,false,true);
		break;
		case 2: img = new Image("file:/Users/danielburns/git/SoftwareEngineering2018/src/images/graycar.PNG",imageSize,imageSize,false,true);
		break;
		case 3: img = new Image("file:/Users/danielburns/git/SoftwareEngineering2018/src/images/greencar.PNG",imageSize,imageSize,false,true);
		break;
		default: img = new Image("file:/Users/danielburns/git/SoftwareEngineering2018/src/images/redcar.PNG",imageSize,imageSize,false,true);	
		}
		return img;	
	}
}