package src.edu.nd.se2018.homework.hwk2;
import java.util.*;
import java.util.Map.Entry;

public class race {
	race() {};
	public HashMap< String,horse > raceTrack = new HashMap<String,horse>();
	public HashMap< String, Integer > status = new HashMap< String, Integer >();
	public HashMap< String, Integer > winnersCircle = new HashMap < String, Integer > ();

	
	public void addHorse(String name, int speed, String strat) {
		if (speed < 1.33) {// this is the value that my integer casting would truncate to 0 and the horse would get stuck
			System.out.println("That horse isn't going to go anywhere");
		}
		horse nextUp = new horse(name,speed,strat);
		System.out.println(nextUp.getName());
		System.out.println(nextUp.getD());
		
		status.put(nextUp.getName(), 0); // place each new horse at the beginning of the track 
		raceTrack.put(nextUp.getName(), nextUp); // then throw the horse into a container if we need information on it
		
		
	}
	public void runRace() {
		int finished = 0;
		String Winner = "";
		int updater = 0;
		
		while(finished < 12) {
			updater++;
			finished++;
		
			for (Entry<String, Integer> pair : status.entrySet()) {
				if(true) {
					double update = Math.round(pair.getValue() * 100.0) / 100.0;
					System.out.println(pair.getKey() + " is at the " + update + " mark!"); // race updates
				}
			    if(pair.getValue() > 1000) {
			    	winnersCircle.put(pair.getKey(),pair.getValue()); // this way if more than 1 horse if over 1000 we can find a winner
			    	finished = 1; // will kick out because of the boolean
			    	break;
			    }
			    else {
			    	String label = pair.getKey(); // grab the name of the horse we are working on
			    	System.out.println(pair.getKey()+ "here 1");
			    	horse current = raceTrack.get(label); // now we have the rest of that horses information
			    	System.out.println(current.getName() +" "+ current.getD() + "here 2");
			    	int newPos = current.run(); // we can use this to help it run with the given strategy it chose, and find its new spot
			    	//newPos = pair.getValue() + newPos;
			    	System.out.println(newPos + " The newPos in race");
			    	status.put(pair.getKey(), newPos); // update the status of the horse to reflect its new position
			    }
			}
			if(!winnersCircle.isEmpty()) {
				System.out.println("Winner");
				finished= 12;
			}
		}
		
		
		
		
	}
}
