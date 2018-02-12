package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBaseline extends CommandGroup {

    public AutoBaseline() {
    	addSequential(new ResetGyro());
    	addSequential(new AutoStraightForward(Global.AUTO_STRAIGHT_FORWARD_SETPOINT));
    }
}
