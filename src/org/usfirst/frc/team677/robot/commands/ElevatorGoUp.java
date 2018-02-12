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

    protected void initialize() {
    	Elevator.resetEncoder();
    	position = 0;
    }

    protected void execute() {
    	error = setpoint - position;
    	output = elevatorPID.getOutput(error);
    	
    	Elevator.drive(output);
    }

    protected boolean isFinished() {
        return (error <= Global.ENCODER_TOLERANCE);
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
