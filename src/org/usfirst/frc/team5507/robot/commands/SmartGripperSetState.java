package org.usfirst.frc.team5507.robot.commands;

import org.usfirst.frc.team5507.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Sets the SmartGripper to the desired state.
 */
public class SmartGripperSetState extends InstantCommand {
	
	private int state;

    public SmartGripperSetState(int s) {
        super();
        requires(Robot.m_gripper);
        
        state = s;
    }

    // Called once when the command executes
    protected void initialize() {
    		Robot.m_gripper.setState(state);
    }

}
