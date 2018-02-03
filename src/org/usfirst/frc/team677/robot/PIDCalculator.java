package org.usfirst.frc.team677.robot;

import edu.wpi.first.wpilibj.Timer;

public class PIDCalculator {
	double propConstant = 0;
	double integralConstant = 0;
	double derivConstant = 0;
	double IZone = 0;
	double prop = 0;
	double integral = 0;
	double deriv = 0;
	double output = 0;
	double error = 0;
	double lastError = 0;
	double runningSum = 0;
	double lastTime = 0;
	double currentPosition = 0;
	
	public PIDCalculator (double propValue, double integralValue, double derivValue) {
		propConstant = propValue;
		integralConstant = integralValue;
		derivConstant = derivValue;
	}
	
	public double calculate() {
		prop = propConstant * error;
		
		if (error <= Math.abs(IZone)) {
			runningSum = 0;
		} else {
			runningSum = runningSum + error * (Timer.getFPGATimestamp() - lastTime);
		}
		integral = integralConstant * runningSum;
		
		deriv = derivConstant + (error - lastError)/(Timer.getFPGATimestamp() - lastTime);
		
		lastTime = Timer.getFPGATimestamp();
		lastError = error;
		output = prop + integral + deriv;
		
		return output;
	}

}
