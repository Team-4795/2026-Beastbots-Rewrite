package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Shooter extends SubsystemBase {
  private static Shooter instance;
  private static ShooterIO shooterIO;
  private ShooterIOInputsAutoLogged inputs = new ShooterIOInputsAutoLogged();

  public static Shooter getInstance() {
    return instance;
  }

  public static Shooter initialize(ShooterIO io) {
    if (instance == null) {
      instance = new Shooter(io);
    }
    return instance;
  }

  private Shooter(ShooterIO io) {
    shooterIO = io;
  }

  @Override
  public void periodic() {
    shooterIO.updateInputs(inputs);
    Logger.processInputs("Shooter/Shooter", inputs);
  }

  public void setVoltage(double volts) {
    shooterIO.setVoltage(volts);
  }
}
