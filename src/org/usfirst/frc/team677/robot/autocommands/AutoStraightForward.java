package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.PIDCalculator;
import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoStraightForward extends Command {
	double leftOutput = 0;
	double rightOutput = 0;
	double leftError = 0;
	double rightError = 0;
	double angle = 0;
	double angleError = 0;
	double angleOutput = 0;
	private PIDCalculator distPID;
	private PIDCalculator anglePID;
	
	public double setpoint;

    public AutoStraightForward(double ticks) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	setpoint = ticks; //When calling this method, ticks should be one of the Global constants
    	distPID = new PIDCalculator(Global.DRIVETRAIN_P, Global.DRIVETRAIN_I, Global.DRIVETRAIN_D, Global.DRIVETRAIN_IZONE); //TODO: Tune this
    	anglePID = new PIDCalculator(Global.ANGLE_P,Global.ANGLE_I,Global.ANGLE_D,Global.ANGLE_IZONE);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Drivetrain.resetEncoders();
    	angle = Drivetrain.getFacingAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftError = setpoint - Drivetrain.getLeftEncoder();
    	rightError = setpoint - Drivetrain.getRightEncoder();
    	angleError = angle - Drivetrain.getFacingAngle();
    	
    	angleOutput = anglePID.getOutput(angleError);
    	leftOutput = distPID.getOutput(leftError) - angleOutput;
    	rightOutput = distPID.getOutput(rightError) + angleOutput;
    	
    	Drivetrain.setSpeed(ControlMode.PercentOutput, leftOutput, rightOutput);
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
