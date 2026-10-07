package frc.robot.subsystems.shooter;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

public class ShooterIOReal implements ShooterIO {
  // TODO: Add your motors here!
  // Tip: use Rev Robotics' SparkMax motor controllers
  private SparkMax motor1Max = new SparkMax(0, SparkLowLevel.MotorType.kBrushless);
  private SparkMax motor2Max = new SparkMax(0, SparkLowLevel.MotorType.kBrushless);

  @Override
  public void setVoltage(double volts) {
    motor1Max.setVoltage(volts);
    motor2Max.setVoltage(volts);
  }
  ;
  // Motor config
  private final SparkMaxConfig config = new SparkMaxConfig();

  // Constructor
  public ShooterIOReal() {
    // Sets a limit on current going to the motor so that the motor doesn't fry itself
    config.smartCurrentLimit(ShooterConstants.CURRENT_LIMIT);

    // TODO: Set the rest of your motor configs and apply them!

  }

  // TODO: Add a setVoltage method here

  // Do not touch!
  @Override
  public void updateInputs(ShooterIOInputs inputs) {}
}
