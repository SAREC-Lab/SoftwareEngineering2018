package edu.nd.se2018.homework.hwk2;
import java.util.*;

import edu.nd.se2018.homework.hwk2.Horse;
import edu.nd.se2018.homework.hwk2.HorseBehavior;

public class Race {
	ArrayList<Horse> horses = new ArrayList<Horse> ();
	public Race() {
		//ArrayList<Horse> horses = new ArrayList<Horse> (); 
		// race.enrollHorse("Sam",0,22,new EarlySprintStrategy());
		//System.out.println(horses);
	}
	
	public void enrollHorse(String[] name, int index, int initSpeed, HorseBehavior strategy){
		Horse horse = new Horse(name, index, initSpeed);
		horse.setHorseBehavior(strategy);
	}
}
