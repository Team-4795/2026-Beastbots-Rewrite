package frc.robot.subsystems.indexer;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Indexer extends SubsystemBase {
  private static Indexer instance;
  private static IndexerIO indexerIO;
  private IndexerIOInputsAutoLogged inputs = new IndexerIOInputsAutoLogged();

  public static Indexer getInstance() {
    return instance;
  }

  public static Indexer initialize(IndexerIO io) {
    if (instance == null) {
      instance = new Indexer(io);
    }
    return instance;
  }

  private Indexer(IndexerIO io) {
    indexerIO = io;
  }

  @Override
  public void periodic() {
    indexerIO.updateInputs(inputs);
    Logger.processInputs("Indexer/Indexer", inputs);
  }

  // TODO: Add methods here:
  public void exampleMethod() {
    indexerIO.exampleMethod();
  }
  public void setVoltage (double voltage){
    indexerIO.setVoltage(voltage);
  }
}