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
	public static final double DRIVETRAIN_P = 0.0003;
	public static final double DRIVETRAIN_I = 0;
	public static final double DRIVETRAIN_D = 0;
	public static final double DRIVETRAIN_IZONE = 0;
	public static final double DRIVESTRAIGHT_ANGLE_P = 0.04;
	public static final double DRIVESTRAIGHT_ANGLE_I = 0;
	public static final double DRIVESTRAIGHT_ANGLE_D= 0;
	public static final double TURNANGLE_P = 0.00355;
	public static final double TURNANGLE_I = 0.001;
	public static final double TURNANGLE_D = 0;
	public static final double TURNANGLE_IZONE = 5;
	public static double ELEVATOR_P = 0;
	public static double ELEVATOR_I = 0;
	public static double ELEVATOR_D = 0;
	public static double ELEVATOR_IZONE = 0;
	//Auto setpoints, measured in encoder ticks
	//TODO: Tune these values
	//Note: It's 36506 ticks from the starting point to the edge of the switch. 
	//Further note: 16213 ticks on a turn is a full rotation.
	//Also, I am rounding these to integers, just for the sake of everyone's sanity. - Evelyn
	public static double DRIVETRAIN_ANGLE = 0;
	public static double AUTO_STRAIGHT_FORWARD_SETPOINT = 26076; //Tuned! Assuming just touching the baseline.
	public static double AUTO_SIDE_DISTANCE_ONE = 41722; //Tuned! Assuming aiming for the center of the switch.
	public static double AUTO_SIDE_DISTANCE_TWO = 13038; //Tuned! Assuming starting in either left or right corner.
	public static double AUTO_FRONT_DISTANCE_ONE = 18253; //Tuned! Assuming lateral shift halfway through.
	public static double AUTO_FRONT_DISTANCE_TWO = 14342; //Tuned! Assuming a lateral shift of 5.5 feet and starting in the exact center.
	public static double AUTO_FRONT_DISTANCE_THREE = 18253; //Tuned! Assuming lateral shift halfway through.
	public static double AUTO_BACK_DISTANCE_ONE = 52152; //Tuned! Assuming going 2 feet behind the switch.
	public static double AUTO_BACK_DISTANCE_TWO = 46937; //Tuned! Assuming starting in either left or right corner.
	public static double AUTO_BACK_DISTANCE_THREE = 10430; //Tuned! Assuming going 2 feet behind the switch.
	public static double AUTO_TURN_RIGHT = 4053; //Tuned! This is for 90 degrees.
	public static double AUTO_TURN_LEFT = -4053; //Tuned! This is for 90 degrees.
	
	//Miscellaneous
	public static final int DRIVE_DISTANCE_TOLERANCE = 1000; // Ticks
	public static final int ELEVATOR_TOLERANCE = 100; // Ticks
	public static final int DRIVE_ANGLE_TOLERANCE = 1; // Degrees

}
