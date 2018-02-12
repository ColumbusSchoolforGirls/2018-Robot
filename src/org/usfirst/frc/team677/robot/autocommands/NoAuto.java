package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class NoAuto extends Command {

    public NoAuto() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
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
