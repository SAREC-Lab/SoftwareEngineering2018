package src.edu.nd.se2018.homework.hwk2;

public class Main {
	
	public static void main(String args[]) {
		race Race1 = new race();
		Race1.addHorse("Horse1",20,"slowStarter");
		//Race1.addHorse("Horse2",20,"EarlySprinter");
		Race1.runRace();
	}
}
