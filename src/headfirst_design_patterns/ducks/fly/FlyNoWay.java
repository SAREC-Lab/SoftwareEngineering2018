package headfirst_design_patterns.ducks.fly;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void performFly() {
		System.out.println("I can't fly!!!!");
	}

}
