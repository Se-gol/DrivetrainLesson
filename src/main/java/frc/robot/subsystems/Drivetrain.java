package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Pot;

public class Drivetrain extends SubsystemBase {
    private TalonFX frMotor = new TalonFX(Pot.Drivetrain.Pot1);
    private TalonFX rrMotor = new TalonFX(Pot.Drivetrain.Pot2);
    private TalonFX flMotor = new TalonFX(Pot.Drivetrain.Pot3);
    private TalonFX rlMotor = new TalonFX(Pot.Drivetrain.Pot4);

    public Drivetrain() {
        frMotor.setInverted();
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
