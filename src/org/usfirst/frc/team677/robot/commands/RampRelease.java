package org.usfirst.frc.team677.robot.commands;

import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RampRelease extends Command {

    public RampRelease() {
    	requires(Robot.ramp);
    }

    protected void initialize() {
    	Ramp.release(true); //TODO: Add a control for this
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
