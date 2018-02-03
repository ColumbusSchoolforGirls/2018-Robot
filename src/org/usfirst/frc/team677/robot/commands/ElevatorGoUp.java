package org.usfirst.frc.team677.robot.commands;

import org.usfirst.frc.team677.robot.Global;
import org.usfirst.frc.team677.robot.PIDCalculator;
import org.usfirst.frc.team677.robot.Robot;
import org.usfirst.frc.team677.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorGoUp extends Command {
	double error;
	double output;
	double setpoint;
	double position;
	PIDCalculator elevatorPID = new PIDCalculator(Global.ELEVATOR_P, Global.ELEVATOR_I, Global.ELEVATOR_D, Global.ELEVATOR_IZONE);
	
    public ElevatorGoUp(double ticks){
    	requires(Robot.elevator);
    	setpoint = ticks;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Elevator.resetEncoder();
    	position = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	error = setpoint - position;
    	output = elevatorPID.getOutput(error);
    	
    	Robot.elevator.drive(output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (error <= Global.ENCODER_TOLERANCE);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
