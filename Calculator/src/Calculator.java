import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JLabel display;
    JButton[] buttons;
    int res; // value stored in calculator
    boolean isFirstDigit; // used to determine when number buttons should override current displayed text
    boolean isStart; // used to determine if calculator is at initial stage
    String operation;

    Calculator() {
        res = 0;
        isStart = true;
        isFirstDigit = true;
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
        if(e.getSource() == buttons[1]) setDisplay("1");
        else if(e.getSource() == buttons[2]) setDisplay("2");
        else if(e.getSource() == buttons[3]) setDisplay("3");
        else if(e.getSource() == buttons[4]) setDisplay("4");
        else if(e.getSource() == buttons[5]) setDisplay("5");
        else if(e.getSource() == buttons[6]) setDisplay("6");
        else if(e.getSource() == buttons[7]) setDisplay("7");
        else if(e.getSource() == buttons[8]) setDisplay("8");
        else if(e.getSource() == buttons[9]) setDisplay("9");
        else if(e.getSource() == buttons[11]) {
            // plus
            calculateRes(Integer.parseInt(display.getText()));
            operation = "plus";
        }
        else if(e.getSource() == buttons[12]) {
            // minus
            calculateRes(Integer.parseInt(display.getText()));
            operation = "minus";
        }
        else if(e.getSource() == buttons[13]) {
            // multiply
            calculateRes(Integer.parseInt(display.getText()));
            operation = "multiply";
        }
        else if(e.getSource() == buttons[18]) {
            // equal
            calculateRes(Integer.parseInt(display.getText()));
            display.setText(Integer.toString(res));
        }
        else if(e.getSource() == buttons[15]) {
            // delete - remove last inputted value, only when values are being inputted and NOT when results are being shown
            if(!isFirstDigit) display.setText(display.getText().substring(0,Math.max(0,display.getText().length() - 1)));
        }
        else if(e.getSource() == buttons[16]) {
            // clear - simply resets calculator to initial state
            res = 0;
            operation = "";
            isStart = true;
            isFirstDigit = true;
            display.setText("");
        }
    }

    /**
     * On pressing an operation btn, calculates updated result based on current operation and values
     * @param number - value of number btn pressed before operation btn
     */
    public void calculateRes(int number) {
        // base case 1 - this means we pressed an operation btn consecutively
        if(isFirstDigit) return;

        // update variables that have consistent behavior after all operations
        isFirstDigit = true;

        // base case 2- very first value inputted, only updates initial calculator result
        if(isStart) {
            res = number;
            isStart = false;
            return;
        }

        // calculate new result
        switch (operation) {
            case "plus":
                res += number;
                break;
            case "minus":
                res -= number;
                break;
            case "multiply":
                res *= number;
                break;
        }
        operation = "";

        // show new result on display
        display.setText(Integer.toString(res));
    }

    /**
     * On pressing a number btn, updates display.
     * If number is first digit of a new value, clears display and shows the number
     * Otherwise, appends number to whatever is on display
     *
     * @param number - value of number btn pressed
     */
    public void setDisplay(String number) {
        String displayText = isFirstDigit ? number : display.getText() + number;
        display.setText(displayText);
        isFirstDigit = false;
    }
}
