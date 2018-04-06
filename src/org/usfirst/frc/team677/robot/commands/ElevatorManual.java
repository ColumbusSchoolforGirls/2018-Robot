package org.usfirst.frc.team677.robot.commands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.OI;
import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Arm;
import org.usfirst.frc.team677.robot.subsystems.Drivetrain;
import org.usfirst.frc.team677.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorManual extends Command {

	boolean auto;
	double speed;
	
	public ElevatorManual(boolean auto, double speed) {
		requires(Robot.elevator);
		this.auto = auto;
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		if (auto) {
			Elevator.drive(speed);
		} else {
			if (OI.auxCont.getRawAxis(1) < -Global.DEAD_ZONE) {
				Elevator.drive(.85 * OI.auxCont.getRawAxis(1));

			} else {
				Elevator.drive(0);
			}
		}
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Elevator.drive(0);
	}

	protected void interrupted() {
		Elevator.drive(0);
	}
}
