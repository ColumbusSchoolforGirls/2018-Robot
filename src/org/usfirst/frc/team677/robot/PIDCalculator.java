package org.usfirst.frc.team677.robot;

import edu.wpi.first.wpilibj.Timer;

public class PIDCalculator {
	private final double propConstant;
	private final double integralConstant;
	private final double derivConstant;
	private double runningSum = 0;
	private final double IZone;
	private double lastError;
	private double lastTime;
	private double output;
	
	public PIDCalculator(double propValue, double integralValue, double derivValue) {
		this(propValue, integralValue, derivValue, 0);
	}
	
	public PIDCalculator (double propValue, double integralValue, double derivValue, double IZone) {
		propConstant = propValue;
		integralConstant = integralValue;
		derivConstant = derivValue;
		this.IZone = IZone;
		lastTime = 0;
		lastError = 0;
	}
	
	public double getOutput(double error) {
		double prop = propConstant * error;
		double integral;
		double deriv;
		
		if (Math.abs(error) <= IZone) {
			runningSum = runningSum + error * (Timer.getFPGATimestamp() - lastTime);
		} else {
			runningSum = 0;
		}
		integral = integralConstant * runningSum;
		
		deriv = derivConstant * (error - lastError)/(Timer.getFPGATimestamp() - lastTime);
		
		lastTime = Timer.getFPGATimestamp();
		lastError = error;
		output = prop + integral + deriv;
		
		return output;
	}

}
