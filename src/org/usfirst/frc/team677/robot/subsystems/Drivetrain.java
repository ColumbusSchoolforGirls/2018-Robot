/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team677.robot.subsystems;

import org.usfirst.frc.team677.robot.ADIS16448_IMU;
import org.usfirst.frc.team677.robot.RobotMap;
import org.usfirst.frc.team677.robot.commands.Tankdrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public static TalonSRX left_front = new TalonSRX(RobotMap.LEFT_DRIVE_PORT_FRONT);
	public static TalonSRX right_front = new TalonSRX(RobotMap.RIGHT_DRIVE_PORT_FRONT);
	public static TalonSRX left_back = new TalonSRX(RobotMap.LEFT_DRIVE_PORT_BACK);
	public static TalonSRX right_back = new TalonSRX(RobotMap.RIGHT_DRIVE_PORT_BACK);
	public static ADIS16448_IMU imu = new ADIS16448_IMU();

	public Drivetrain() {
		left_front.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		right_front.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

		left_front.setNeutralMode(NeutralMode.Brake);
		right_front.setNeutralMode(NeutralMode.Brake);
		left_back.setNeutralMode(NeutralMode.Brake);
		right_back.setNeutralMode(NeutralMode.Brake);
		
		imu.calibrate();
		imu.reset();
	}

	public static void setSpeed(ControlMode mode, double leftSpeed, double rightSpeed) {
		
		left_front.set(mode, -leftSpeed);
		right_front.set(mode, rightSpeed);
		left_back.set(mode, -leftSpeed); //TODO: Is this supposed to be negative?
		right_back.set(mode, rightSpeed);
	}

	public static void resetEncoders() {
		left_front.setSelectedSensorPosition(0, 0, 0);
	}
	
	public static void setPID(double prop, double integral, double deriv) {
		left_front.config_kP(0, prop, 0); //TODO: Figure out what the first parameter is supposed to be
		left_front.config_kI(0, integral, 0);
		left_front.config_kD(0, deriv, 0);
		right_front.config_kP(0, prop, 0);
		right_front.config_kI(0, integral, 0);
		right_front.config_kD(0, deriv, 0);
	}
	
	public static void resetGyroscope() {
		imu.reset();
	}

	public static double getLeftEncoder() {
		return -left_front.getSelectedSensorPosition(0);
	}

	public static double getRightEncoder() {
		return right_front.getSelectedSensorPosition(0);
	}
	
	public static double getLeftError() {
		return (left_front.getClosedLoopError(0));
	}
	
	public static double getRightError() {
		return (right_front.getClosedLoopError(0));
	}
	
	public static double getFacingAngle() {
		return imu.getAngle();
	}

	public void update() {
		SmartDashboard.putNumber("Left Encoder", getLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", getRightEncoder());
		SmartDashboard.putNumber("Left Error", getLeftError());
		SmartDashboard.putNumber("Right Error", getRightError());
		SmartDashboard.putNumber("Facing Angle", imu.getAngle());
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Tankdrive());
	}
	
}
