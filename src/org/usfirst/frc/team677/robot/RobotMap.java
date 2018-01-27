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
	// TalonSRX ports
	public static final int LEFT_DRIVE_PORT_FRONT = 0;
	public static final int RIGHT_DRIVE_PORT_FRONT = 1;
	public static final int LEFT_DRIVE_PORT_BACK = 2;
	public static final int RIGHT_DRIVE_PORT_BACK = 3;
	
	// Solenoid ports
	public static final int CLAW_SOL_A_PORT = 4;
	public static final int CLAW_SOL_B_PORT = 5;
}
