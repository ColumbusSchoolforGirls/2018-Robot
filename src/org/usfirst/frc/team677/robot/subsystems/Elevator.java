package org.usfirst.frc.team677.robot.subsystems;

import org.usfirst.frc.team677.robot.RobotMap;
import org.usfirst.frc.team677.robot.commands.ElevatorGoDown;
import org.usfirst.frc.team677.robot.commands.Tankdrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public static TalonSRX pulley = new TalonSRX(RobotMap.ELEVATOR_PORT);
	public static Encoder pulleyEncoder = new Encoder(RobotMap.PULLEY_ENCODER_A, RobotMap.PULLEY_ENCODER_B);
	
	public Elevator() {
		pulleyEncoder.reset();
	}

	public void drive (double speed) {
		pulley.set(ControlMode.PercentOutput, speed);
	}
	
	public static double getEncoder() {
		return pulleyEncoder.get();
	}
	
	public static void resetEncoder() {
		pulleyEncoder.reset();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new ElevatorGoDown());
    }
}

