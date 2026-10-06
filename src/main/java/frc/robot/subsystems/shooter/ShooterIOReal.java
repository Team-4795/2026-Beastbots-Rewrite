package frc.robot.subsystems.shooter;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

public class ShooterIOReal implements ShooterIO {
  // TODO: Add your motors here!
  // Tip: use Rev Robotics' SparkMax motor controllers
  private SparkMax motor1 = new SparkMax(0,MotorType.kBrushless);
  private SparkMax motor2 = new SparkMax(0, MotorType.kBrushless);
  // Motor config
  private final SparkMaxConfig config = new SparkMaxConfig();

  // Constructor
  public ShooterIOReal() {
    // Sets a limit on current going to the motor so that the motor doesn't fry itself
    config.smartCurrentLimit(ShooterConstants.CURRENT_LIMIT);

    // TODO: Set the rest of your motor configs and apply them!

  }

  // TODO: Add a setVoltage method here
  @Override
  public void setVoltage(double voltage) {  
    motor1.setVoltage(voltage);
    motor2.setVoltage(voltage);
  }

  // Do not touch!
  @Override
  public void updateInputs(ShooterIOInputs inputs) {}
}
