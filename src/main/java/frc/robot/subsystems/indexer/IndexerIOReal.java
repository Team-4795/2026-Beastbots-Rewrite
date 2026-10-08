package frc.robot.subsystems.indexer;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class IndexerIOReal implements IndexerIO {
  // One indexer motor
  private SparkMax motor =
      new SparkMax(IndexerConstants.CAN_ID, SparkLowLevel.MotorType.kBrushless);
  private double voltage;

  // Motor config
  private final SparkMaxConfig config = new SparkMaxConfig();

  // Constructor
  public IndexerIOReal() {
    // Sets a limit on current going to the motor so that the motor doesn't fry itself
    config.smartCurrentLimit(IndexerConstants.CURRENT_LIMIT);

    // Allow motor to coast while idle, we have no need for the motor to maintain position when not
    // running
    config.idleMode(IdleMode.kCoast);

    // Multiplies the encoder output (motor RPM) by a factor to convert to mechanism RPS
    config.encoder.velocityConversionFactor(IndexerConstants.GEARING / 60);

    // Apply the config
    motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  // Sets the voltage of the motor
  @Override
  public void setVoltage(double volts) {
    motor.setVoltage(volts);
    voltage = volts;
  }

  // Do not touch!
  // Periodically logs the stuff we put in here
  @Override
  public void updateInputs(IndexerIOInputs inputs) {
    inputs.voltage = voltage;
    inputs.velocity = motor.getEncoder().getVelocity();
    inputs.current = motor.getOutputCurrent();
  }
}
