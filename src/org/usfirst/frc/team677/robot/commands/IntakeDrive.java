package org.usfirst.frc.team677.robot.commands;

import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Arm;
import org.usfirst.frc.team677.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class IntakeDrive extends Command {

	double speed;
	
    public IntakeDrive(double speed) {
    	requires(Robot.intake);
    	this.speed = speed;
      }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Intake.runIntake(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Intake.runIntake(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Intake.runIntake(0);
    }
}
