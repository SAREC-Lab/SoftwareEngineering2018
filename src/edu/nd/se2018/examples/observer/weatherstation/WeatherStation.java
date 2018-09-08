package edu.nd.se2018.examples.observer.weatherstation;
import java.util.Observable;


/**
 * WeatherStation class is observable by various displays
 * It's own values in real life would be set by sensors; however, in this example
 * they are set by the WeatherStationSimulator.
 * @author Jane
 *
 */
public class WeatherStation extends Observable{
	int currentTemp = 0;
	Outlook outlook = Outlook.UNKNOWN;
	
	public WeatherStation(){}
	
	// Simulates temperature changed by sensors
	// Actually set by simulator.
	public void setTemperature(int temp){
		currentTemp = temp;
		setChanged();
		notifyObservers();
	}
	
	// Also set by simulator
	public void setOutlook(Outlook currentOutlook){
		this.outlook = currentOutlook;
		setChanged();
		String myString = new String("outlook");
		notifyObservers((String)myString);
	}
	
	public Outlook getOutlook(){
		return outlook;
	}
	
	public int getTemperature(){
		return currentTemp;
	}
	
	public void displayWeather(){
		System.out.println("The weather is currently " + outlook 
		    + " and " + currentTemp + " degrees.");;
	}
}
