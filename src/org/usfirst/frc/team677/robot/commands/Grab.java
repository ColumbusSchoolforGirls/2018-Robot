package org.usfirst.frc.team677.robot.commands;

import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team677.robot.subsystems.Elevator;

/**
 *
 */
public class Grab extends Command {
	boolean open;
	boolean auto;

    public Grab(boolean clawDirection, boolean auto) {
    	requires(Robot.arm);
    	open = clawDirection;
    	this.auto = auto;
    }

	protected void initialize() {
    }

    protected void execute() {
    	Arm.grab(open);
    }

    protected boolean isFinished() {
        return auto;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    }
}
