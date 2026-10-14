package frc.robot.util;

import com.pathplanner.lib.auto.NamedCommands;
import frc.robot.commands.AutoCommands;

public class NamedCommandManager {
  public static void registerNamedCommands() {
    NamedCommands.registerCommand("Run Shooter", AutoCommands.setGoalShooter(60));
    NamedCommands.registerCommand("Reverse Shooter", AutoCommands.setGoalShooter(-60));
    NamedCommands.registerCommand("Run Indexer", AutoCommands.runIndexer());
    NamedCommands.registerCommand("Reverse Indexer", AutoCommands.reverseIndexer());
    NamedCommands.registerCommand("Outtake", AutoCommands.outtake());
  }
}
