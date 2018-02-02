package org.usfirst.frc.team5507.robot.commands;

import org.usfirst.frc.team5507.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Because this Command only needs to update the desired state, we do not 
 * need to leave it running. Therefore, we are using an InstantCommand.
 * 
 * It can tell the SmartGripper where we want to go and then terminate, 
 * while the SmartGripper TalonSRX's move themselves to the position for
 * that state.
 */
public class SmartGripperToggle extends InstantCommand {

	public SmartGripperToggle() {
		super();
		requires(Robot.m_gripper);
	}

	// Called once when the command executes
	protected void initialize() {
		Robot.m_gripper.setState(Robot.m_gripper.getToggledState());
	}

}
