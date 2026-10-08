package frc.robot.subsystems.shooter;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

public class ShooterIOReal implements ShooterIO {
  // Two shooter motors, opposed
  private final SparkMax leftMotor =
      new SparkMax(ShooterConstants.CAN_ID_LEFT, MotorType.kBrushless);
  private final SparkMax rightMotor =
      new SparkMax(ShooterConstants.CAN_ID_RIGHT, MotorType.kBrushless);

  // Motor config
  private final SparkMaxConfig config = new SparkMaxConfig();

  private double voltage;
  private double goalRPS;

  // Constructor
  public ShooterIOReal() {
    configure();
  }

  // Sets the voltage of the motor, the other motor will follow (because of config)
  @Override
  public void setVoltage(double volts) {
    leftMotor.setVoltage(volts);
    voltage = volts;
  }

  @Override
  public void configure() {
    // Sets a limit on current going to the motor so that the motor doesn't fry itself
    config.disableFollowerMode();
    config.smartCurrentLimit(ShooterConstants.CURRENT_LIMIT);
    config.encoder.velocityConversionFactor(ShooterConstants.GEARING / 60); // convert to rps
    // pid things will go here:

    leftMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    config.follow(ShooterConstants.CAN_ID_LEFT, true);
    rightMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  // Do not touch!
  @Override
  public void updateInputs(ShooterIOInputs inputs) {
    inputs.voltage = voltage;
    inputs.currentLeft = leftMotor.getOutputCurrent();
    inputs.currentRight = rightMotor.getOutputCurrent();
    inputs.velocityLeft = leftMotor.getEncoder().getVelocity();
    inputs.velocityRight = rightMotor.getEncoder().getVelocity();
    inputs.goalRPS = goalRPS;
  }
}
