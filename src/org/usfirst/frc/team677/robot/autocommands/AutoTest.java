package org.usfirst.frc.team677.robot.autocommands;

import org.usfirst.frc.team677.robot.commands.ResetGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addSequential(new ResetGyro());
    	addSequential(new Turn(90));
    }
}
