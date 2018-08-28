package headfirst_design_patterns.ducks.types;

import headfirst_design_patterns.ducks.fly.FlyWithWings;
import headfirst_design_patterns.ducks.quack.Quack;

public class Mallard extends Duck{
	
	public Mallard(){
		System.out.println("New Mallard");
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("I am a Mallard Duck");		
	}
}
