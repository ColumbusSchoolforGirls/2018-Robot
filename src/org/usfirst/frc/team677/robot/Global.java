package org.usfirst.frc.team677.robot;

public class Global {
	//Controllers
	//Buttons
	public static final int JOYSTICK_DRIVE = 0;
	public static final int JOYSTICK_AUX = 1;
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B =2;
	public static final int BUTTON_X=3;
	public static final int BUTTON_Y=4;
	public static final int LEFT_BUMPER = 5;
	public static final int RIGHT_BUMPER = 6;
	public static final int SELECT = 7;
	public static final int START = 8;
	
	//Drivetrain
	public static final double DEAD_ZONE = 0.2;
	//PID control constants
	//TODO: Tune these values
	public static double DRIVETRAIN_P = 0;
	public static double DRIVETRAIN_I = 0;
	public static double DRIVETRAIN_D = 0;
	public static double DRIVETRAIN_IZONE = 0;
	public static double ANGLE_P = 0;
	public static double ANGLE_I = 0;
	public static double ANGLE_D = 0;
	public static double ANGLE_IZONE = 0;
	//Auto setpoints, measured in encoder ticks
	//TODO: Tune these values
	public static double DRIVETRAIN_ANGLE = 0;
	
	//Miscellaneous
	public static final int ENCODER_TOLERANCE = 25; //TODO: Tune this
}
