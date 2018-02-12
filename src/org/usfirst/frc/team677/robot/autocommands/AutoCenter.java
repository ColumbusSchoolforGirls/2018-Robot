package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoCenter extends Command {

	public AutoCenter() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				new LCenterPosition();
			} else {
				new RCenterPosition();
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
