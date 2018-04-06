package org.usfirst.frc.team677.robot.subsystems;

import org.usfirst.frc.team677.robot.RobotMap;
import org.usfirst.frc.team677.robot.commands.IntakeDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	public static TalonSRX leftWheels = new TalonSRX(RobotMap.LEFT_INTAKE_WHEEL_PORT);
	public static TalonSRX rightWheels = new TalonSRX(RobotMap.RIGHT_INTAKE_WHEEL_PORT);
	
	public Intake () {
		
	}
	
	public static void runIntake(double speed) {
		leftWheels.set(ControlMode.PercentOutput, speed);
		rightWheels.set(ControlMode.PercentOutput, -speed);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new IntakeDrive(0));
	}
}
