package org.usfirst.frc.team677.robot.subsystems;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ramp extends Subsystem {
	
	public static DoubleSolenoid rampReleaseSolenoid = new DoubleSolenoid(RobotMap.RAMPRELEASE_SOL_A_PORT, RobotMap.RAMPRELEASE_SOL_B_PORT);
	public static DoubleSolenoid rampLiftSolenoid = new DoubleSolenoid(RobotMap.RAMPLIFT_SOL_A_PORT, RobotMap.RAMPLIFT_SOL_B_PORT);
	
	public Ramp() {
		release(false);
	}

    public void initDefaultCommand() {
        
    }
    
    public static void release(boolean release) {
    	if (release) {
    		rampReleaseSolenoid.set(Value.kForward);
    	} else {
    		rampReleaseSolenoid.set(Value.kReverse);
    	}
    }
    public static void lift(boolean lift) {
    	if (lift) {
    		rampLiftSolenoid.set(Value.kForward);
    	} else {
    		rampLiftSolenoid.set(Value.kReverse);
    	}
    }
}

