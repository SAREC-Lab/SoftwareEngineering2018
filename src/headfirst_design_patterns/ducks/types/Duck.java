package headfirst_design_patterns.ducks.types;

import headfirst_design_patterns.ducks.fly.FlyBehavior;
import headfirst_design_patterns.ducks.quack.QuackBehavior;

/**
 * Creates the Duck base class
 * @author Jane
 *
 */
public abstract class Duck {
	QuackBehavior quackBehavior;
	FlyBehavior flyBehavior;
	
	public Duck(){}
		
	public void quack(){
		quackBehavior.performQuack();
	}

	public void swim(){
		System.out.println("I'm swimming");
	}
	
	public void fly(){
		flyBehavior.performFly();
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior){
		this.flyBehavior = flyBehavior;
	}
	
	public void setQuackBehavior(QuackBehavior quackBehavior){
		this.quackBehavior = quackBehavior;
	}
	
	public abstract void display();		
}
