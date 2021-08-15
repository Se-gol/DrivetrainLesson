package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class DrivetrainDefaultCommand extends CommandBase {
    private final Drivetrain drivetrain;
    private final XboxController xboxController = RobotContainer.xboxController;

    public DrivetrainDefaultCommand(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {

    }
}
