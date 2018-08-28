package headfirst_design_patterns.ducks.fly;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void performFly() {
		System.out.println("I'm flying now");
	}

}
