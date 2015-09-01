import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jogo implements ActionListener {

	private JFrame frame;
	private boolean vezX = true;

	private Tabuleiro tabuleiro;

	private JLabel lblNewLabel;

	Integer[] array1 = new Integer[15];
	Integer[] array2 = new Integer[15];

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

		tabuleiro = new Tabuleiro();

		for (int linha = 0; linha < 15; linha++) {
			for (int coluna = 0; coluna < 15; coluna++) {
				panel.add(tabuleiro.getCampoByXY(linha, coluna));
				tabuleiro.getCampoByXY(linha, coluna).setPreferredSize(
						new Dimension(50, 50));
				tabuleiro.getCampoByXY(linha, coluna).addActionListener(this);
			}
		}

		lblNewLabel = new JLabel("Resultado");
		panel.add(lblNewLabel);

		for (int i = 0; i < array1.length; i++) {
			array1[i] = i;
		}

		for (int i = 0; i < array2.length; i++) {
			array2[i] = i;
		}

		Collections.shuffle(Arrays.asList(array1));
		Collections.shuffle(Arrays.asList(array2));

		boolean achou = false;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {

				if (!achou) {

					if (vezX == true) {
						tabuleiro.setEstadoX(array1[i], array2[j]);
						tabuleiro.setNome(array1[i], array2[j], "X");
						vezX = false;
					} else {
						tabuleiro.setEstadoO(array1[i], array2[j]);
						tabuleiro.setNome(array1[i], array2[j], "O");
						vezX = true;
					}
					tabuleiro.getCampoByXY(array1[i], array2[j])
							.removeActionListener(this);

					if (tabuleiro.checar5X(array1[i], array2[j])) {
						lblNewLabel.setText("X GANHOU");
						achou = true;
					} else if (tabuleiro.checar5O(array1[i], array2[j])) {
						lblNewLabel.setText("O GANHOU");
						achou = true;
					}

				}
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int linha = ((Campo) e.getSource()).linha;
		int coluna = ((Campo) e.getSource()).coluna;

		if (vezX == true) {
			tabuleiro.setEstadoX(linha, coluna);
			tabuleiro.setNome(linha, coluna, "X");
			vezX = false;
		} else {
			tabuleiro.setEstadoO(linha, coluna);
			tabuleiro.setNome(linha, coluna, "O");
			vezX = true;
		}
		tabuleiro.getCampoByXY(linha, coluna).removeActionListener(this);

		if (tabuleiro.checar5X(linha, coluna)) {
			lblNewLabel.setText("CINCOO");
		}

	}

}
