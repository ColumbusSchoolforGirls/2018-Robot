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
    	addSequential(new Wait(.75));
    	addSequential(new ElevatorManual(true, -1), 1.5);
    	addSequential(new AutoStraightForward(22000));
    	addSequential(new Grab(true, true));
    	addSequential(new Wait(.5));
    	addSequential(new Grab(false, true));
    	//this is where is drops the first cube in the switch
    	addParallel(new ElevatorManual(true,.4),1.25);
    	addSequential(new AutoStraightForward(-15500),1);
    	addSequential(new ResetGyro());
    	addSequential(new Turn (-90,1),1);
    	addSequential(new AutoStraightForward(12500), 1);
    	addSequential(new ResetGyro());
    	addSequential(new Turn(90, 1), 1);
    	addSequential(new Grab(true, true), 1);
    	addParallel(new IntakeDrive(1), 1);
    	addSequential(new AutoStraightForward(5000), 1);
    	addSequential(new Grab(false, true), 1);
    	//this grabs the second cube from the pyramid
    	addSequential(new Wait(.75));
    	addSequential(new ElevatorManual(true, -1), 1);
    	//addSequential(new AutoStraightForward(-5000), 1);
    	addSequential(new ResetGyro());
    	addSequential(new Turn(100, 1), 1);
    	addSequential(new AutoStraightForward(13000));
    	addSequential(new ResetGyro());
    	addSequential(new Turn(-95, 1), 1);
    	addSequential(new AutoStraightForward(10000), .75);
    	addSequential(new Grab(true, true));
    	addSequential(new Wait(.75));
    	addSequential(new AutoStraightForward(-5000), 1);
    	addSequential(new ElevatorManual(true, .4), 1.25);
    }
}
