import javax.swing.*;
import java.awt.*;

public class Calculator {
    JFrame frame;
    JLabel display;
    Calculator() {
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
        JButton[] buttons = new JButton[19];
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

        frame.add(display);
        frame.add(buttonContainer);
    }
}
