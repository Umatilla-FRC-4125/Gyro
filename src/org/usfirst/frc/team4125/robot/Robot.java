package org.usfirst.frc.team4125.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.TalonSRX;
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
	
	public ADXRS450_Gyro gyro;
	public SmartDashboard dashboard = new SmartDashboard();
	//public static GyroBase gyro;
	public static boolean selected = true;
    Joystick controller;
    //Joystick rightStick;// set to ID 1 in DriverStation
    TalonSRX l1, l2, l3, r1, r2, r3;
    Talon shooter;
//    AnalogGyro gyro;
    double value;
    boolean shooterToggle;
    boolean shooterButton;

	@Override
	public void robotInit() {
		gyro = new ADXRS450_Gyro();
		controller = new Joystick(0);
        l1 = new TalonSRX(5);
        l2 = new TalonSRX(1);
        l3 = new TalonSRX(3);
        r1 = new TalonSRX(4);
        r2 = new TalonSRX(2);
        r3 = new TalonSRX(0);
        shooter = new Talon(7);
//        ultraSonic = new Ultrasonic(7, 8);
	}

	/**
	 * The motor speed is set from the joystick while the RobotDrive turning
	 * value is assigned from the error between the setpoint and the gyro angle.
	 */
	public void teleopInit() {
		gyro.calibrate();
		gyro.reset();
    	l1.set(0);
    	l2.set(0);
    	l3.set(0);
    	r1.set(0);
		r2.set(0);
		r3.set(0);
		
	}
	
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("Gyro Angle: ", gyro.getAngle());
		SmartDashboard.putNumber("Gyro Rate: ", gyro.getRate());
		if(controller.getRawAxis(0) > 0.1){
        	l1.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	l2.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	l3.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	r1.set(controller.getRawAxis(1) + controller.getRawAxis(0));
        	r2.set(controller.getRawAxis(1) + controller.getRawAxis(0));
        	r3.set(controller.getRawAxis(1) + controller.getRawAxis(0));
    	}else if(controller.getRawAxis(0) < -0.1){
        	l1.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	l2.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	l3.set(controller.getRawAxis(1) - controller.getRawAxis(0));
        	r1.set(controller.getRawAxis(1) + controller.getRawAxis(0));
        	r2.set(controller.getRawAxis(1) + controller.getRawAxis(0));
        	r3.set(controller.getRawAxis(1) + controller.getRawAxis(0));
    	}else if(controller.getRawAxis(1) > 0.1 || controller.getRawAxis(1) < -0.1){
    		l1.set(controller.getRawAxis(1));
    		l2.set(controller.getRawAxis(1));
    		l3.set(controller.getRawAxis(1));
    		r1.set(controller.getRawAxis(1));
    		r2.set(controller.getRawAxis(1));
    		r3.set(controller.getRawAxis(1));
    	}else {
    		l1.set(0);
    		l2.set(0);
    		l3.set(0);
    		r1.set(0);
    		r2.set(0);
    		r3.set(0);
    	}
		
	}
}
