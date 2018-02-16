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
public class Turn extends Command {

	double angleError = 0;
	double angleOutput = 0;
	PIDCalculator anglePID = new PIDCalculator(Global.ANGLE_P, Global.ANGLE_I, Global.ANGLE_D, Global.ANGLE_IZONE);

	public double setpoint;

	public Turn(double ticks) {
		requires(Robot.drivetrain);
		setpoint = ticks;
	}

	protected void initialize() {
	}

	protected void execute() {
		angleError = setpoint - Drivetrain.getFacingAngle();
		angleOutput = anglePID.getOutput(angleError);

		Drivetrain.setSpeed(ControlMode.PercentOutput, -angleOutput, angleOutput); // TODO: Figure out which is positive
																					// and which is negative
	}

	protected boolean isFinished() {
		return Math.abs(angleError) <= Global.DRIVE_ANGLE_TOLERANCE;
	}

	protected void end() {
		Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
	}

	protected void interrupted() {
	}
}
