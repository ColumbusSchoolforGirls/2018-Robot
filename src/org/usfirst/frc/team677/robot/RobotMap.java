/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team677.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Solenoid ports
	public static final int CLAW_SOL_A_PORT = 0;
	public static final int CLAW_SOL_B_PORT = 7;
	
	// TalonSRX Addresses
	public static final int LEFT_DRIVE_PORT_FRONT = 3;
	public static final int RIGHT_DRIVE_PORT_FRONT = 2;
	public static final int LEFT_DRIVE_PORT_BACK = 4;
	public static final int RIGHT_DRIVE_PORT_BACK = 1;
	public static final int ELEVATOR_PORT = 5;
	public static final int INTAKE_WHEEL_PORT = 6;
	
	// DIO Ports
	public static final int PULLEY_ENCODER_A = 0;
	public static final int PULLEY_ENCODER_B = 1;
	
	//Limit switch
	public static final int LIMIT_SWITCH = 0; //TODO: Replace this with the actual value
}
