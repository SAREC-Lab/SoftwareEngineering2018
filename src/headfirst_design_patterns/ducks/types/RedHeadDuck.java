package headfirst_design_patterns.ducks.types;

import headfirst_design_patterns.ducks.fly.FlyWithWings;
import headfirst_design_patterns.ducks.quack.Quack;

public class RedHeadDuck extends Duck{
	
	public RedHeadDuck(){
		System.out.println("New RedHead Duck");
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("I am a RedHead Duck");
		
	}

}
