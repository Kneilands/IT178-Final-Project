package ilstu.edu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ColorsShapesGame {
	private JFrame frame;
	private JLabel questionPrompt;
	private JButton[] options;
	private String name;
	private String correctAnswer;
	
	public ColorsShapesGame(String name) {
		this.name = name;
		gameFrame();
		gameElements();
		newQuestion();
	}
	
	private void gameFrame() {
		frame = new JFrame("Colors and Shapes Game - " + name);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,600);
		frame.setLayout(new GridLayout(2,1));
	}
	
	private void gameElements() {
		questionPrompt = new JLabel("", JLabel.CENTER);
		frame.add(questionPrompt);
		
		JPanel optionsPanel = new JPanel(new GridLayout(1,3));
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
		
		String[] colors = {"Blue", "Green", "Red"};
		String[] shapes = {"Circle", "Square", "Triangle"};
		
		boolean isItColor = random.nextBoolean();
		
		correctAnswer = isItColor ? colors[random.nextInt(colors.length)] : shapes[random.nextInt(shapes.length)];
		questionPrompt.setText("Find the: " + correctAnswer);
		
		int index = random.nextInt(options.length);
		
		for (int i = 0; i < options.length; i++) {
			String color = colors[random.nextInt(colors.length)];
			String shape = shapes[random.nextInt(shapes.length)];
			
			String combination = (i == index) 
                    ? (isItColor ? correctAnswer + shape : color + correctAnswer) 
                    : color + shape;
			
			String imageLocation = "/ilstu/edu/ColorsShapesGameImages/" + combination + ".png";
			options[i].setIcon(new ImageIcon(getClass().getResource(imageLocation)));
            options[i].setActionCommand(combination);
		}
	}
	
	private void checkAnswer(ActionEvent event) {
		String selectedOption = event.getActionCommand();
        JOptionPane.showMessageDialog(frame, selectedOption.contains(correctAnswer) ? "Correct!" : "Wrong. The correct answer was: " + correctAnswer);
        newQuestion();
	}
}