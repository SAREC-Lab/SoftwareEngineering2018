package headfirst_design_patterns.ducks.quack;

public class Peep implements QuackBehavior{

	@Override
	public void performQuack() {
		System.out.println("Peep Peep");		
	}
}
