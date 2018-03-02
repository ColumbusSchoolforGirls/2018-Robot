package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoCenter extends Command {
	String gameData;
	
	public AutoCenter() {
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
		if (gameData.charAt(0) == 'L') {
			new LCenterPosition().start();
		} else {
			new RCenterPosition().start();
		}
	}

	protected void interrupted() {
	}
}
