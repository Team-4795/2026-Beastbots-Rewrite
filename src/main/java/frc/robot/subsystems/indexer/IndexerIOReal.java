package frc.robot.subsystems.indexer;

import com.ctre.phoenix6.sim.TalonFXSimState.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

public class IndexerIOReal implements IndexerIO {
  // TODO: Add your motors here!
  // Tip: use Rev Robotics' SparkMax motor controllers

  private final SparkMax motor = new SparkMax(0, com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);

  // Motor config
  private final SparkMaxConfig config = new SparkMaxConfig();

  // Constructor
  public IndexerIOReal() {
    // Sets a limit on current going to the motor so that the motor doesn't fry itself
    //config.smartCurrentLimit(IndexerConstants.CURRENT_LIMIT);

    // TODO: Set the rest of your motor configs and apply them!



    
  }

  // TODO: Add a setVoltage method here

  @Override
  public void setVoltage(double volts) {
    motor.setVoltage(volts);
  }



  // Do not touch!
  @Override
  public void updateInputs(IndexerIOInputs inputs) {}
}
