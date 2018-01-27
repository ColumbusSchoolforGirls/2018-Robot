/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team677.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	public static Joystick driveCont = new Joystick(Global.JOYSTICK_DRIVE);
	public static Joystick auxCont = new Joystick(Global.JOYSTICK_AUX);
	public static Button buttonA = new JoystickButton(driveCont, Global.BUTTON_A);
	public static Button buttonB = new JoystickButton(driveCont, Global.BUTTON_B);
	public static Button buttonX = new JoystickButton(driveCont, Global.BUTTON_X);
	public static Button buttonY = new JoystickButton(driveCont, Global.BUTTON_Y);
	public static Button leftBumper = new JoystickButton(driveCont, Global.LEFT_BUMPER);
	public static Button rightBumper = new JoystickButton(driveCont, Global.RIGHT_BUMPER);
	public static Button select = new JoystickButton(driveCont, Global.SELECT);
	public static Button start = new JoystickButton(driveCont, Global.START);
	
	public static Button auxButtonA = new JoystickButton(auxCont, Global.BUTTON_A);
	public static Button auxButtonB = new JoystickButton(auxCont, Global.BUTTON_B);
	public static Button auxButtonX = new JoystickButton(auxCont, Global.BUTTON_X);
	public static Button auxButtonY = new JoystickButton(auxCont, Global.BUTTON_Y);
	public static Button auxLeftBumper = new JoystickButton(auxCont, Global.LEFT_BUMPER);
	public static Button auxRightBumper = new JoystickButton(auxCont, Global.RIGHT_BUMPER);
	public static Button auxSelect = new JoystickButton(auxCont, Global.SELECT);
	public static Button auxStart = new JoystickButton(auxCont, Global.START);	
	
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
