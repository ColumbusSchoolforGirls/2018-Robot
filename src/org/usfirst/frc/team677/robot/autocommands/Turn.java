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
public class Turn extends Command {

	private double angle;
	private double angleError;
	private PIDCalculator anglePID;

	public Turn(double angle) {
		requires(Robot.drivetrain);
		this.angle = angle;
		anglePID = new PIDCalculator(Global.ANGLE_P, Global.ANGLE_I, Global.ANGLE_D, Global.ANGLE_IZONE);
	}

	protected void initialize() {
	}

	protected void execute() {
		angleError = angle - Drivetrain.getFacingAngle();
		double angleOutput = anglePID.getOutput(angleError);
		
		SmartDashboard.putNumber("Angle Output", angleOutput);
		SmartDashboard.putNumber("Angle Error", angleError);

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
