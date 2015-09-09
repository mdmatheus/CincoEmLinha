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
	private TabuleiroV tabuleiroV;

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
		tabuleiroV = new TabuleiroV();

		for (int linha = 0; linha < 15; linha++) {
			for (int coluna = 0; coluna < 15; coluna++) {
				visao(panel, linha, coluna);
			}
		}

		lblNewLabel = new JLabel("Resultado");
		panel.add(lblNewLabel);

//		for (int i = 0; i < array1.length; i++) {
//			array1[i] = i;
//		}
//
//		for (int i = 0; i < array2.length; i++) {
//			array2[i] = i;
//		}
//
//		Collections.shuffle(Arrays.asList(array1));
//		Collections.shuffle(Arrays.asList(array2));
//
//		boolean achou = false;
//		for (int i = 0; i < array1.length; i++) {
//			for (int j = 0; j < array2.length; j++) {
//
//				if (!achou) {
//
//					if (vezX == true) {
//						tabuleiro.setEstadoX(array1[i], array2[j]);
//						tabuleiroV.setNome(array1[i], array2[j], "X");
//						vezX = false;
//					} else {
//						tabuleiro.setEstadoO(array1[i], array2[j]);
//						tabuleiroV.setNome(array1[i], array2[j], "O");
//						vezX = true;
//					}
//					visaoRemoveListener(i, j);
//
//					if (tabuleiro.checar5X(array1[i], array2[j])) {
//						lblNewLabel.setText("X GANHOU");
//						achou = true;
//					} else if (tabuleiro.checar5O(array1[i], array2[j])) {
//						lblNewLabel.setText("O GANHOU");
//						achou = true;
//					}
//
//				}
//			}
//
//		}

	}

	private void visaoRemoveListener(int i, int j) {
		tabuleiroV.removeListener(array1[i], array2[j], this);
	}

	private void visao(JPanel panel, int linha, int coluna) {
		panel.add(tabuleiroV.getCampoByXY(linha, coluna));
		tabuleiroV.setSize(linha, coluna, 50, 50);
		tabuleiroV.addListener(linha, coluna, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int linha = ((CampoV) e.getSource()).getLinha();
		int coluna = ((CampoV) e.getSource()).getColuna();

		if (vezX == true) {
			tabuleiro.setEstadoX(linha, coluna);
			tabuleiroV.setNome(linha, coluna, "X");
			vezX = false;
		} else {
			tabuleiro.setEstadoO(linha, coluna);
			tabuleiroV.setNome(linha, coluna, "O");
			vezX = true;
		}
		tabuleiroV.removeListener(linha, coluna, this);

		if (tabuleiro.checar5X(linha, coluna)) {
			lblNewLabel.setText("X GANHOU");
			tabuleiroV.setNome(linha, coluna, "X!!");
		} else if (tabuleiro.checar5O(linha, coluna)) {
			lblNewLabel.setText("O GANHOU");
			tabuleiroV.setNome(linha, coluna, "O!!");
		}

	}

}
