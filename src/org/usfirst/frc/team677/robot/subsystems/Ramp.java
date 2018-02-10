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
	
	public static DoubleSolenoid rampSolenoid = new DoubleSolenoid(RobotMap.RAMP_SOL_A_PORT, RobotMap.RAMP_SOL_B_PORT);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Ramp() {
		release(false);
	}

    public void initDefaultCommand() {
        
    }
    
    public static void release(boolean isEndgame) {
    	if (isEndgame) {
    		rampSolenoid.set(Value.kForward);
    	} else {
    		rampSolenoid.set(Value.kReverse);
    	}
    }
}

