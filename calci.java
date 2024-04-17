import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class calci extends Applet implements ActionListener {
    TextField display;
    String operator;
    double num1, num2, result;

    public void init() {
        setLayout(new BorderLayout());

        
        display = new TextField(20);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttonLabels = {"7", "8", "9", "/",
                                 "4", "5", "6", "*",
                                 "1", "2", "3", "-",
                                 "0", ".", "=", "+"};

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            buttonPanel.add(button);
            button.addActionListener(this);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            operator = command;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            if (operator.equals("+")) {
                result = num1 + num2;
            } else if (operator.equals("-")) {
                result = num1 - num2;
            } else if (operator.equals("*")) {
                result = num1 * num2;
            } else if (operator.equals("/")) {
                if (num2 != 0)
                    result = num1 / num2;
                else
                    display.setText("Cannot divide by zero");
            }
            display.setText(String.valueOf(result));
        } else {
            display.setText(display.getText() + command);
        }
    }
}


/* <HTML>
<Applet code=calci.class height=500 width=500>
</Applet>
</HTML>
*/
