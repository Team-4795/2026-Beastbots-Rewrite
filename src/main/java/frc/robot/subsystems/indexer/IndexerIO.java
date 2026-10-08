package frc.robot.subsystems.indexer;

import org.littletonrobotics.junction.AutoLog;

public interface IndexerIO {
  // Do not touch this! Automatically logs stuff put in here
  @AutoLog
  public static class IndexerIOInputs {
    public double voltage;
    public double velocity;
    public double current;
  }

  public default void setVoltage(double v) {}

  // Do not touch this either! Called every 20 ms for logging.
  public default void updateInputs(IndexerIOInputs inputs) {}
}
