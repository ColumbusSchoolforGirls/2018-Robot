/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team677.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.OI;
import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Tankdrive extends Command {
	
	public Tankdrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
	}

	protected void execute() {
		
		//Rate limit filters on both sides
		double leftChange;
		double leftJoystick = OI.driveCont.getRawAxis(1);
		double leftLimit = 0.2;
		double leftLimitedJoystick = 0;
		leftChange = leftJoystick - leftLimitedJoystick;
		if (leftChange > leftLimit && leftJoystick > 0) {
			leftChange = leftLimit;
		} else {
			if (leftChange < -leftLimit && leftJoystick < 0){
			 leftChange = -leftLimit;
			}
		}
		leftLimitedJoystick += leftChange;
		
		double rightChange;
		double rightJoystick = OI.driveCont.getRawAxis(5);
		double rightLimit = 0.2;
		double rightLimitedJoystick = 0;
		rightChange = rightJoystick - rightLimitedJoystick;
		if (rightChange > rightLimit && rightJoystick > 0) {
			rightChange = rightLimit;
		} else {
			if (rightChange < -rightLimit && rightJoystick < 0) {
				rightChange = -rightLimit;
			}
		}
		rightLimitedJoystick += rightChange;
		if (Math.abs(OI.driveCont.getRawAxis(1)) <= Global.DEAD_ZONE && Math.abs(OI.driveCont.getRawAxis(5)) <= Global.DEAD_ZONE) {
			Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
		} else if (Math.abs(OI.driveCont.getRawAxis(1)) <= Global.DEAD_ZONE && Math.abs(OI.driveCont.getRawAxis(5)) > Global.DEAD_ZONE) {
			Drivetrain.setSpeed(ControlMode.PercentOutput, 0, rightLimitedJoystick);
		} else if (Math.abs(OI.driveCont.getRawAxis(1)) > Global.DEAD_ZONE && Math.abs(OI.driveCont.getRawAxis(5)) <= Global.DEAD_ZONE){
			Drivetrain.setSpeed(ControlMode.PercentOutput, leftLimitedJoystick, 0);
		} else {
			Drivetrain.setSpeed(ControlMode.PercentOutput, leftLimitedJoystick, rightLimitedJoystick);
		}
		
	}
	

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {
	}
}
