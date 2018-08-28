package headfirst_design_patterns.ducks.quack;

public class Quack implements QuackBehavior {

	@Override
	public void performQuack() {
		System.out.println("Quack Quack");
	}

}
