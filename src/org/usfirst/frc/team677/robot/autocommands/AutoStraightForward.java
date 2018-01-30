package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoStraightForward extends Command {
	
	public int setpoint;

    public AutoStraightForward(int ticks) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	setpoint = ticks; //When calling this method, ticks should be one of the Global constants
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Drivetrain.setPID(Global.drivetrainProp, Global.drivetrainInt, Global.drivetrainDeriv);
    	Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drivetrain.setSpeed(ControlMode.Position, setpoint, setpoint);
    	//TODO: Make sure this is the right control mode
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Drivetrain.getLeftError() <= Math.abs(Global.ENCODER_TOLERANCE) && Drivetrain.getRightError() <= Math.abs(Global.ENCODER_TOLERANCE)) {
        	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
