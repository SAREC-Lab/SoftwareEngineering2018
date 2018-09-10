package src.edu.nd.se2018.homework.hwk2;

public class Main {
	
	public static void main(String args[]) {
		race Race1 = new race();
		Race1.addHorse("Sam",22,"EarlySprinter");
		Race1.addHorse("Molly",10,"EarlySprinter");
		Race1.addHorse("Joe",25,"EarlySprinter");
		Race1.addHorse("Blizzard",10,"EarlySprinter");
		Race1.addHorse("Flicker",30,"steadyRunner");
		Race1.runRace();
	}
}
