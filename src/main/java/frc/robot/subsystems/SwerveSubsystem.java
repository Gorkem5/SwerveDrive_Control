package frc.robot.subsystems;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// 1. Drive Motor
// 2. Turning Motor
// 3. Encoder

class SwerveModule{
    // Defining the variables
    // 1. Drive Motor
    private Talon driveMotor;
    private Talon SteeringMotor;
    private SwerveModuleState currentState;

    // Constructor
    public SwerveModule(
        int driveMotorPort,
        int SteeringMotorPort
    ) {
        System.out.println("SwerveSubsystem constructor");
        driveMotor = new Talon(driveMotorPort);
        SteeringMotor = new Talon(SteeringMotorPort);
        currentState = new SwerveModuleState();
    }

    public SwerveModuleState getState() {
        return currentState;
    }
}

public class SwerveSubsystem extends SubsystemBase {
    
    SwerveModule frontLeftModule = new SwerveModule(0,1);
    SwerveModule frontRightModule = new SwerveModule(2,3);
    SwerveModule backLeftModule = new SwerveModule(4,5);
    SwerveModule backRightModule = new SwerveModule(6,7);
    

    // Constructor
    public SwerveSubsystem() {
        System.out.println("SwerveSubsystem constructor");
    }

    @Override
    public void periodic(){


        // FL, FR ,BL ,BR
        double loggingState[] = {
            frontLeftModule.getState().angle.getDegrees(),
            frontLeftModule.getState().speedMetersPerSecond,
            frontRightModule.getState().angle.getDegrees(),
            frontRightModule.getState().speedMetersPerSecond,
            backLeftModule.getState().angle.getDegrees(),
            backLeftModule.getState().speedMetersPerSecond,
            backRightModule.getState().angle.getDegrees(),
            backRightModule.getState().speedMetersPerSecond
        };

        // Sending data to the SmartDashboard
        SmartDashboard.putNumberArray("SwerveModuleStates", loggingState);
    }




    //
}
