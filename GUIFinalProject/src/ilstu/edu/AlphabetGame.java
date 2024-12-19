package ilstu.edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class AlphabetGame {
    private JFrame frame;
    private JLabel questionPrompt;
    private JButton[] options;
    private String name;
    private char currentLetter;

    public AlphabetGame(String name) {
        this.name = name;
        gameFrame();
        gameElements();
        newQuestion();
    }

    private void gameFrame() {
        frame = new JFrame("Alphabet Game - " + name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(2, 1));
    }

    private void gameElements() {
    	questionPrompt = new JLabel("", JLabel.CENTER);
        frame.add(questionPrompt);

        JPanel optionsPanel = new JPanel(new GridLayout(1, 3));
        options = new JButton[3];
        
        for (int i = 0; i < options.length; i++) {
            options[i] = new JButton();
            options[i].addActionListener(this::checkAnswer);
            optionsPanel.add(options[i]);
        }
        
        frame.add(optionsPanel);
        frame.setVisible(true);
    }

    private void newQuestion() {
        Random random = new Random();
        
        currentLetter = (char) ('A' + random.nextInt(26));
        questionPrompt.setText("Find the image with the letter: " + currentLetter);

        for (JButton button : options) {
            char letter = (char) ('A' + random.nextInt(26));
            String imagePath = "/ilstu/edu/AlphabetGameImages/" + letter + ".png";
            button.setIcon(new ImageIcon(getClass().getResource(imagePath)));
            button.setActionCommand(String.valueOf(letter));
        }

        int index = random.nextInt(options.length);
        
        String imageLocation = "/ilstu/edu/AlphabetGameImages/" + currentLetter + ".png";
        options[index].setIcon(new ImageIcon(getClass().getResource(imageLocation)));
        options[index].setActionCommand(String.valueOf(currentLetter));
    }

    private void checkAnswer(ActionEvent event) {
        String selectedOption = event.getActionCommand();
        JOptionPane.showMessageDialog(frame, selectedOption.equals(String.valueOf(currentLetter)) ? "Correct!" : "Wrong. The correct answer was supposed to start with: " + currentLetter);
        newQuestion();
    }
}