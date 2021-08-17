package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.UnitModel;

public class DrivetrainSolved extends SubsystemBase {
    private TalonFX frMotor = new TalonFX(Ports.Drivetrain.FR_PORT);
    private TalonFX rrMotor = new TalonFX(Ports.Drivetrain.RR_PORT);
    private TalonFX flMotor = new TalonFX(Ports.Drivetrain.FL_PORT);
    private TalonFX rlMotor = new TalonFX(Ports.Drivetrain.RL_PORT);
    UnitModel unitModel = new UnitModel(Constants.TICKS_PER_METER);

    public DrivetrainSolved() {
        rrMotor.follow(frMotor);
        rlMotor.follow(flMotor);

        frMotor.setInverted(Ports.Drivetrain.FR_INVERTED);
        rrMotor.setInverted(Ports.Drivetrain.RR_INVERTED);
        flMotor.setInverted(Ports.Drivetrain.FL_INVERTED);
        rlMotor.setInverted(Ports.Drivetrain.RL_INVERTED);

        frMotor.setSensorPhase(Ports.Drivetrain.FR_SENSOR_INVERTED);
        rrMotor.setSensorPhase(Ports.Drivetrain.RR_SENSOR_INVERTED);
        flMotor.setSensorPhase(Ports.Drivetrain.FL_SENSOR_INVERTED);
        rlMotor.setSensorPhase(Ports.Drivetrain.RL_SENSOR_INVERTED);

        // Extra
        frMotor.config_kP(0, Constants.Drivetrain.FR_kP);
        rrMotor.config_kP(0, Constants.Drivetrain.RR_kP);
        flMotor.config_kP(0, Constants.Drivetrain.FL_kP);
        rlMotor.config_kP(0, Constants.Drivetrain.RL_kP);
    }

    public void setRightPower(double power) {
        frMotor.set(ControlMode.PercentOutput, power);
    }

    public void setLeftPower(double power) {
        flMotor.set(ControlMode.PercentOutput, power);
    }

    // Extra

    public double getRightVelocity() {
        return unitModel.toVelocity(frMotor.getSelectedSensorVelocity());
    }

    public void setRightVelocity(double velocity) {
        frMotor.set(ControlMode.Velocity, velocity);
    }

    public double getLeftVelocity() {
        return unitModel.toVelocity(flMotor.getSelectedSensorVelocity());
    }

    public void setLeftVelocity(double velocity) {
        flMotor.set(ControlMode.Velocity, velocity);
    }
}
