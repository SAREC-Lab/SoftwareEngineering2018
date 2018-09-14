package edu.nd.se2018.homework.hwk2.types;

/**
 * Interface for diverse race strategies
 * @author Cameron Pickard
 *
 */
public interface RaceBehavior {
	public float update(float min, float maxSpeed, float miles);
}
