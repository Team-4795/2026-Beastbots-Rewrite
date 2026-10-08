package frc.robot.subsystems.shooter;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class ShooterIOReal implements ShooterIO {
  // Two shooter motors, opposed
  private final SparkMax leftMotor =
      new SparkMax(ShooterConstants.CAN_ID_LEFT, MotorType.kBrushless);
  private final SparkMax rightMotor =
      new SparkMax(ShooterConstants.CAN_ID_RIGHT, MotorType.kBrushless);

  // Motor config
  private final SparkMaxConfig config = new SparkMaxConfig();

  // Mostly for logging
  private double voltage;
  private double goalRPS;

  // Constructor
  public ShooterIOReal() {
    configure(); // Initially configure motors
  }

  // Sets the voltage of the left motor, the other motor will follow (because of config)
  @Override
  public void setVoltage(double volts) {
    leftMotor.setVoltage(volts);
    voltage = volts;
  }

  @Override
  public void configure() { // We will call this method when we need to update PID values
    // Sets a limit on current going to the motor so that the motor doesn't fry itself
    config.smartCurrentLimit(ShooterConstants.CURRENT_LIMIT);

    // Allow motor to coast while idle, we have no need for the motor to maintain position when off
    config.idleMode(IdleMode.kCoast);

    // Stop follower because we reuse the config
    config.disableFollowerMode();

    // idk if this is strictly necessary, but just in case
    config.inverted(false);

    // Multiplies the encoder output (motor RPM) by a factor to convert to mechanism RPS
    config.encoder.velocityConversionFactor(ShooterConstants.GEARING / 60);

    // TODO: PID things will go here:

    // apply config to left motor
    leftMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    // Sets it so that the right motor does everything the left motor does
    // and inverts it because the two motors are facing opposite directions
    config.follow(ShooterConstants.CAN_ID_LEFT, true);

    // apply config to right motor
    rightMotor.configure(
        config,
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters); // apply config to right motor
  }

  // Do not touch!
  // Periodically logs the stuff we put in here
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
