package frc.robot.subsystems.indexer;

import org.littletonrobotics.junction.AutoLog;

public interface IndexerIO {
  // Do not touch this!
  @AutoLog
  public static class IndexerIOInputs {}

  // TODO: Add your default methods here:
  public default void exampleMethod() {}

  public default void setVoltage(double voltage) {}

  // Do not touch this either!
  public default void updateInputs(IndexerIOInputs inputs) {}
}
