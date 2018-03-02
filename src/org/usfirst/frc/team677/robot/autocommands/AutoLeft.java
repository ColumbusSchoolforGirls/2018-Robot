package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLeft extends Command {
	String gameData;
	public AutoLeft() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
	}

	protected void execute() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
	}

	protected boolean isFinished() {
		return (gameData.length() > 0); 
			
	}

	protected void end() {
		if (gameData.charAt(0) == 'L') {
			new LLeftPosition().start();
		} else {
			new RLeftPosition().start();
		}
	}

	protected void interrupted() {
	}
}
