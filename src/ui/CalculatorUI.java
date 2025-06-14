package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    display.setFont(new Font("SansSerif", Font.BOLD, 28));
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
      btn.setFont(new Font("SansSerif", Font.BOLD, 22));
      btn.addActionListener(new ButtonClickListener());
      panel.add(btn);
    }
    add(panel, BorderLayout.CENTER);

    // Suporte ao teclado
    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        handleKey(e);
      }
    });
    setFocusable(true);
    requestFocusInWindow();
    display.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        handleKey(e);
      }
    });
    // Garante foco ao clicar em qualquer lugar
    addWindowFocusListener(new java.awt.event.WindowAdapter() {
      public void windowGainedFocus(java.awt.event.WindowEvent e) {
        requestFocusInWindow();
      }
    });
    panel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent e) {
        requestFocusInWindow();
      }
    });
    display.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent e) {
        requestFocusInWindow();
      }
    });
  }

  private void handleKey(KeyEvent e) {
    char c = e.getKeyChar();
    switch (e.getKeyCode()) {
      case KeyEvent.VK_0:
      case KeyEvent.VK_NUMPAD0:
      case KeyEvent.VK_1:
      case KeyEvent.VK_NUMPAD1:
      case KeyEvent.VK_2:
      case KeyEvent.VK_NUMPAD2:
      case KeyEvent.VK_3:
      case KeyEvent.VK_NUMPAD3:
      case KeyEvent.VK_4:
      case KeyEvent.VK_NUMPAD4:
      case KeyEvent.VK_5:
      case KeyEvent.VK_NUMPAD5:
      case KeyEvent.VK_6:
      case KeyEvent.VK_NUMPAD6:
      case KeyEvent.VK_7:
      case KeyEvent.VK_NUMPAD7:
      case KeyEvent.VK_8:
      case KeyEvent.VK_NUMPAD8:
      case KeyEvent.VK_9:
      case KeyEvent.VK_NUMPAD9:
        appendToCurrent(String.valueOf(c));
        break;
      case KeyEvent.VK_ADD:
      case KeyEvent.VK_PLUS:
        pressOperator("+");
        break;
      case KeyEvent.VK_SUBTRACT:
      case KeyEvent.VK_MINUS:
        pressOperator("-");
        break;
      case KeyEvent.VK_MULTIPLY:
        pressOperator("×");
        break;
      case KeyEvent.VK_DIVIDE:
      case KeyEvent.VK_SLASH:
        pressOperator("/");
        break;
      case KeyEvent.VK_ENTER:
      case KeyEvent.VK_EQUALS:
        pressEquals();
        break;
      case KeyEvent.VK_BACK_SPACE:
        pressBackspace();
        break;
      case KeyEvent.VK_ESCAPE:
        pressClear();
        break;
      case KeyEvent.VK_PERIOD:
      case KeyEvent.VK_DECIMAL:
        appendToCurrent(".");
        break;
      case KeyEvent.VK_H:
        showHistory();
        break;
    }
    // Suporte para % também pelo teclado
    if (c == '%')
      pressOperator("%");
  }

  private void appendToCurrent(String s) {
    if (resetDisplay) {
      current = "";
      resetDisplay = false;
    }
    current += s;
    updateDisplay();
  }

  private void pressOperator(String op) {
    if (!current.isEmpty()) {
      firstOperand = Double.parseDouble(current);
      operator = op;
      resetDisplay = true;
      updateDisplay();
    }
  }

  private void pressEquals() {
    if (!operator.isEmpty() && !current.isEmpty()) {
      double secondOperand = Double.parseDouble(current);
      try {
        double result = calculator.calculate(operator, firstOperand, secondOperand);
        String entry = firstOperand + " " + operator + " " + secondOperand + " = " + result;
        historyManager.add(entry);
        current = String.valueOf(result);
        operator = "";
        resetDisplay = true;
        updateDisplay();
      } catch (Exception ex) {
        display.setText("Erro");
        current = "";
        operator = "";
        resetDisplay = true;
      }
    }
  }

  private void pressBackspace() {
    if (!current.isEmpty()) {
      current = current.substring(0, current.length() - 1);
      updateDisplay();
    }
  }

  private void pressClear() {
    current = "";
    operator = "";
    firstOperand = 0;
    resetDisplay = false;
    updateDisplay();
  }

  private void updateDisplay() {
    if (!operator.isEmpty() && resetDisplay) {
      display.setText(firstOperand + " " + operator);
    } else {
      display.setText(current);
    }
  }

  private class ButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String cmd = ((JButton) e.getSource()).getText();
      switch (cmd) {
        case "C":
          pressClear();
          break;
        case "⌫":
          pressBackspace();
          break;
        case "+":
        case "-":
        case "×":
        case "/":
        case "%":
          pressOperator(cmd);
          break;
        case "=":
          pressEquals();
          break;
        case "Hist":
          showHistory();
          requestFocusInWindow(); // Garante foco após fechar histórico
          break;
        default:
          appendToCurrent(cmd);
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
    requestFocusInWindow(); // Garante foco após fechar histórico
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new CalculatorUI().setVisible(true));
  }
}
