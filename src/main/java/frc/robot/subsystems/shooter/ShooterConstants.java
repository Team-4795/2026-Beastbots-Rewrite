package frc.robot.subsystems.shooter;

public class ShooterConstants {
  public static final int CURRENT_LIMIT = 60;

  public static final double GEARING = 2 / 3; // 3 motor rots to 2 mechanism rots

  public static final int CAN_ID_LEFT = 10;
  public static final int CAN_ID_RIGHT = 12;

  // may need to retune
  public static final double kP = 0.012;
  public static final double kI = 0;
  public static final double kD = 0.03;

  public static final double kS = 0.12;
  public static final double kV = 0.1278;
  public static final double kA = 0;
}
