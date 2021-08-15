package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private TalonFX frMotor = new TalonFX(0);
    private TalonFX rrMotor = new TalonFX(0);
    private TalonFX flMotor = new TalonFX(0);
    private TalonFX rlMotor = new TalonFX(0);

    public Drivetrain() {

    }

    public void setPowerR(double valueMotorR) {
        frMotor.set(ControlMode.PercentOutput, valueMotorR);
        rrMotor.set(ControlMode.PercentOutput, valueMotorR);
    }

    public void setPowerL(double valueMotorL) {
        flMotor.set(ControlMode.PercentOutput, valueMotorL);
        rlMotor.set(ControlMode.PercentOutput, valueMotorL);
    }
}
