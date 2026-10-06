package frc.robot.subsystems.indexer;

import com.revrobotics.spark.config.SparkMaxConfig;

public class IndexerIOReal implements IndexerIO {
  // TODO: Add your motors here!
  // Tip: use Rev Robotics' SparkMax motor controllers
  private SparkMax motor = 
    new SparkMax(IndexerConstants.motorPort, SparkLowLevel.MotorType.kBrushless);

  private double currentVoltage = 0;

  // Motor config
  private final SparkMaxConfig config = new SparkMaxConfig();

  // Constructor
  public IndexerIOReal() {
    // Sets a limit on current going to the motor so that the motor doesn't fry itself
    config.smartCurrentLimit(IndexerConstants.CURRENT_LIMIT);

    // TODO: Set the rest of your motor configs and apply them!    
  }

  // TODO: Add a setVoltage method here
  @Override
  public default void setVoltage(double voltage){
    motor.setVoltage(voltage);
    currentVoltage = voltage;
  }

  // Do not touch!
  @Override
  public void updateInputs(IndexerIOInputs inputs) {}
}
