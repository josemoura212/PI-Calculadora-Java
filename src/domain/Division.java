package domain;

public class Division implements CalculatorOperation {
  @Override
  public double execute(double a, double b) {
    if (b == 0)
      throw new ArithmeticException("Divisão por zero");
    return a / b;
  }

  @Override
  public String getSymbol() {
    return "/";
  }
}
