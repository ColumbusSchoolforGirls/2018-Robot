package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.ElevatorManual;
import org.usfirst.frc.team677.robot.commands.Grab;
import org.usfirst.frc.team677.robot.commands.IntakeDrive;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LCenterPosition extends CommandGroup {

    public LCenterPosition() {
    	addSequential(new ResetGyro());
    	addSequential(new Grab(false, true));
    	addSequential(new Wait (1));
    	addSequential(new AutoStraightForward (10000));
    	addSequential(new ElevatorManual(true, -1), 1.25);
    	addSequential(new ResetGyro());
    	addSequential(new Turn(-90, 1),1);
    	addSequential(new AutoStraightForward (24000));
    	addSequential(new ResetGyro());
    	addSequential(new Turn(90, 1),1);
    	addSequential(new AutoStraightForward (8000), 2);
    	addSequential(new Grab(true,true));
    	addSequential(new Wait (1));
    	addSequential (new Grab(false, true));
    	addParallel (new ElevatorManual(true, .4),2);
    	//The cube is dropped
    	addSequential (new AutoStraightForward (-13000),1.25);
    	addSequential(new ResetGyro());
    	addSequential (new Turn (90,1),1);
    	//gonna go towards pyramid
    	addSequential(new AutoStraightForward(12500), 1);
    	addSequential(new ResetGyro());
    	addSequential(new Turn(-90, 1), 1);
    	addSequential(new Grab(true, true), 1);
    	addParallel(new IntakeDrive(1), 1);
    	addSequential(new AutoStraightForward(6000), 1);
    	addSequential(new Grab(false, true), 1);
    	//this grabs the second cube from the pyramid
    	addSequential(new Wait(.75));
    	addSequential(new ElevatorManual(true, -1), 1);
    	//addSequential(new AutoStraightForward(-5000), 1);
    	addSequential(new ResetGyro());
    	addSequential(new Turn(-100, 1), 1);
    	addSequential(new AutoStraightForward(13000));
    	addSequential(new ResetGyro());
    	addSequential(new Turn(95, 1), 1);
    	addSequential(new AutoStraightForward(10000), .75);
    	addSequential(new Grab(true, true));
    	addSequential(new Wait(.75));
    	addSequential(new AutoStraightForward(-5000), 1);
    	addSequential(new ElevatorManual(true, .4), 1.25);
    	
    	
    	//addSequential (new ElevatorManual(true, ))
//    	addSequential(new ResetGyro());
//    	addSequential(new Grab(false, true));
//    	addSequential(new Wait(.5));
//    	//addParallel(new ElevatorManual (true, .5));
//    	addSequential(new AutoStraightForward(10000));
//    	addSequential(new Turn(-90, 1), 1);
//    	addParallel(new ElevatorManual(true, .575), 4);
//    	addSequential(new AutoStraightForward(13000));
//    	addSequential(new ResetGyro());
//    	addSequential(new Turn(90, 1), 1);
//    	addSequential(new AutoStraightForward(12000), 1.5);
//    	addSequential(new Grab(true, true));
//    	addSequential(new Wait(1));
//    	addSequential(new Grab(false, true));
//    	addSequential(new AutoStraightForward(-5000));
//    	//TODO: fix me
    	
    }
}
