package frc.robot.subsystems.indexer;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel;


public class IndexerIOReal implements IndexerIO {
  // TODO: Add your motors here!
  private SparkMax motor = new SparkMax(IndexerConstants.CAN_ID, SparkLowLevel.MotorType.kBrushless);
  private double currentVoltage = 0;

  // Tip: use Rev Robotics' SparkMax motor controllers

  // Motor config
  private final SparkMaxConfig config = new SparkMaxConfig();

  // Constructor
  public IndexerIOReal() {


    // Sets a limit on current going to the motor so that the motor doesn't fry itself
    config.smartCurrentLimit(IndexerConstants.CURRENT_LIMIT);
    config.idleMode(IdleMode.kCoast);
    config.inverted(false);
    motor.configure(config, ResetMode.kResetSafeParameters,
    PersistMode.kPersistParameters);


    // TODO: Set the rest of your motor configs and apply them!
  }

  // TODO: Add a setVoltage method here
  @Override
  public void setVoltage(double voltage){
    motor.setVoltage(voltage);
    currentVoltage = voltage;
  }

  // Do not touch!
  @Override
  public void updateInputs(IndexerIOInputs inputs) {}
}
