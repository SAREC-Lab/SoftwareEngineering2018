package src.edu.nd.se2018.homework.hwk2;
import java.util.*;
import java.util.Map.Entry;

public class race {
	race() {};
	public HashMap< String,horse > raceTrack = new HashMap<String,horse>();
	public HashMap< String, Integer > status = new HashMap< String, Integer >();
	public HashMap< String, Integer > winnersCircle = new HashMap < String, Integer > ();
	int numHorse = 0;

	
	public void addHorse(String name, int speed, String strat) {
		numHorse++;
		if(numHorse > 5) {
			System.out.println("Sorry, the race is already full "+ name +" can't join in");
			
		}else if (speed < 1.33) {// this is the value that my integer casting would truncate to 0 and the horse would get stuck
			System.out.println(name + " is too slow, that horse isn't going to go anywhere");
			numHorse--; // no need to add the horse the the count if he/she will not be racing
		}else {
		horse nextUp = new horse(name,speed,strat);
		//System.out.println(nextUp.getName());
		//System.out.println(nextUp.getD());
		
		status.put(nextUp.getName(), 0); // place each new horse at the beginning of the track 
		raceTrack.put(nextUp.getName(), nextUp); // then throw the horse into a container if we need information on it
		}
		
	}
	public void runRace() {
		int finished = 0;
		int updater = 0;
		
		while(finished != 1) {
			updater++;
			if((updater%5) == 0) {System.out.println(" ");}
			for (Entry<String, Integer> pair : status.entrySet()) {
				if((updater%5) == 0) {
					double update = Math.round(pair.getValue() * 100.0) / 10000.0;
					if(update < 100) { // can still see if someone is close to tie on the final loop
						System.out.println(pair.getKey() + " is at the " + update + " mile mark!"); // race updates
					}
					
				}
			    if(pair.getValue() > 1000) {
			    	winnersCircle.put(pair.getKey(),pair.getValue()); // this way if more than 1 horse if over 1000 we can find a winner
			    	finished = 1; // will kick out because of the boolean
			    }
			    else {
			    	String label = pair.getKey(); // grab the name of the horse we are working on
			    	//System.out.println(pair.getKey()+ "here 1");
			    	horse current = raceTrack.get(label); // now we have the rest of that horses information
			    	//System.out.println(current.getName() +" "+ current.getD() + "here 2");
			    	int newPos = current.run(); // we can use this to help it run with the given strategy it chose, and find its new spot
			    	//System.out.println(newPos + " The newPos in race");
			    	status.put(pair.getKey(), newPos); // update the status of the horse to reflect its new position
			    }
			}
			if(!winnersCircle.isEmpty()) { // we need to go through the winners in case there is a tie 
				//System.out.println("Winner");
				// if it is bigger than 1, we need to check, else just print the 1 entry in the circle
				System.out.println("The race has ended!");
				if(winnersCircle.size() > 1) {
					System.out.println(" ");
					System.out.println("It was too close to call so they will have to share");
					System.out.println("Your champions are:");
					for (Entry<String, Integer> pair : winnersCircle.entrySet()) {
						System.out.println(pair.getKey());
					}
					
				}else {
					for(Entry<String,Integer>pair : winnersCircle.entrySet()) {
						System.out.println(" ");
						System.out.println(pair.getKey() + " Wins!");
					}
				}
			}
		}
		
		
		
		
	}
}
