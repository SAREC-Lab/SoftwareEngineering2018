package edu.nd.se2018.homework.hwk2;

//import headfirst_design_patterns.ducks.fly.FlyBehavior;
//import headfirst_design_patterns.ducks.quack.QuackBehavior;
//import java.util.Collections;
import edu.nd.se2018.homework.hwk2.types.RaceBehavior;
public class Horse {
	String horseName;
	int horseNo;
	float maxSpeed;
	float miles = 0;
	float timeFinished = -1;
	RaceBehavior raceBehavior;

	public void update(float min) {
		this.miles = this.raceBehavior.update(min, this.maxSpeed, this.miles);
		if(this.miles >= 10) {
			this.timeFinished = min;
		}
		String update = this.horseName + " has run " + this.miles + " miles.";
		System.out.println(update);
	}

	public float getTimeFinished() {
		return this.timeFinished;
	}
	public void setBehavior(RaceBehavior b) {
		this.raceBehavior = b;
	}
	public void setName(String n) {
		this.horseName = n;
	}

	public String getName() {
		return this.horseName;
	}
	public void setNo(int x) {
		this.horseNo = x;
	}

	public int getNo(){
		return this.horseNo;
	}
	public void setSpeed(float m) {
		this.maxSpeed = m;
	}
	public float getSpeed() {
		return this.maxSpeed;
	}

	public float getMiles() {
		return this.miles;
	}
	/*
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
	*/
}
