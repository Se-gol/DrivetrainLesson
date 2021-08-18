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

        frMotor.config_kP((int) Constants.Drivetrain.FR_MOTORS_SLOTDX_P, Constants.Drivetrain.FR_MOTORS_VALUE_P);
        frMotor.config_kI((int) Constants.Drivetrain.FR_MOTORS_SLOTDX_I, Constants.Drivetrain.FR_MOTORS_VALUE_I);
        frMotor.config_kD((int) Constants.Drivetrain.FR_MOTORS_SLOTDX_D, Constants.Drivetrain.FR_MOTORS_VALUE_D);

        flMotor.config_kP((int) Constants.Drivetrain.FL_MOTORS_SLOTDX_P, Constants.Drivetrain.FL_MOTORS_VALUE_P);
        flMotor.config_kI((int) Constants.Drivetrain.FL_MOTORS_SLOTDX_I, Constants.Drivetrain.FL_MOTORS_VALUE_I);
        flMotor.config_kD((int) Constants.Drivetrain.FL_MOTORS_SLOTDX_D, Constants.Drivetrain.FL_MOTORS_VALUE_D);

        rrMotor.config_kP((int) Constants.Drivetrain.RR_MOTORS_SLOTDX_P, Constants.Drivetrain.RR_MOTORS_VALUE_P);
        rrMotor.config_kI((int) Constants.Drivetrain.RR_MOTORS_SLOTDX_I, Constants.Drivetrain.RR_MOTORS_VALUE_I);
        rrMotor.config_kD((int) Constants.Drivetrain.RR_MOTORS_SLOTDX_D, Constants.Drivetrain.RR_MOTORS_VALUE_D);

        rlMotor.config_kP((int) Constants.Drivetrain.RL_MOTORS_SLOTDX_P, Constants.Drivetrain.RL_MOTORS_VALUE_P);
        rlMotor.config_kI((int) Constants.Drivetrain.RL_MOTORS_SLOTDX_I, Constants.Drivetrain.RL_MOTORS_VALUE_I);
        rlMotor.config_kD((int) Constants.Drivetrain.RL_MOTORS_SLOTDX_D, Constants.Drivetrain.RL_MOTORS_VALUE_D);

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
     * @return- the velocity of the right side of the drivetrain. [m/s]
     */
    public double getRightVelocity() {
        double meterPerSecond = frMotor.getSelectedSensorVelocity();
        return unitModel.toVelocity(meterPerSecond);  // [m/s]
    }

    public double getLeftVelocity() {
        return unitModel.toVelocity(flMotor.getSelectedSensorVelocity());
    }


    /**
     * set velocity of right&left
     *
     * @param velocity- delta distance: time   in m/s
     */

    public void setRightVelocity(double velocity) {
        frMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }

    public void setLeftVelocity(double velocity) {
        rlMotor.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }


}






