package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.indexer.Indexer;
import frc.robot.subsystems.shooter.Shooter;

public class AutoCommands {
  private static Drive drive = Drive.getInstance();
  private static Shooter shooter = Shooter.getInstance();
  private static Indexer indexer = Indexer.getInstance();

  public static Command setGoalShooter(double goalRPS) {
    return Commands.run(() -> shooter.setGoal(goalRPS), shooter); // TODO tweak this number
  }

  public static Command runIndexer() {
    return Commands.run(() -> indexer.setVoltage(6), indexer);
  }

  public static Command reverseIndexer() {
    return Commands.run(() -> indexer.setVoltage(-6), indexer);
  }

  public static Command stopIndexer() {
    return Commands.runOnce(() -> indexer.setVoltage(0), indexer);
  }

  public static Command outtake() {
    return Commands.parallel(setGoalShooter(-40), reverseIndexer());
  }
}
