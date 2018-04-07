package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.ElevatorManual;
import org.usfirst.frc.team677.robot.commands.Grab;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LRightPosition extends CommandGroup {

    public LRightPosition() {  	
    	addSequential(new ResetGyro());
    	addSequential(new Grab(false, true));
    	addSequential(new Wait(.5));
//    	//addParallel(new ElevatorManual (true, .85));
    	addSequential(new AutoStraightForward(31500));
//    	addSequential(new Turn(90), 1.5);
//    	addSequ+
//    	 ential(new AutoStraightForward(5000));
//    	addSequential(new Grab(true, true));
//    	addSequential (new Wait(1.5));
//    	addSequential(new AutoStraightForward(-5000));    
    	}
}
