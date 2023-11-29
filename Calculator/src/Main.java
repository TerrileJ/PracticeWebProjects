import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(250,300));
        frame.setResizable(false);

        // result label
        JLabel display = new JLabel();
        display.setPreferredSize(new Dimension(200, 30));
        display.setOpaque(true);
        display.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        display.setBackground(Color.lightGray);
        display.setHorizontalAlignment(SwingConstants.RIGHT);

        // grid of buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(5,4));
        buttons.setPreferredSize(new Dimension(200,200));

        // numbers
        JButton zero = new JButton("0");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four =  new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton decimalPoint = new JButton(".");  // used as placeholders for more aesthetic UI

        // operations
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");
        JButton delete = new JButton("Del");
        JButton clear = new JButton("Clr");
        JButton negative = new JButton("(-)");
        JButton equals = new JButton("=");

        one.addActionListener(e -> display.setText(display.getText() + "1"));
        two.addActionListener(e -> display.setText(display.getText() + "2"));
        three.addActionListener(e -> display.setText(display.getText() + "3"));
        four.addActionListener(e -> display.setText(display.getText() + "4"));
        five.addActionListener(e -> display.setText(display.getText() + "5"));
        six.addActionListener(e -> display.setText(display.getText() + "6"));
        seven.addActionListener(e -> display.setText(display.getText() + "7"));
        eight.addActionListener(e -> display.setText(display.getText() + "8"));
        nine.addActionListener(e -> display.setText(display.getText() + "9"));

        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(plus);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(minus);
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);
        buttons.add(multiply);
        buttons.add(zero);
        buttons.add(decimalPoint);
        buttons.add(equals);
        buttons.add(divide);
        buttons.add(negative);
        buttons.add(delete);
        buttons.add(clear);

        // add to frame
        frame.add(display);
        frame.add(buttons);
    }
}