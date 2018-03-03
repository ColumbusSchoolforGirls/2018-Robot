package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoElevatorTime extends Command {
	
	private double i;

    public AutoElevatorTime() {
        requires(Robot.elevator);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	i = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Elevator.drive(.4 + (.3 * Math.sin(i)-.04)); //original was .1
    	i += 3.14159 / 32;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
