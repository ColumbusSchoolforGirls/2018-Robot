package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.Grab;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addSequential (new ResetGyro());
    	addSequential (new AutoStraightForward(10000));
    	addSequential (new Turn(-90));
    	addSequential (new AutoStraightForward(10000));
    	addSequential (new Turn(90));
    	addSequential (new AutoStraightForward(10000));
//    	addSequential (new AutoStraightForward (Global.AUTO_FRONT_DISTANCE_TWO));
//    	addSequential (new Turn (Global.AUTO_TURN_RIGHT));
//    	addSequential (new AutoStraightForward (Global.AUTO_FRONT_DISTANCE_THREE));
    	
//    	addSequential(new AutoStraightForward(Global.AUTO_SIDE_DISTANCE_TWO));
//    	addSequential(new Grab(true)); //TODO: Make sure this is the right direction
    }
}
