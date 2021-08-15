package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private TalonFX frMotor = new TalonFX(0);
    private TalonFX mrMotor = new TalonFX(0);
    private TalonFX rrMotor = new TalonFX(0);
    private TalonFX flMotor = new TalonFX(0);
    private TalonFX mlMotor = new TalonFX(0);
    private TalonFX rlMotor = new TalonFX(0);

    public Drivetrain() {

    }
}
