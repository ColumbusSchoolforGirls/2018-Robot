package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.commands.ElevatorManual;
import org.usfirst.frc.team677.robot.commands.Grab;
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
    	addParallel(new ElevatorManual (true, .7), .75);
    	addSequential(new AutoStraightForward(31500));
    	addParallel(new AutoElevatorTime(), 8);
    }
}
