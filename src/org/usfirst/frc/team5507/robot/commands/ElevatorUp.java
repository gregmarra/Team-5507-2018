package org.usfirst.frc.team5507.robot.commands;

import org.usfirst.frc.team5507.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorUp extends Command {

    public ElevatorUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
   // 	requires(Robot.m_elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
 //   	Robot.m_elevator.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
  //  	Robot.m_elevator.goUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
//    	return Robot.m_elevator.isSwitchSetTop();
    }

    // Called once after isFinished returns true
    protected void end() {
  //  	Robot.m_elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
