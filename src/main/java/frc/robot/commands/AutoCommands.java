package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.drive.Drive;

public class AutoCommands {
  private static Drive drive = Drive.getInstance();

  // An example command for syntax.
  public Command exampleCommand() {
    return Commands.run(() -> drive.stopWithX());
  }
}
