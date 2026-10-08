package frc.robot.subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterIO {
  // Do not touch this!
  @AutoLog
  public static class ShooterIOInputs {
    public double voltage;
    public double currentLeft;
    public double currentRight;
    public double velocityLeft;
    public double velocityRight;
    public double goalRPS;
  }

  public default void setVoltage(double volts) {}

  public default void configure() {}

  // Do not touch this either!
  public default void updateInputs(ShooterIOInputs inputs) {}
}
