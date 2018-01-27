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

/**
 * An example command.  You can replace me with your own command.
 */
public class Tankdrive extends Command {
	
	public Tankdrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
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

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
