package src.edu.nd.se2018.homework.hwk2;
import java.util.*;
import java.util.Map.Entry;

public class race {
	
	public HashMap< String,horse > raceTrack = new HashMap<String,horse>();
	public HashMap< String, Integer > status = new HashMap< String, Integer >();
	public HashMap< String, Integer > winnersCirlce = new HashMap < String, Integer > ();

	
	public void addHorse(String name, int speed, strategy strat) {
		if (speed < 1.33) {// this is the value that my integer casting would truncate to 0 and the horse would get stuck
			System.out.println("That horse isn't going to go anywhere");
		}
		horse nextUp = new horse(name,speed,strat);
		
		
		status.put(nextUp.getName(), 0); // place each new horse at the beginning of the track 
		raceTrack.put(nextUp.getName(), nextUp); // then throw the horse into a container if we need information on it
		
	}
	public void runRace() {
		int finished = 0;
		String Winner = "";
		int updater = 0;
		
		while(finished != 1) {
			updater++;
			
			long i = 0;
			for (Entry<String, Integer> pair : status.entrySet()) {
				if(updater%5 == 0) {
					double update = pair.getValue()/100
					System.out.println(pair.getKey() + " is at the " + update + "mark!");
				}
			    if(pair.getValue() > 1000) {
			    	winnersCirlce.put(pair.getKey(),pair.getValue()); // this way if more than 1 horse if over 1000 we can find a winner
			    	finished = 1; // will kick out becuase of the boolean
			    	break;
			    }
			    else {
			    	String label = pair.getKey(); // grab the name of the horse we are working on
			    	horse current = raceTrack.get(label); // now we have the rest of that horses information
			    	int newPos = current.run(pair.getValue()); // we can use this to help it run with the given strategy it chose, and find its new spot
			    	status.put(pair.getKey(), newPos); // update the status of the horse to reflect its new position
			    }
			}
		}
		
		
		
		
	}
}
