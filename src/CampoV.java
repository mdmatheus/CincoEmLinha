import javax.swing.JButton;

public class CampoV extends JButton{
	
	private int linha, coluna;
	
	public CampoV(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public int getLinha(){
		return this.linha;
	}
	
	public int getColuna(){
		return this.coluna;
	}
	
	
}
