import javax.swing.JButton;

public class Campo extends JButton {

	public int linha, coluna;

	public boolean estadoX = false, estadoO = false;

	public Campo(String texto) {
		super(texto);
	}

	public void setNome(String nome) {
		this.setText(nome);

	}

}
