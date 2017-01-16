package org.usfirst.frc.team4125.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a sample program to demonstrate how to use a gyro sensor to make a
 * robot drive straight. This program uses a joystick to drive forwards and
 * backwards while the gyro is used for direction keeping.
 */
public class Robot extends IterativeRobot {
	public SmartDashboard dashboard = new SmartDashboard();
	//public static GyroBase gyro;
	public static boolean selected = true;
    Joystick controller;
    //Joystick rightStick;// set to ID 1 in DriverStation
    Talon talon1, talon2, talon3, talon4, talon5, talon6, shooter;
//    AnalogGyro gyro;
    SPI gyro;
    double value;
    boolean shooterToggle;
    boolean shooterButton;

	@Override
	public void robotInit() {
		controller = new Joystick(0);
        talon1 = new Talon(1);
        talon2 = new Talon(2);
        talon3 = new Talon(3);
        talon4 = new Talon(4);
        talon5 = new Talon(5);
        talon6 = new Talon(6);
        shooter = new Talon(7);
        gyro = new SPI(Port.kOnboardCS0);
//        ultraSonic = new Ultrasonic(7, 8);
	}

	/**
	 * The motor speed is set from the joystick while the RobotDrive turning
	 * value is assigned from the error between the setpoint and the gyro angle.
	 */
	public void teleopInit() {
    	talon1.set(0);
    	talon2.set(0);
    	talon3.set(0);
    	talon4.set(0);
		talon5.set(0);
		talon6.set(0);
		
	}
	
	@Override
	public void teleopPeriodic() {
		if(controller.getRawAxis(0) > 0.1){
        	talon1.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	talon2.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	talon3.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	talon4.set(controller.getRawAxis(1) + controller.getRawAxis(0));
        	talon5.set(controller.getRawAxis(1) + controller.getRawAxis(0));
        	talon6.set(controller.getRawAxis(1) + controller.getRawAxis(0));
    	}else if(controller.getRawAxis(0) < -0.1){
        	talon1.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	talon2.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	talon3.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	talon4.set(controller.getRawAxis(1) + controller.getRawAxis(0));
        	talon5.set(controller.getRawAxis(1) + controller.getRawAxis(0));
        	talon6.set(controller.getRawAxis(1) + controller.getRawAxis(0));
    	}else if(controller.getRawAxis(1) > 0.1 || controller.getRawAxis(1) < -0.1){
    		talon1.set(controller.getRawAxis(1));
    		talon2.set(controller.getRawAxis(1));
    		talon3.set(controller.getRawAxis(1));
    		talon4.set(controller.getRawAxis(1));
    		talon5.set(controller.getRawAxis(1));
    		talon6.set(controller.getRawAxis(1));
    	}else {
    		talon1.set(0);
    		talon2.set(0);
    		talon3.set(0);
    		talon4.set(0);
    		talon5.set(0);
    		talon6.set(0);
    	}
		
	}
}
