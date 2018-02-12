package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LLeftPosition extends CommandGroup {

    public LLeftPosition() {
    	addSequential(new ResetGyro());
    	addSequential(new AutoStraightForward(Global.AUTO_SIDE_DISTANCE_ONE));
    	addSequential(new Turn(Global.AUTO_TURN_RIGHT));
    	addSequential(new AutoStraightForward(Global.AUTO_SIDE_DISTANCE_TWO));
    	//TODO: Add command to drop the cube
    }
}
