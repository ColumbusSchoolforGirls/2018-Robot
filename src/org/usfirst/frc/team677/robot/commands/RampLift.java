package org.usfirst.frc.team677.robot.commands;

import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RampLift extends Command {

    public RampLift() {
    	requires(Robot.ramp);
    }

    protected void initialize() {
    	Ramp.lift(true); //TODO: Add a control for this
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
