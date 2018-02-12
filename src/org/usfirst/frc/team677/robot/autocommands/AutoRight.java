package org.usfirst.frc.team677.robot.autocommands;


import org.usfirst.frc.team677.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRight extends Command {

    public AutoRight() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	String gameData;
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    			if(gameData.length()>0){
    				if(gameData.charAt(0) == 'L') {
    					new LRightPosition();
    				} else {
    					new RRightPosition();
    				}
    			}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
