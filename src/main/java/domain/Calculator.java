package domain;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
  private final Map<String, CalculatorOperation> operations = new HashMap<>();

  public Calculator() {
    addOperation(new Addition());
    addOperation(new Subtraction());
    addOperation(new Multiplication());
    addOperation(new Division());
    addOperation(new Percentage());
  }

  public void addOperation(CalculatorOperation op) {
    operations.put(op.getSymbol(), op);
  }

  public double calculate(String operator, double a, double b) {
    CalculatorOperation op = operations.get(operator);
    if (op == null)
      throw new IllegalArgumentException("Operação inválida");
    return op.execute(a, b);
  }
}
