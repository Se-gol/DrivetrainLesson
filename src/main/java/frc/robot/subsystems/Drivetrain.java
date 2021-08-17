package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class Drivetrain extends SubsystemBase {
    private TalonFX frMotor = new TalonFX(Ports.Drivetrain.FR_PORT);
    private TalonFX rrMotor = new TalonFX(Ports.Drivetrain.RR_PORT);
    private TalonFX flMotor = new TalonFX(Ports.Drivetrain.FL_PORT);
    private TalonFX rlMotor = new TalonFX(Ports.Drivetrain.RL_PORT);

    public Drivetrain() {

    }
}
