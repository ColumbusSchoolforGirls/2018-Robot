package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.ElevatorManual;
import org.usfirst.frc.team677.robot.commands.Grab;
import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LCenterPosition extends CommandGroup {

    public LCenterPosition() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new ResetGyro());
    	addSequential(new Grab(false, true));
    	addSequential(new Wait(.5));
    	//addParallel(new ElevatorManual (true, .5));
    	addSequential(new AutoStraightForward(10000));
    	addSequential(new Turn(-90, 1));
    	addParallel(new ElevatorManual(true, .5), 4);
    	addSequential(new AutoStraightForward(13000));
    	addSequential(new ResetGyro());
    	addSequential(new Turn(90, 1));
    	addSequential(new AutoStraightForward(12000), 1.5);
    	addSequential(new Grab(true, true));
    	addSequential(new Wait(1));
    	addSequential(new Grab(false, true));
    	addSequential(new AutoStraightForward(-5000));
    	//TODO: fix me
    	
    }
}
