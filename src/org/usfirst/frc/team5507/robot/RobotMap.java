/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5507.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final double WHEEL_CIRCUMFERENCE = 18.84956;
	public static final double TICKS_PER_REVOLUTION = 4096;
	public static final double DISTANCE = TICKS_PER_REVOLUTION / WHEEL_CIRCUMFERENCE; //1 inch moved
	
	// PWM Outputs
	public static int intakeLeftMotor = 1;
	public static int intakeRightMotor = 3;
	
	// CAN Addresses 
	public static int driveFrontLeft = 1;
	public static int driveFrontRight = 24;
	public static int driveBackLeft = 0;
	public static int driveBackRight = 2;
//	public static int encoder = 4;
	
	public static int leftArm = 4;
	public static int rightArm = 5;
	
	public static int climb = 13;
	
	public static int elevator = 4;
		
}
