package frc.robot.subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterIO {
  // Do not touch this!
  @AutoLog
  public static class ShooterIOInputs {}

  // TODO: Add your default methods here:
  public default void SetVoltage(double v)
  {
    
  }

  // Do not touch this either!
  public default void updateInputs(ShooterIOInputs inputs) {}
}
