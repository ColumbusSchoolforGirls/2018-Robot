package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.Grab;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBaseline extends CommandGroup {

    public AutoBaseline() {
    	addSequential(new ResetGyro());
    	addSequential(new Grab(false, true));
    	addSequential(new Wait(.5));
    	addSequential(new AutoStraightForward(31500));
    }
}
