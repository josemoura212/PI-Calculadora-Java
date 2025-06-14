package domain;

public class Subtraction implements CalculatorOperation {
  @Override
  public double execute(double a, double b) {
    return a - b;
  }

  @Override
  public String getSymbol() {
    return "-";
  }
}
