package org.usfirst.frc.team677.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team677.robot.RobotMap;
import org.usfirst.frc.team677.robot.commands.Grab;
import org.usfirst.frc.team677.robot.commands.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/** 
 *
 */
public class Arm extends Subsystem {
	public static DoubleSolenoid claw = new DoubleSolenoid(RobotMap.CLAW_SOL_A_PORT, RobotMap.CLAW_SOL_B_PORT);
	public static Compressor compressor = new Compressor();
	public static TalonSRX wheels = new TalonSRX(RobotMap.INTAKE_WHEEL_PORT);

	public static void grab(boolean open) {
		if (open) {
			claw.set(Value.kForward);
		} else {
			claw.set(Value.kReverse);
		}
	}
	
	public static void runIntake(double speed) {
		wheels.set(ControlMode.PercentOutput, speed);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new Intake(0));
	}
}
