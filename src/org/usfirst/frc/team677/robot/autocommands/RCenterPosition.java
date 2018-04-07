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
public class RCenterPosition extends CommandGroup {

    public RCenterPosition() {
    	addSequential(new ResetGyro());
    	addSequential(new Grab(false, true));
    	addSequential(new Wait(1));
    	addParallel(new ElevatorManual(true, .9),4);
    	addSequential(new AutoStraightForward(22000));
    	//addParallel(new ElevatorManual (true, .5));
    	//addSequential(new AutoStraightForward(10000));
    	//addSequential(new Turn(-90, 1), 1);
    	//addParallel(new ElevatorManual(true, .575), 4);
    	//addSequential(new AutoStraightForward(-13000));
    	//addSequential(new ResetGyro());
    	//addSequential(new Turn(90, 1),1);
    	//addSequential(new AutoStraightForward(12000), 1.5);
    	addSequential(new Grab(true, true));
    	addSequential(new Wait(1));
    	addSequential(new Grab(false, true));
    	addSequential(new AutoStraightForward(-5000));
    	addSequential(new ElevatorManual(true, -.4),2);
    }
}
