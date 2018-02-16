/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team677.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.OI;
import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Tankdrive extends Command {
//	double leftLimit = 0.5;
//	double leftChange;
//	double leftJoystick;
//	double leftLimitedJoystick = 0;
//	double rightChange;
//	double rightLimit = 0.5;
//	double rightLimitedJoystick = 0;
//	double rightJoystick;
	
	public Tankdrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
	}

	protected void execute() {
		
		//Rate limit filters on both sides
//		leftJoystick = OI.driveCont.getRawAxis(1);
//
//		leftChange = leftJoystick - leftLimitedJoystick;
//		if (leftChange > leftLimit && leftJoystick > 0) {
//			leftChange = leftLimit;
//		} else {
//			if (leftChange < -leftLimit && leftJoystick < 0){
//			 leftChange = -leftLimit;
//			}
//		}
//		leftLimitedJoystick += leftChange;
//		
//		rightJoystick = OI.driveCont.getRawAxis(5);
//
//		rightChange = rightJoystick - rightLimitedJoystick;
//		if (rightChange > rightLimit && rightJoystick > 0) {
//			rightChange = rightLimit;
//		} else {
//			if (rightChange < -rightLimit && rightJoystick < 0) {
//				rightChange = -rightLimit;
//			}
//		}
//		rightLimitedJoystick += rightChange;
//		
//		SmartDashboard.putNumber("Left Limited Joystick", leftLimitedJoystick);
//		SmartDashboard.putNumber("Right Limited Joystick", rightLimitedJoystick);
		
		if (Math.abs(OI.driveCont.getRawAxis(1)) <= Global.DEAD_ZONE && Math.abs(OI.driveCont.getRawAxis(5)) <= Global.DEAD_ZONE) {
			Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
		} else if (Math.abs(OI.driveCont.getRawAxis(1)) <= Global.DEAD_ZONE && Math.abs(OI.driveCont.getRawAxis(5)) > Global.DEAD_ZONE) {
			Drivetrain.setSpeed(ControlMode.PercentOutput, 0, OI.driveCont.getRawAxis(5));
		} else if (Math.abs(OI.driveCont.getRawAxis(1)) > Global.DEAD_ZONE && Math.abs(OI.driveCont.getRawAxis(5)) <= Global.DEAD_ZONE){
			Drivetrain.setSpeed(ControlMode.PercentOutput, OI.driveCont.getRawAxis(1), 0);
		} else {
			Drivetrain.setSpeed(ControlMode.PercentOutput, OI.driveCont.getRawAxis(1), OI.driveCont.getRawAxis(5));
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
