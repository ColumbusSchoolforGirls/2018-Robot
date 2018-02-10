package org.usfirst.frc.team677.robot.autocommands;


import org.usfirst.frc.team677.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRight extends Command {

    public AutoRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    // For Auto Right
    protected void initialize() {
    	String gameData;
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    			if(gameData.length()>0){
    				if(gameData.charAt(0) == 'L') {
    					
    				} else {
    					
    				}
    			}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        	
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
