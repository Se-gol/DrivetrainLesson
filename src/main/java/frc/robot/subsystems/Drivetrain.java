package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class Drivetrain extends SubsystemBase {
    private TalonFX frMotor = new TalonFX(Ports.Drivetrain.FR_MOTOR);
    private TalonFX flMotor = new TalonFX(Ports.Drivetrain.FL_MOTOR);
    private TalonFX rrMotor = new TalonFX(Ports.Drivetrain.RR_MOTOR);
    private TalonFX rlMotor = new TalonFX(Ports.Drivetrain.RL_MOTOR);
    private final UnitModel unitModel = new UnitModel(1);

    public Drivetrain() {
        rrMotor.follow(frMotor);
        rlMotor.follow(flMotor);
        frMotor.setInverted(Ports.Drivetrain.IS_FR_INVERTED);
        rrMotor.setInverted(Ports.Drivetrain.IS_RR_INVERTED);
        flMotor.setInverted(Ports.Drivetrain.IS_FL_INVERTED);
        rlMotor.setInverted(Ports.Drivetrain.IS_RL_INVERTED);

    }

    public void setRightPower(double power) {
        frMotor.set(ControlMode.PercentOutput, power);
    }

    public void setLeftPower(double power) {
        flMotor.set(ControlMode.PercentOutput, power);
    }

    public void setRightVelocity(double velocity) {
        frMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }

    public void setLeftVelocity(double velocity) {
        rlMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }

    public double getRightVelocity() {
        double ticks100ms = frMotor.getSelectedSensorVelocity();
        return unitModel.toVelocity(ticks100ms);  // [m/s]
    }

    public double getLeftVelocity() {
        return unitModel.toVelocity(flMotor.getSelectedSensorVelocity());
    }


}






