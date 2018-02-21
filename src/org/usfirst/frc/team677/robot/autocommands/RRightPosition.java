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
    	addSequential(new ResetGyro());
    	addSequential(new AutoStraightForward(30000));
//    	addParallel(new ElevatorManual (true, .5));
    	addSequential(new Turn(-90));
//    	addSequential(new AutoStraightForward(500));
//    	addSequential(new Grab(true, true));
//    	addSequential(new AutoStraightForward(-500));
//    	addParallel(new ElevatorManual(true, 0));
//    	addSequential(new Turn(90));
//    	addSequential(new AutoStraightForward(1000));
//    	addSequential(new Turn(-90));
//    	addSequential(new AutoStraightForward(500));
//    	addSequential(new Grab(true, false));   	
    }
}
