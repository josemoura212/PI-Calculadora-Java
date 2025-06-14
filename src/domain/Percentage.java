package domain;

public class Percentage implements CalculatorOperation {
  @Override
  public double execute(double a, double b) {
    return a * (b / 100);
  }

  @Override
  public String getSymbol() {
    return "%";
  }
}
