package com.xu.refactor.chapter6;

/**
 * 分解临时变量-临时变量被多次赋值时，对每次赋值声明新的临时变量
 * @author 39767
 *
 */
public class SplitTemporaryVariable {

	public double primaryForce;
	public double secondaryForce;
	public double mass;
	public int delay;
	
	
	public double getDistanceTravelled(int time){
		double result;
		double acc = primaryForce / mass;
		int primaryTime = Math.min(time, delay);
		result = 0.5 * acc * primaryTime * primaryTime;
		int secondaryTime = time - delay;
		if(secondaryTime > 0){
			double primaryVal = acc * delay;
			acc = (primaryForce + secondaryForce) / mass;
			result += primaryVal * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
		}
		return result;
	}
	
	public double getDistanceTravelled_R(int time){
		double result;
		result = calculateResult(getAcc(primaryForce, mass), Math.min(time, delay));
		result += getAcc(primaryForce, mass) * delay * getSecondaryTime(time);
		result += calculateResult(getAcc(primaryForce, mass) + getAcc(secondaryForce, mass), getSecondaryTime(time));
		return result;
	}
	
	private int getSecondaryTime(int time){
		if(time > delay)
			return time - delay;
		else
			return 0;
	}
	
	private double calculateResult(double acc, int time) {
		return 0.5 * acc * time * time;
	}
	
	private double getAcc(double force, double mass){
		return force / mass;
	}
}
