package org.usfirst.frc.team677.robot.autocommands;


import org.usfirst.frc.team677.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRight extends Command {
	String gameData;
    public AutoRight() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    }

    protected boolean isFinished() {
        return gameData.length() > 0;
    }

    protected void end() {
    	if(gameData.charAt(0) == 'L') {
			new LRightPosition();
		} else {
			new RRightPosition();
		}
    }

    protected void interrupted() {
    }
}
