import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(250,250));

        // result label
        JLabel display = new JLabel();
        display.setPreferredSize(new Dimension(200, 30));
        display.setText("0");
        display.setOpaque(true);
        display.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        display.setBackground(Color.lightGray);
        display.setHorizontalAlignment(SwingConstants.RIGHT);

        // grid of buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3,3));
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four =  new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");

        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);

        // add to frame
        frame.add(display);
        frame.add(buttons);
    }
}