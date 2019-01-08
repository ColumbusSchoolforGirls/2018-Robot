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
public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addSequential(new ResetGyro());
    	addSequential(new Grab(false, true));
    	addSequential(new Wait(1));
    	addSequential (new ElevatorManual (true, .6),4);
    	addSequential(new Grab(true,true));
    	addSequential(new Wait (1));
    	addSequential (new Grab(false, true));
    	addSequential (new ElevatorManual (true, -.4),2);
    }
}
