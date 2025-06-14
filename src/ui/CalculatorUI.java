package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import domain.Calculator;
import history.HistoryManager;

public class CalculatorUI extends JFrame {
  private final JTextField display = new JTextField();
  private final Calculator calculator = new Calculator();
  private final HistoryManager historyManager = new HistoryManager();
  private String current = "";
  private String operator = "";
  private double firstOperand = 0;
  private boolean resetDisplay = false;

  public CalculatorUI() {
    setTitle("Calculadora Java");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(350, 500);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    display.setEditable(false);
    display.setFont(new Font("Arial", Font.BOLD, 28));
    add(display, BorderLayout.NORTH);

    JPanel panel = new JPanel(new GridLayout(6, 4, 5, 5));
    String[] buttons = {
        "7", "8", "9", "/",
        "4", "5", "6", "×",
        "1", "2", "3", "-",
        "0", ".", "%", "+",
        "C", "⌫", "=", "Hist"
    };
    for (String text : buttons) {
      JButton btn = new JButton(text);
      btn.setFont(new Font("Arial", Font.BOLD, 22));
      btn.addActionListener(new ButtonClickListener());
      panel.add(btn);
    }
    add(panel, BorderLayout.CENTER);
  }

  private class ButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String cmd = ((JButton) e.getSource()).getText();
      switch (cmd) {
        case "C":
          current = "";
          operator = "";
          firstOperand = 0;
          display.setText("");
          break;
        case "⌫":
          if (!current.isEmpty()) {
            current = current.substring(0, current.length() - 1);
            display.setText(current);
          }
          break;
        case "+":
        case "-":
        case "×":
        case "/":
        case "%":
          if (!current.isEmpty()) {
            firstOperand = Double.parseDouble(current);
            operator = cmd;
            resetDisplay = true;
          }
          break;
        case "=":
          if (!operator.isEmpty() && !current.isEmpty()) {
            double secondOperand = Double.parseDouble(current);
            try {
              double result = calculator.calculate(operator, firstOperand, secondOperand);
              String entry = firstOperand + " " + operator + " " + secondOperand + " = " + result;
              historyManager.add(entry);
              display.setText(String.valueOf(result));
              current = String.valueOf(result);
            } catch (Exception ex) {
              display.setText("Erro");
              current = "";
            }
            operator = "";
            resetDisplay = true;
          }
          break;
        case "Hist":
          showHistory();
          break;
        default:
          if (resetDisplay) {
            current = "";
            resetDisplay = false;
          }
          current += cmd;
          display.setText(current);
      }
    }
  }

  private void showHistory() {
    java.util.List<String> hist = historyManager.getHistory();
    StringBuilder sb = new StringBuilder();
    for (String entry : hist) {
      sb.append(entry).append("\n");
    }
    JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "Sem histórico", "Histórico",
        JOptionPane.INFORMATION_MESSAGE);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new CalculatorUI().setVisible(true));
  }
}
