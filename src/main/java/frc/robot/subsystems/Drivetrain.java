package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Drivetrain extends SubsystemBase {
    private final UnitModel unitModel = new UnitModel(Constants.Drivetrain.TICKS_PER_METER);
    private TalonFX frMotor = new TalonFX(Ports.Drivetrain.FR_MOTOR);
    private TalonFX flMotor = new TalonFX(Ports.Drivetrain.FL_MOTOR);
    private TalonFX rrMotor = new TalonFX(Ports.Drivetrain.RR_MOTOR);
    private TalonFX rlMotor = new TalonFX(Ports.Drivetrain.RL_MOTOR);


    public Drivetrain() {
        rrMotor.follow(frMotor);
        rlMotor.follow(flMotor);
        frMotor.setInverted(Ports.Drivetrain.IS_FR_INVERTED);
        rrMotor.setInverted(Ports.Drivetrain.IS_RR_INVERTED);
        flMotor.setInverted(Ports.Drivetrain.IS_FL_INVERTED);
        rlMotor.setInverted(Ports.Drivetrain.IS_RL_INVERTED);

        frMotor.config_kP(0, 0);
        frMotor.config_kI(0, 0);
        frMotor.config_kD(0, 0);

        flMotor.config_kP(0, 0);
        flMotor.config_kI(0, 0);
        flMotor.config_kD(0, 0);

        rrMotor.config_kP(0, 0);
        rrMotor.config_kI(0, 0);
        rrMotor.config_kD(0, 0);

        rlMotor.config_kP(0, 0);
        rlMotor.config_kI(0, 0);
        rlMotor.config_kD(0, 0);
    }

    /**
     * set right & left power.
     *
     * @param power - a values of joystick movement between 1 to -1
     */
    public void setRightPower(double power) {
        frMotor.set(ControlMode.PercentOutput, power);
    }

    public void setLeftPower(double power) {
        flMotor.set(ControlMode.PercentOutput, power);
    }

    /**
     * get velocity of right&left
     *
     * @return- ticks per 100ms
     */
    public double getRightVelocity() {
        double ticks100ms = frMotor.getSelectedSensorVelocity();
        return unitModel.toVelocity(ticks100ms);  // [m/s]
    }

    /**
     * set velocity of right&left
     *
     * @param velocity- delta distance: time   in m/s
     */

    public void setRightVelocity(double velocity) {
        frMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }

    public double getLeftVelocity() {
        return unitModel.toVelocity(flMotor.getSelectedSensorVelocity());
    }

    public void setLeftVelocity(double velocity) {
        rlMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }


}






