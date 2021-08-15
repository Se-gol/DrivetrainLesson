package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSolved;

public class DrivetrainSolvedDefaultCommand extends CommandBase {
    private final DrivetrainSolved drivetrainSolved;
    private final XboxController xboxController = RobotContainer.xboxController;

    private double rightY;
    private double leftY;


    public DrivetrainSolvedDefaultCommand(DrivetrainSolved drivetrainSolved) {
        this.drivetrainSolved = drivetrainSolved;
        addRequirements(drivetrainSolved);
    }

    @Override
    public void execute() {
        rightY = xboxController.getY(GenericHID.Hand.kRight);
        rightY = xboxController.getY(GenericHID.Hand.kLeft);

        if (Math.abs(rightY) <= 0.05) rightY = 0;
        if (Math.abs(leftY) <= 0.05) leftY = 0;

        drivetrainSolved.setRightPower(rightY);
        drivetrainSolved.setLeftPower(leftY);

        // Extra
        if (rightY != 0 || leftY != 0)
            xboxController.setRumble(GenericHID.RumbleType.kLeftRumble, (Math.abs(rightY) + Math.abs(leftY)) / 2);
    }
}
