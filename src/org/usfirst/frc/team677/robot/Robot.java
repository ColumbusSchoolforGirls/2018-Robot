/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team677.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team677.robot.autocommands.AutoBaseline;
import org.usfirst.frc.team677.robot.autocommands.AutoCenter;
import org.usfirst.frc.team677.robot.autocommands.AutoLeft;
import org.usfirst.frc.team677.robot.autocommands.AutoRight;
import org.usfirst.frc.team677.robot.autocommands.AutoStraightForward;
import org.usfirst.frc.team677.robot.autocommands.AutoTest;
import org.usfirst.frc.team677.robot.autocommands.NoAuto;
import org.usfirst.frc.team677.robot.commands.Tankdrive;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;
import org.usfirst.frc.team677.robot.subsystems.Elevator;
import org.usfirst.frc.team677.robot.subsystems.Ramp;
import org.usfirst.frc.team677.robot.subsystems.Arm;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Arm arm = new Arm();
	public static final Elevator elevator = new Elevator();
	public static final Ramp ramp = new Ramp();
	
	public static OI m_oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addDefault("No Auto", new NoAuto());
		m_chooser.addObject("AutoTest", new AutoTest());		
		m_chooser.addObject("Straight Forward", new AutoBaseline());
		m_chooser.addObject("Left Position", new AutoLeft());
		m_chooser.addObject("Center Position", new AutoCenter());
		m_chooser.addObject("Right Position", new AutoRight());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		update();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		update();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		new Tankdrive().start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		update();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	public void update() {
		drivetrain.update();
		elevator.update();
		Scheduler.getInstance().run();
	}
	
}
