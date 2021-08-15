package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSolved extends SubsystemBase {
    private TalonFX frMotor = new TalonFX(0);
    private TalonFX mrMotor = new TalonFX(0);
    private TalonFX rrMotor = new TalonFX(0);
    private TalonFX flMotor = new TalonFX(0);
    private TalonFX mlMotor = new TalonFX(0);
    private TalonFX rlMotor = new TalonFX(0);

    public DrivetrainSolved() {
        // Extra
        frMotor.config_kP(0, 0);
        mrMotor.config_kP(0, 0);
        rrMotor.config_kP(0, 0);
        flMotor.config_kP(0, 0);
        mlMotor.config_kP(0, 0);
        rlMotor.config_kP(0, 0);
    }

    public void setRightPower(double power) {
        frMotor.set(ControlMode.PercentOutput, power);
        mrMotor.set(ControlMode.PercentOutput, power);
        rrMotor.set(ControlMode.PercentOutput, power);
    }

    public void setLeftPower(double power) {
        flMotor.set(ControlMode.PercentOutput, power);
        mlMotor.set(ControlMode.PercentOutput, power);
        rlMotor.set(ControlMode.PercentOutput, power);
    }

    // Extra
    public void setRightVelocity(double velocity) {
        frMotor.set(ControlMode.Velocity, velocity);
        mrMotor.set(ControlMode.Velocity, velocity);
        rrMotor.set(ControlMode.Velocity, velocity);
    }

    public void setLeftVelocity(double velocity) {
        flMotor.set(ControlMode.Velocity, velocity);
        mlMotor.set(ControlMode.Velocity, velocity);
        rlMotor.set(ControlMode.Velocity, velocity);
    }
}
