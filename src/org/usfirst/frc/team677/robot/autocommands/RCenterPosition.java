package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RCenterPosition extends CommandGroup {

    public RCenterPosition() {
    	addSequential(new ResetGyro());
    	addSequential(new AutoStraightForward(Global.AUTO_FRONT_DISTANCE_ONE));
    	addSequential(new Turn(Global.AUTO_TURN_RIGHT));
    	addSequential(new AutoStraightForward(Global.AUTO_FRONT_DISTANCE_TWO));
    	addSequential(new Turn(Global.AUTO_TURN_LEFT));
    	addSequential(new AutoStraightForward(Global.AUTO_FRONT_DISTANCE_THREE));
    	//TODO: Add command to drop the cube
    }
}
