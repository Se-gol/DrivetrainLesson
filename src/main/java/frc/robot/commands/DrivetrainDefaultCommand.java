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
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        double rightPower = xboxController.getY();
        double leftPower = xboxController.getY(GenericHID.Hand.kLeft);

        double deadRight = deadband(rightPower);
        double deadLeft = deadband(leftPower);

        drivetrain.setLeftPower(deadLeft);
        drivetrain.setRightPower(deadRight);
    }

    private double deadband(double value) {
        if (value > Constants.Drivetrain.JOYSTICK_DEADBAND || value < -Constants.Drivetrain.JOYSTICK_DEADBAND) {
            return value;
        } else {
            return 0;
        }
    }


    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
