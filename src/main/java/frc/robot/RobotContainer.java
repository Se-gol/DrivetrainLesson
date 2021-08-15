// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DrivetrainDefaultCommand;
import frc.robot.commands.DrivetrainSolvedDefaultCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.DrivetrainSolved;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    private final Drivetrain drivetrain = new Drivetrain();
    public static final XboxController xboxController = new XboxController(0);

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
    }

    private void configureDefaultCommand() {
        drivetrain.setDefaultCommand(new DrivetrainDefaultCommand(drivetrain));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
