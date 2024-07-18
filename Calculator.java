import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            addBtn, subtractBtn, multiplyBtn, divideBtn, decimalBtn, clearBtn, equalBton;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {

        frame = new JFrame("Calculator");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 400);

        textField = new JTextField();
        textField.setBounds(50, 50, 200, 50);
        textField.setFont(textField.getFont().deriveFont(20f));
        frame.add(textField);

        btn1 = new JButton("1");
        bt1.setBounds(50, 150, 50, 50);
        btn1.addActionListener(this);
        frame.add(btn1);

        btn2 = new JButton("2");
        btn2.setBounds(110, 150, 50, 50);
        btn2.addActionListener(this);
        frame.add(btn2);

        btn3 = new JButton("3");
        btn3.setBounds(170, 150, 50, 50);
        btn3.addActionListener(this);
        frame.add(btn3);

        btn4 = new JButton("4");
        btn4.setBounds(50, 210, 50, 50);
        btn4.addActionListener(this);
        frame.add(btn4);

        btn5 = new JButton("5");
        btn5.setBounds(110, 210, 50, 50);
        btn5.addActionListener(this);
        frame.add(btn5);

        btn6 = new JButton("6");
        btn6.setBounds(170, 210, 50, 50);
        btn6.addActionListener(this);
        frame.add(btn6);

        btn7 = new JButton("7");
        btn7.setBounds(50, 270, 50, 50);
        btn7.addActionListener(this);
        frame.add(btn7);

        btn8 = new JButton("8");
        btn8.setBounds(110, 270, 50, 50);
        btn8.addActionListener(this);
        frame.add(btn8);

        btn9 = new JButton("9");
        btn9.setBounds(170, 270, 50, 50);
        btn9.addActionListener(this);
        frame.add(btn9);

        btn0 = new JButton("0");
        btn0.setBounds(50, 330, 50, 50);
        btn0.addActionListener(this);
        frame.add(btn0);

        addBtn = new JButton("+");
        addBtn.setBounds(230, 150, 50, 50);
        addBtn.addActionListener(this);
        frame.add(addBtn);

        subtractBtn = new JButton("-");
        subtractBtn.setBounds(230, 210, 50, 50);
        subtractBtn.addActionListener(this);
        frame.add(subtractBtn);

        multiplyBtn = new JButton("*");
        multiplyBtn.setBounds(230, 270, 50, 50);
        multiplyBtn.addActionListener(this);
        frame.add(multiplyBtn);

        divideBtn = new JButton("/");
        divideBtn.setBounds(230, 330, 50, 50);
        divideBtn.addActionListener(this);
        frame.add(divideBtn);

        decimalBtn = new JButton(".");
        decimalBtn.setBounds(110, 330, 50, 50);
        decimalBtn.addActionListener(this);
        frame.add(decimalBtn);

        clearBtn = new JButton("C");
        clearBtn.setBounds(170, 330, 50, 50);
        clearBtn.addActionListener(this);
        frame.add(clearBtn);

        equalBtn = new JButton("=");
        equalBtn.setBounds(230, 90, 50, 50);
        equalBtn.addActionListener(this);
        frame.add(equalBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        if (Character.isDigit(buttonText.charAt(0))) {
            textField.setText(textField.getText() + buttonText);
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
            num1 = Double.parseDouble(textField.getText());
            operator = buttonText.charAt(0);
            textField.setText("");
        } else if (buttonText.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        textField.setText("Error: Division by zero");
                    } else {
                        result = num1 / num2;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
        } else if (buttonText.equals("C")) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

