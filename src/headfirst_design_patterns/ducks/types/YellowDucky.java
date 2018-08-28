package headfirst_design_patterns.ducks.types;

import headfirst_design_patterns.ducks.fly.*;
import headfirst_design_patterns.ducks.quack.*;

public class YellowDucky extends Duck{
	
	public YellowDucky(){
		System.out.println("New Yellow Duck");
		flyBehavior = new FlyNoWay();
		quackBehavior = new Peep();
	}

	@Override
	public void display() {
		System.out.println("I am a yellow ducky floating in the bath tub!");
		
	}

}
