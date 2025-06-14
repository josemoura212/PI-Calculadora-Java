package domain;

public class Multiplication implements CalculatorOperation {
  @Override
  public double execute(double a, double b) {
    return a * b;
  }

  @Override
  public String getSymbol() {
    return "×";
  }
}
