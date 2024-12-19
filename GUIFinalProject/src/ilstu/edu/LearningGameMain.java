package ilstu.edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LearningGameMain {
    private JFrame frame;
    private JLabel welcomeTitle;
    private JButton alphabetButton;
    private JButton countingButton;
    private JButton colorsShapesButton;
    private String name;

    public LearningGameMain() {
        name = JOptionPane.showInputDialog("Enter your name:");

        frame = new JFrame("Kid's Learning Game - " + name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 1));
        
        welcomeTitle = new JLabel("Welcome " + name + "! Select a game:", JLabel.CENTER);
        
        alphabetButton = new JButton("Alphabet Game");
        alphabetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AlphabetGame(name);
            }
        });

        countingButton = new JButton("Counting Game");
        countingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CountingGame(name);
            }
        });

        colorsShapesButton = new JButton("Colors and Shapes Game");
        colorsShapesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ColorsShapesGame(name);
            }
        });
        
        frame.add(welcomeTitle);
        frame.add(alphabetButton);
        frame.add(countingButton);
        frame.add(colorsShapesButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LearningGameMain();
    }
}