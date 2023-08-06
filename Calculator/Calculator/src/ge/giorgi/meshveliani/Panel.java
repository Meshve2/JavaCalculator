package ge.giorgi.meshveliani;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {

	private JButton numbers[] = new JButton[10];
	private Font font = new Font("SanSerif", Font.BOLD, 20); // Numbers fonts and size 20 px
	private JTextField output = new JTextField(); // output where we see result
	private JButton backspace = new JButton("<"), equ = new JButton("="); // here we added buttons
	private JButton plus = new JButton("+"), minus = new JButton("-"), mult = new JButton("*"), div = new JButton("/");

	private double firstNumber = 0;
	private char operation = ' ';

	
	public Panel() {
		setLayout(null);
		setFocusable(true);
		grabFocus();

		backspace.setBounds(10, 250, 50, 50); 
		backspace.setFont(font);
		add(backspace);
		
		
		

		equ.setBounds(130, 250, 50, 50); 
		equ.setFont(font);
		add(equ);

		plus.setBounds(190, 70, 50, 50); 
		plus.setFont(font);
		add(plus);
		
		minus.setBounds(190, 130, 50, 50); 
		minus.setFont(font);
		add(minus);

		mult.setBounds(190, 190, 50, 50); 
		mult.setFont(font);
		add(mult);

		div.setBounds(190, 250, 50, 50); 
		div.setFont(font);
		add(div);

		numbers[0] = new JButton("0");
		numbers[0].setBounds(70, 250, 50, 50);
		numbers[0].setFont(font);
		add(numbers[0]);

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				numbers[x * 3 + y + 1] = new JButton((x * 3 + y + 1) + "");
				numbers[x * 3 + y + 1].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50, 50);
				numbers[x * 3 + y + 1].setFont(font);
				add(numbers[x * 3 + y + 1]);
				System.out.println(x * 10 + 10 + 10);
			}

		}

		output.setBounds(10, 10, 230, 50);
		output.setFont(font); // font for output text
		output.setEditable(false);
		add(output);

		ActionListener l = (ActionEvent e) -> {

			JButton b = (JButton) e.getSource();
			output.setText(output.getText() + b.getText()); // this method adds in input numbers and text

		};

		for (JButton b : numbers) {
			b.addActionListener(l);
		}

		addKeyListener(new KeyAdapter() {
			@SuppressWarnings("unused")
			public void KeyPressed(KeyEvent e) {
				char symbol = e.getKeyChar();

				if (!Character.isDigit(symbol))
					return;

				output.setText(output.getText() + symbol);
			}
		});
		
		
		
		
		
		
		
		

		
		equ.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				double result = calculate ();
				output.setText(String.valueOf(result));
			}
		});
		
		
		plus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.parseDouble(output.getText());
				operation = '+';
				output.setText("");
			}
		});
		
		
		
		minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.parseDouble(output.getText());
				operation = '-';
				output.setText("");
			}
		});
		
		
		
		mult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.parseDouble(output.getText());
				operation = '*';
				output.setText("");
			}
		});
		
		
		div.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.parseDouble(output.getText());
				operation = '/';
				output.setText("");
			}
		});
		
		
		backspace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = output.getText();
				if (!text.isEmpty()) {
					output.setText("");
				}
				
			
			}
		});
		
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					double result = calculate();
					output.setText(String.valueOf(result));
				}
				
				
			}
		});
		
		
		
		

	}


	
	private double calculate() {
		double secondNumber = Double.parseDouble(output.getText());
		double result = 0;
		switch (operation) {
		case '+':
			result = firstNumber + secondNumber;
			break;
		case '-':
			result = firstNumber - secondNumber;
			break;
		case '*':
			result = firstNumber * secondNumber;
			break;
		case '/':
			if (secondNumber != 0) {
				result = firstNumber / secondNumber;
			} else {
				output.setText("Error: Division by zero");
			}
			break;
		default:
			output.setText("Error: Invalid operation");
			break;
		}
		operation = ' ';
		return result;
	}
}
