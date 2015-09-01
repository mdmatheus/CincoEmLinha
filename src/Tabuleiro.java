public class Tabuleiro {

	private Campo[][] campo;
	private int tamanhoDoCampo = 15;

	public Tabuleiro() {
		campo = new Campo[tamanhoDoCampo][tamanhoDoCampo];
		for (int linha = 0; linha < tamanhoDoCampo; linha++) {
			for (int coluna = 0; coluna < tamanhoDoCampo; coluna++) {
				campo[linha][coluna] = new Campo("");
				campo[linha][coluna].linha = linha;
				campo[linha][coluna].coluna = coluna;
			}
		}
	}

	public boolean checar5X(int linha, int coluna) {
		int z = -4, cinco1 = 0, cinco2 = 0, cinco3 = 0, cinco4 = 0;
		int linhaC, colunaC, linhaD;
		while (z <= 0) {
			for (int i = -4; i < 5; i++) {
				linhaC = linha + z + i;
				colunaC = coluna + z + i;
				linhaD = linha + z - i;

				if (colunaC >= 0 && linhaC >= 0 && colunaC < tamanhoDoCampo
						&& linhaC < tamanhoDoCampo) {

					if (cincoXEmSeguida(linha, colunaC)) {
						cinco1++;
						if (cinco1 == 5) {
							return true;
						}
					} else {
						cinco1 = 0;
					}

					if (cincoXEmSeguida(linhaC, coluna)) {
						cinco2++;
						if (cinco2 == 5) {
							return true;
						}
					} else {
						cinco2 = 0;
					}

					if (cincoXEmSeguida(linhaC, colunaC)) {
						cinco3++;
						if (cinco3 == 5) {
							return true;
						}
					} else {
						cinco3 = 0;
					}

					if (linhaD < tamanhoDoCampo && linhaD >= 0) {
						if (cincoXEmSeguida(linhaD, colunaC)) {
							cinco4++;
							if (cinco4 == 5) {
								return true;
							}
						} else {
							cinco4 = 0;
						}
					}

				}

			}

			cinco1 = 0;
			cinco2 = 0;
			cinco3 = 0;
			cinco4 = 0;
			z++;
		}

		return false;
	}
	
	
	public boolean checar5O(int linha, int coluna) {
		int z = -4, cinco1 = 0, cinco2 = 0, cinco3 = 0, cinco4 = 0;
		int linhaC, colunaC, linhaD;
		while (z <= 0) {
			for (int i = -4; i < 5; i++) {
				linhaC = linha + z + i;
				colunaC = coluna + z + i;
				linhaD = linha + z - i;

				if (colunaC >= 0 && linhaC >= 0 && colunaC < tamanhoDoCampo
						&& linhaC < tamanhoDoCampo) {

					if (cincoOEmSeguida(linha, colunaC)) {
						cinco1++;
						if (cinco1 == 5) {
							return true;
						}
					} else {
						cinco1 = 0;
					}

					if (cincoOEmSeguida(linhaC, coluna)) {
						cinco2++;
						if (cinco2 == 5) {
							return true;
						}
					} else {
						cinco2 = 0;
					}

					if (cincoOEmSeguida(linhaC, colunaC)) {
						cinco3++;
						if (cinco3 == 5) {
							return true;
						}
					} else {
						cinco3 = 0;
					}

					if (linhaD < tamanhoDoCampo && linhaD >= 0) {
						if (cincoOEmSeguida(linhaD, colunaC)) {
							cinco4++;
							if (cinco4 == 5) {
								return true;
							}
						} else {
							cinco4 = 0;
						}
					}

				}

			}

			cinco1 = 0;
			cinco2 = 0;
			cinco3 = 0;
			cinco4 = 0;
			z++;
		}

		return false;
	}

	private boolean cincoXEmSeguida(int linha, int coluna) {
		return this.campo[linha][coluna].estadoX;
	}
	
	private boolean cincoOEmSeguida(int linha, int coluna) {
		return this.campo[linha][coluna].estadoO;
	}

	public Campo getCampoByXY(int x, int y) {
		return this.campo[x][y];
	}

	public void setEstadoX(int x, int y) {
		this.campo[x][y].estadoX = true;
	}

	public void setEstadoO(int x, int y) {
		this.campo[x][y].estadoO = true;
	}

	public void setNome(int x, int y, String nome) {
		this.campo[x][y].setNome(nome);
	}

}
