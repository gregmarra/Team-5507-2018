package org.usfirst.frc.team5507.robot.subsystems;

import org.usfirst.frc.team5507.robot.Constants;
import org.usfirst.frc.team5507.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class SmartGripper2 extends Subsystem {

	private static int currentState;
	
	public static final int STATE_START = 1;
	public static final int STATE_OPEN = 2;
	public static final int STATE_CLOSED = 3;
	
	private static final double DEGREES_START = 0.0;
	private static final double DEGREES_OPEN = 150.0;
	private static final double DEGREES_CLOSED = 180.0;
	
	private WPI_TalonSRX leftArm = new WPI_TalonSRX(RobotMap.leftArm);
	private WPI_TalonSRX rightArm = new WPI_TalonSRX(RobotMap.rightArm);
	
	public SmartGripper2() {
		super();
		
		currentState = STATE_START;
		
		// TODO: Move configTalon out of DriveTrain if we're using it generically.
		DriveTrain.configTalon(leftArm);
		DriveTrain.configTalon(rightArm);
		resetEncoders();
		
		// Set up logging to the dashboard to know about sub-components
		LiveWindow.addChild(this, leftArm);
		LiveWindow.addChild(this, rightArm);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
	
	public double getCurrentPosL() {
		return leftArm.getSelectedSensorPosition(0);
	}

	public double getCurrentPosR() {
		return rightArm.getSelectedSensorPosition(0);
	}

	public int getToggledState() {
		// Return the "opposite" state of the current state.
		switch (currentState) {
			case STATE_START:
				// Consider "Open" the opposite of "Start"
				return STATE_OPEN;
				break;
			case STATE_OPEN:
				return STATE_CLOSED;
				break;
			case STATE_CLOSED:
				return STATE_OPEN;
				break;
			default:
				// Add a safe default
				return STATE_OPEN;
				break;
		}
	}
	
	private void resetEncoders() {
		leftArm.setSelectedSensorPosition(0, 0, 0);
		rightArm.setSelectedSensorPosition(0, 0, 0);
	}
	
	public void setState(int state) {
		// Don't allow invalid states, instead set to STATE_OPEN
		if(state < STATE_START || state > STATE_CLOSED) {
			state = STATE_OPEN;
		}
		
		currentState = state;
	
		switch (currentState) {
			case STATE_START:
				setTargetAngles(DEGREES_START);
				break;
			case STATE_OPEN:
				setTargetAngles(DEGREES_OPEN);
			break;
		case STATE_CLOSED:
			setTargetAngles(DEGREES_CLOSED);
			break;
		default:
			// if in an invalid state, set to STATE_OPEN just in case
			setTargetAngles(DEGREES_OPEN);
			break;
		}
	}
	
	private void setTargetAngles(double degrees) {
		double targetPos = (degrees * 4096) / 360; // Convert from degrees to ticks 	
		leftArm.set(ControlMode.MotionMagic, targetPos);
		rightArm.set(ControlMode.MotionMagic, -targetPos); // "negative" angle to drive opposite direction
	}
	
	private void stop() {
		leftArm.set(0);
		rightArm.set(0);
	}

}
