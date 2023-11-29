import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JLabel display;
    JButton[] buttons;
    int res; // value stored in calculator
    boolean reset; // used to determine when number buttons should override current displayed text
    String operation;

    Calculator() {
        res = 0;
        reset = false;
        operation = "";

        frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(250,300));
        frame.setResizable(false);

        // result label
        display = new JLabel();
        display.setPreferredSize(new Dimension(200, 30));
        display.setOpaque(true);
        display.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        display.setBackground(Color.lightGray);
        display.setHorizontalAlignment(SwingConstants.RIGHT);

        // grid of buttons
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new GridLayout(5,4));
        buttonContainer.setPreferredSize(new Dimension(200,200));

        // numbers
        buttons = new JButton[19];
        for(int i = 0; i < 10; i++) buttons[i] = new JButton("" + i); // set number buttons

        // operations
        buttons[10] = new JButton(".");
        buttons[11] = new JButton("+");
        buttons[12] = new JButton("-");
        buttons[13] = new JButton("*");
        buttons[14] = new JButton("/");
        buttons[15] = new JButton("Del");
        buttons[16] = new JButton("Clr");
        buttons[17] = new JButton("(-)");
        buttons[18] = new JButton("=");

        // add everything in correct order
        for(int i = 1; i < 10; i++) {
            buttonContainer.add(buttons[i]); // add the number button to UI
            if(i == 3) buttonContainer.add(buttons[11]);   // add plus
            else if(i == 6) buttonContainer.add(buttons[12]);   // add minus
            else if(i == 9) buttonContainer.add(buttons[13]);  // add multiply
        }

        buttonContainer.add(buttons[0]);
        buttonContainer.add(buttons[10]); // decimal point
        buttonContainer.add(buttons[18]); // equal
        buttonContainer.add(buttons[14]); // divide
        buttonContainer.add(buttons[17]); // negative
        buttonContainer.add(buttons[15]); // delete
        buttonContainer.add(buttons[16]); // clear

        // add action listeners to all buttons
        for(JButton button: buttons) button.addActionListener(this);

        frame.add(display);
        frame.add(buttonContainer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttons[1]) {
            String displayText = reset ? "1" :display.getText() + "1";
            display.setText(displayText);
            reset = false;
        } else if(e.getSource() == buttons[2]){
            String displayText = reset ? "2" :display.getText() + "2";
            display.setText(displayText);
            reset = false;
        } else if(e.getSource() == buttons[3]){
            String displayText = reset ? "3" :display.getText() + "3";
            display.setText(displayText);
            reset = false;
        } else if(e.getSource() == buttons[4]){
            String displayText = reset ? "4" :display.getText() + "4";
            display.setText(displayText);
            reset = false;
        } else if(e.getSource() == buttons[5]){
            String displayText = reset ? "5" :display.getText() + "5";
            display.setText(displayText);
            reset = false;
        } else if(e.getSource() == buttons[6]){
            String displayText = reset ? "6" :display.getText() + "6";
            display.setText(displayText);
            reset = false;
        } else if(e.getSource() == buttons[7]){
            String displayText = reset ? "7" :display.getText() + "7";
            display.setText(displayText);
            reset = false;
        } else if(e.getSource() == buttons[8]) {
            String displayText = reset ? "8" : display.getText() + "8";
            display.setText(displayText);
            reset = false;
        } else if(e.getSource() == buttons[9]){
            String displayText = reset ? "9" :display.getText() + "9";
            display.setText(displayText);
            reset = false;
        } else if(e.getSource() == buttons[11]) {
            // plus
            res += Integer.parseInt(display.getText());
            display.setText(Integer.toString(res));
            reset = true;
            operation = "plus";
        }
        else if(e.getSource() == buttons[12]) {
            // minus
            res -= Integer.parseInt(display.getText());
            display.setText(Integer.toString(res));
            reset = true;
            operation = "minus";
        }
        else if(e.getSource() == buttons[13]) {
            // multiply
            res *= Integer.parseInt(display.getText());
            display.setText(Integer.toString(res));
            reset = true;
            operation = "multiply";
        }
        else if(e.getSource() == buttons[18]) {
            // equal
            switch (operation) {
                case "plus":
                    res += Integer.parseInt(display.getText());
                    break;
                case "minus":
                    res -= Integer.parseInt(display.getText());
                    break;
                case "multiply":
                    res *= Integer.parseInt(display.getText());
                    break;
            }
            display.setText(Integer.toString(res));
            reset = true;
        }
    }
}
