package org.usfirst.frc.team677.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Eject extends CommandGroup {

    public Eject() {
    	addSequential(new Grab(true,false), 0.5);
    	addParallel(new IntakeDrive(-1),.75);
    	addSequential(new Grab(false, false),1);
    }
}
