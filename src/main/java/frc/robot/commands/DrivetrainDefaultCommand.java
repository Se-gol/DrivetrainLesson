package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
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

        double ryPosition = xboxController.getY(GenericHID.Hand.kRight);
        double lyPosition = xboxController.getY(GenericHID.Hand.kLeft);
        if (Math.abs(ryPosition) <= Constants.Drivetrain.DEADBAND)
            ryPosition = 0;
        if (Math.abs(lyPosition) <= Constants.Drivetrain.DEADBAND)
            lyPosition = 0;

        drivetrain.setVelocityRight(ryPosition * Constants.Drivetrain.MAX_VELOCITY);
        drivetrain.setVelocityLeft(lyPosition * Constants.Drivetrain.MAX_VELOCITY);

        xboxController.setRumble(GenericHID.RumbleType.kLeftRumble, (Math.abs(ryPosition) + Math.abs(lyPosition)) / 2);

    }
}


