package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.ElectricHole;
import frc.robot.UnitModel;

public class Drivetrain extends SubsystemBase {
    private TalonFX frMotor = new TalonFX(ElectricHole.Drivetrain.FR);
    private TalonFX rrMotor = new TalonFX(ElectricHole.Drivetrain.RR);
    private TalonFX flMotor = new TalonFX(ElectricHole.Drivetrain.FL);
    private TalonFX rlMotor = new TalonFX(ElectricHole.Drivetrain.RL);
    private UnitModel unitModel = new UnitModel(0);

    public Drivetrain() {
        rrMotor.setInverted(ElectricHole.Drivetrain.REVERSER_RR);
        frMotor.setInverted(ElectricHole.Drivetrain.REVERSER_FR);
        flMotor.setInverted(ElectricHole.Drivetrain.REVERSER_FL);
        rlMotor.setInverted(ElectricHole.Drivetrain.REVERSER_RL);

        rrMotor.setSensorPhase(ElectricHole.Drivetrain.REVERSER_SR1);
        frMotor.setSensorPhase(ElectricHole.Drivetrain.REVERSER_SR2);
        flMotor.setSensorPhase(ElectricHole.Drivetrain.REVERSER_SF1);
        rlMotor.setSensorPhase(ElectricHole.Drivetrain.REVERSER_SF2);

        frMotor.config_kP(0, Constants.Drivetrain.KP);
        frMotor.config_kI(0, Constants.Drivetrain.KI);
        frMotor.config_kD(0, Constants.Drivetrain.KD);

        rrMotor.config_kP(0, Constants.Drivetrain.KP);
        rrMotor.config_kI(0, Constants.Drivetrain.KI);
        rrMotor.config_kD(0, Constants.Drivetrain.KD);

        flMotor.config_kP(0, Constants.Drivetrain.KP);
        flMotor.config_kI(0, Constants.Drivetrain.KI);
        flMotor.config_kD(0, Constants.Drivetrain.KD);

        rlMotor.config_kP(0, Constants.Drivetrain.KP);
        rlMotor.config_kI(0, Constants.Drivetrain.KI);
        rlMotor.config_kD(0, Constants.Drivetrain.KD);

        rlMotor.follow(flMotor);
        rrMotor.follow(frMotor);
    }

    /**
     *
     * @param valueMotorR
     */
    public void setVelR(double valueMotorR) {
        frMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(valueMotorR));
    }

    public void setPowerR(double valueMotorR) {
        frMotor.set(ControlMode.PercentOutput, valueMotorR);
    }

    public void setVelL(double valueMotorL) {
        frMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(valueMotorL));
    }

    public void setPowerL(double valueMotorL) {
        flMotor.set(ControlMode.PercentOutput, valueMotorL);
    }

    public double getValuR() {
        return unitModel.toVelocity(frMotor.getSelectedSensorVelocity());
    }

    public double getValuL() {
        return unitModel.toVelocity(frMotor.getSelectedSensorVelocity());
    }
}
