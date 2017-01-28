package org.usfirst.frc.team6593.robot.subsystems;

import org.usfirst.frc.team6593.robot.RobotMap;
import org.usfirst.frc.team6593.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController leftSC, rightSC;
	private RobotDrive robotdrive;
	
	public DriveTrain(){
		super();
		
		leftSC = new Spark(RobotMap.leftMotor);
		rightSC = new Spark(RobotMap.rightMotor);
		
		robotdrive = new RobotDrive(rightSC, leftSC);
	}
	
	public void drive(double leftSpeed, double rightSpeed){
		robotdrive.tankDrive(leftSpeed, rightSpeed);
	}
	
	public void stop(){
		robotdrive.drive(0,0);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
}

