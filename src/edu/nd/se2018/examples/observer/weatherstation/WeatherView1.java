package edu.nd.se2018.examples.observer.weatherstation;

import java.util.Observable;
import java.util.Observer;

/**
 * Represents one view of the weather 
 * Implements Observer
 * Note that in this example, an instance of the WeatherStation is sent to the class in the constructor,
 * and the WeatherView1 is responsible for registering itself as an observer.
 * @author Jane
 *
 */
public class WeatherView1 implements Observer {
	Outlook outlook;
	public WeatherView1(WeatherStation weatherStation){
		weatherStation.addObserver(this);
		outlook = Outlook.UNKNOWN;
		generateWeatherAdvisory();
	}
	
	private void generateWeatherAdvisory(){
		switch (outlook) { 
		case SUNNY: 
			System.out.println("WV1: The weather is sunny today. Catch some rays." );
			break;
		case CLOUDY:
			System.out.println("WV1: It is cloudy today.  Try not to feel gloomy.");
			break;
		case RAINING:
			System.out.println("WV1: Its raining cats and dogs. Hope you have your umbrella.");
			break;
		default:
			System.out.println("WV1: We aren't quite sure what the weather is doing today yet.  Stand by");			
		}
	}
	
	// WeatherView1 is notified of the changes that occur.
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherStation){  
			outlook = ((WeatherStation)o).getOutlook(); //cast
			generateWeatherAdvisory();
		}	
	}
}
