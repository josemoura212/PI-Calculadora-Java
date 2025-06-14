package domain;

public interface CalculatorOperation {
  double execute(double a, double b);

  String getSymbol();
}
