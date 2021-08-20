package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.UnitModel;

import static frc.robot.Constants.Drivetrain.*;
import static frc.robot.Constants.*;
import static frc.robot.Ports.Drivetrain.*;

public class Drivetrain extends SubsystemBase {
    private int slotIdx = 0;
    private TalonFX frMotor = new TalonFX(FR_PORT);
    private TalonFX rrMotor = new TalonFX(RR_PORT);
    private TalonFX flMotor = new TalonFX(FL_PORT);
    private TalonFX rlMotor = new TalonFX(RL_PORT);

    private UnitModel unitMan = new UnitModel(TICKS_PER_METER);

    public Drivetrain() {
        rrMotor.follow(frMotor);
        rlMotor.follow(flMotor);

        frMotor.setInverted(FR_INVERTED);
        rrMotor.setInverted(RR_INVERTED);
        flMotor.setInverted(FL_INVERTED);
        rlMotor.setInverted(RL_INVERTED);

        frMotor.setSensorPhase(FR_SENSOR_INVERTED);
        rrMotor.setSensorPhase(RR_SENSOR_INVERTED);
        flMotor.setSensorPhase(FL_SENSOR_INVERTED);
        rlMotor.setSensorPhase(RL_SENSOR_INVERTED);

        frMotor.config_kP(slotIdx, kP);
        rrMotor.config_kP(slotIdx, kP);
        flMotor.config_kP(slotIdx, kP);
        rlMotor.config_kP(slotIdx, kP);
    }

    public void setPowerRight(double power) {
        frMotor.set(ControlMode.PercentOutput, power);
    }

    public void setPowerLeft(double power) {
        flMotor.set(ControlMode.PercentOutput, power);
    }

    public void setVelocityRight(double velocity){
        frMotor.set(ControlMode.Velocity, unitMan.toTicks100ms(velocity));
    }

    public void setVelocityLeft(double velocity){
        frMotor.set(ControlMode.Velocity, unitMan.toTicks100ms(velocity));
    }

    public double getVelocityRight(){
        return unitMan.toVelocity(frMotor.getSelectedSensorVelocity());
    }

    public double getVelocityLeft(){
        return unitMan.toVelocity(flMotor.getSelectedSensorVelocity());
    }
}
