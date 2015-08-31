import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Jogo implements ActionListener {

	private JFrame frame;
	private boolean vezX = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo window = new Jogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Jogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));		

		ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		for(int i = 0; i < 225; i++){
			buttons.add(new JButton(" "));			
		}
		
		for(JButton b : buttons){
			panel.add(b);
			b.setPreferredSize(new Dimension(50, 50));
			b.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vezX == true) {
			((JButton)e.getSource()).setText("X");
			vezX = false;
		} else {
			((JButton)e.getSource()).setText("O");
			vezX = true;
		}
		((JButton)e.getSource()).removeActionListener(this);
		
	}

}
