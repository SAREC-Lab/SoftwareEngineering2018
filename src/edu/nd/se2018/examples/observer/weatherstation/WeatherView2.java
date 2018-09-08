package edu.nd.se2018.examples.observer.weatherstation;

import java.util.Observable;
import java.util.Observer;


/**
 * Second example of a weather station.
 * @author Jane
 *
 */
public class WeatherView2 implements Observer{

	int currentTemperature;
	
	public WeatherView2(WeatherStation weatherStation){
		weatherStation.addObserver(this);
		currentTemperature = 0;
	}
	
	public void updateThermometerDisplay(){
		System.out.println("WV2: Current temperature is " + currentTemperature);
	}
	
	// Notified of updates.
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherStation){  
			currentTemperature = ((WeatherStation)o).getTemperature(); //cast
			updateThermometerDisplay();
		}	
		
	}

}
