package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoElevatorTime extends Command {

	private boolean up;
	private double time;

	public AutoElevatorTime() {
		requires(Robot.elevator);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		up = false;
		time = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Timer.getFPGATimestamp() - time < 1 && up) {
			Elevator.drive(.5);
			if (Timer.getFPGATimestamp() - time >= 1) {
				time = Timer.getFPGATimestamp();
				up = false;
			}
		} else if (Timer.getFPGATimestamp() - time < 1 && !up) {
			Elevator.drive(0);
			if (Timer.getFPGATimestamp() - time >= 1) {
				time = Timer.getFPGATimestamp();
				up = true;
			}
			time = Timer.getFPGATimestamp();
			up = true;
		}
		// if (Timer.getFPGATimestamp() - time > 1) {
		// if (up) {
		// Elevator.drive(.7);
		// time = Timer.getFPGATimestamp();
		// up = false;
		// } else {
		// Elevator.drive(0);
		// new Wait(.5).start();
		// time = Timer.getFPGATimestamp();
		// up = true;
		// }
		// } else {
		// Elevator.drive(.7);
		// time = Timer.getFPGATimestamp();
		// up = false;
		// }
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
