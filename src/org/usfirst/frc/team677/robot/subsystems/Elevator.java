package org.usfirst.frc.team677.robot.subsystems;

import org.usfirst.frc.team677.robot.RobotMap;
import org.usfirst.frc.team677.robot.commands.ElevatorGoDown;
import org.usfirst.frc.team677.robot.commands.Tankdrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public static TalonSRX pulley = new TalonSRX(RobotMap.ELEVATOR_PORT);
	public static DigitalInput limit_switch = new DigitalInput(RobotMap.ELEVATOR_PORT);
	
	public Elevator() {
		
	}

	public static void drive (double speed) {
		pulley.set(ControlMode.PercentOutput, speed);
	}
	
	public boolean getLimitSwitch() {
		return limit_switch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new ElevatorGoDown());
    }
}

