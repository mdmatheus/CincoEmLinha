import java.awt.Dimension;

import javax.swing.JButton;

public class TabuleiroV {

	private CampoV[][] campoV = new CampoV[15][15];

	public TabuleiroV() {
		for (int linha = 0; linha < 15; linha++) {
			for (int coluna = 0; coluna < 15; coluna++) {
				campoV[linha][coluna] = new CampoV(linha, coluna);
			}
		}
	}

	public void removeListener(int linha, int coluna, Jogo j) {
		this.getCampoByXY(linha, coluna).removeActionListener(j);
	}

	public JButton[][] getCampos() {
		return this.campoV;
	}

	public JButton getCampoByXY(int linha, int coluna) {
		return this.campoV[linha][coluna];
	}

	public void setSize(int linha, int coluna, int x, int y) {
		this.getCampoByXY(linha, coluna).setPreferredSize(new Dimension(x, y));
	}

	public void addListener(int linha, int coluna, Jogo j) {
		this.getCampoByXY(linha, coluna).addActionListener(j);
	}
	
	public void setNome(int linha, int coluna, String nome){
		this.getCampoByXY(linha, coluna).setText(nome);
	}

}
