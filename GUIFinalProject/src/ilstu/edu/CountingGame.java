package ilstu.edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class CountingGame {
    private JFrame frame;
    private JPanel starsPanel;
    private JTextField answerInput;
    private JButton submitButton;
    private String name;
    private int count;

    public CountingGame(String name) {
        this.name = name;
        gameFrame();
        gameElements();
        newQuestion();
    }

    private void gameFrame() {
        frame = new JFrame("Counting Game - " + name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
    }

    private void gameElements() {
        starsPanel = new JPanel(new FlowLayout());
        frame.add(starsPanel, BorderLayout.CENTER);

        JPanel answerPanel = new JPanel();
        answerInput = new JTextField(5);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this::checkAnswer);

        answerPanel.add(answerInput);
        answerPanel.add(submitButton);
        frame.add(answerPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void newQuestion() {
    	starsPanel.removeAll();
    	
        Random random = new Random();
        count = random.nextInt(10) + 1;

        ImageIcon imageLocation = new ImageIcon(getClass().getResource("/ilstu/edu/CountingGameImages/CountGameStar.png"));
        for (int i = 0; i < count; i++) {
            JLabel imageLabel = new JLabel(imageLocation);
            starsPanel.add(imageLabel);
        }

        frame.revalidate();
        frame.repaint();
    }

    private void checkAnswer(ActionEvent e) {
        int answer = Integer.parseInt(answerInput.getText());
        String message = answer == count ? "Correct!" : "Wrong. The correct number was " + count;
        JOptionPane.showMessageDialog(frame, message);
        newQuestion();
    }
}