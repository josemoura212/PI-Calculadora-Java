package domain;

public class Addition implements CalculatorOperation {
  @Override
  public double execute(double a, double b) {
    return a + b;
  }

  @Override
  public String getSymbol() {
    return "+";
  }
}
