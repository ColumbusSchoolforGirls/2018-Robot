package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.PIDCalculator;
import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoStraightForward extends Command {
	private double leftError;
	private double rightError;
	private double angle;
	private double setpoint;
	private PIDCalculator distPID;
	private PIDCalculator anglePID;

    public AutoStraightForward(double ticks) {
    	requires(Robot.drivetrain);
    	setpoint = ticks; //When calling this method, ticks should be one of the Global constants
    	distPID = new PIDCalculator(Global.DRIVETRAIN_P, Global.DRIVETRAIN_I, Global.DRIVETRAIN_D); //TODO: Tune this
    	anglePID = new PIDCalculator(Global.DRIVESTRAIGHT_ANGLE_P, Global.DRIVESTRAIGHT_ANGLE_I, Global.DRIVESTRAIGHT_ANGLE_D);
    	Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
    }

    protected void initialize() {
    	Drivetrain.resetEncoders();
    	angle = Drivetrain.getFacingAngle();
    }

    protected void execute() {
    	leftError = setpoint - Drivetrain.getLeftEncoder();
    	rightError = setpoint - Drivetrain.getRightEncoder();
    	double angleError = angle - Drivetrain.getFacingAngle();
    	
    	double leftOutput = distPID.getOutput(leftError);
    	double rightOutput = distPID.getOutput(rightError);
    	double angleOutput = anglePID.getOutput(angleError);
    	
    	SmartDashboard.putNumber("Left Error", leftError);    	
    	SmartDashboard.putNumber("Right Error", rightError);
    	
    	Drivetrain.setSpeed(ControlMode.PercentOutput, -leftOutput - angleOutput, -rightOutput + angleOutput);
    }

    protected boolean isFinished() {
        return Math.abs(leftError) <= Global.DRIVE_DISTANCE_TOLERANCE;
    }

    protected void end() {
    	Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
//    	Drivetrain.resetEncoders();    	
    }

    protected void interrupted() {
    }
   
}

