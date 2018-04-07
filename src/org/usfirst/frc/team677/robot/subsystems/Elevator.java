package org.usfirst.frc.team677.robot.subsystems;

import org.usfirst.frc.team677.robot.RobotMap;
import org.usfirst.frc.team677.robot.commands.ElevatorManual;
import org.usfirst.frc.team677.robot.commands.Tankdrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
	public static TalonSRX pulley = new TalonSRX(RobotMap.ELEVATOR_PORT);
	public static Encoder pulleyEncoder = new Encoder(RobotMap.PULLEY_ENCODER_A, RobotMap.PULLEY_ENCODER_B);
	//public static DigitalInput limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH);
	
	public Elevator() {	
		pulley.setNeutralMode(NeutralMode.Brake);
		pulleyEncoder.reset();
		pulley.configPeakCurrentLimit(45, 10);
		pulley.configPeakCurrentDuration(200, 10);
		pulley.configContinuousCurrentLimit(40, 10);
		pulley.enableCurrentLimit(false);
		
	}

	public static void drive(double speed) {
		pulley.set(ControlMode.PercentOutput, speed);
	}

	public static void resetEncoder() {
		pulleyEncoder.reset();
	}
	
	public static double getEncoder() {
		return pulleyEncoder.getDistance();
	}
	
	//public static boolean checkSwitch() {
		//return limitSwitch.get();
		//}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ElevatorManual(false, 0));
    }
    
	public void update() {
		SmartDashboard.putNumber("Elevator Current", pulley.getOutputCurrent());
		SmartDashboard.putNumber("Elevator Encoder", getEncoder());
	}
}

