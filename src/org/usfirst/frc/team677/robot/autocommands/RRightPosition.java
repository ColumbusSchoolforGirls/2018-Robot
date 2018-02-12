package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.Grab;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RRightPosition extends CommandGroup {

    public RRightPosition() {
    	addSequential (new ResetGyro());
    	addSequential (new AutoStraightForward (Global.AUTO_SIDE_DISTANCE_ONE));
    	addSequential (new Turn (Global.AUTO_TURN_LEFT));
    	addSequential (new AutoStraightForward (Global.AUTO_SIDE_DISTANCE_TWO));
    	addSequential (new Grab (true)); //TODO: Make sure this is the right direction    	
    }
}
