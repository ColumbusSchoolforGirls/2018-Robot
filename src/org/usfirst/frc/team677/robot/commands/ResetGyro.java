package org.usfirst.frc.team677.robot.commands;

import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetGyro extends Command {

    public ResetGyro() {
      requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Drivetrain.resetGyroscope();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
