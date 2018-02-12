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

    protected void initialize() {
    	Drivetrain.resetGyroscope();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
