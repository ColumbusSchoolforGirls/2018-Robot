package org.usfirst.frc.team677.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team677.robot.RobotMap;
import org.usfirst.frc.team677.robot.commands.Grab;

/** 
 *
 */
public class Arm extends Subsystem {

	public static DoubleSolenoid claw = new DoubleSolenoid(RobotMap.CLAW_SOL_A_PORT, RobotMap.CLAW_SOL_B_PORT);
	public static Compressor compressor = new Compressor();

	public static void grab(boolean retract) {
		if (retract) {
			claw.set(Value.kForward);
		} else {
			claw.set(Value.kReverse);
		}
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new Grab(false));
	}
}
