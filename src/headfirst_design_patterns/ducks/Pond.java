package headfirst_design_patterns.ducks;

import headfirst_design_patterns.ducks.types.*;


/**
 * Creates the pond and adds ducks to it.
 * @author Jane
 *
 */
public class Pond {
	
	public Pond(){
		Duck mallard = new Mallard();
		mallard.swim();
		mallard.fly();
		mallard.quack();
		
		Duck yellowDucky = new YellowDucky();
		yellowDucky.swim();
		yellowDucky.fly();
		yellowDucky.quack();
	}

}
