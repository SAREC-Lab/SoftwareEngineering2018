package edu.nd.se2018.examples.observer.weatherstation;

public class WeatherStationSimulator {
	
	public static void main(String[] args){
		WeatherStation weatherStation = new WeatherStation(); 			
		
		// Now let's add observers.
		new WeatherView1(weatherStation);
		new WeatherView2(weatherStation);
		
		weatherStation.setTemperature(70);
		weatherStation.setOutlook(Outlook.SUNNY);
		weatherStation.displayWeather(); 		
	}
}
