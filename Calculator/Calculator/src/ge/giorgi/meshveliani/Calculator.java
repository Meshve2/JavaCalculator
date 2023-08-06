package ge.giorgi.meshveliani;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Calculator {
	
	private JFrame window;
	
	public Calculator () {
		window = new JFrame ("Calculator");
		window.setSize(260, 337); // calculators height and width
		window.add(new Panel());
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Calculator ();
			}
		});

	}

}
