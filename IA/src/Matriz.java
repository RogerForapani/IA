public class Matriz {
	BancoDeDados banco = new BancoDeDados();
	private double linha;
	private double[][] matriz;
	private double coluna;
	Jogo jogo = new Jogo();

	public double getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public double[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(double[][] matriz) {
		this.matriz = matriz;
	}

	public double getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public void atualizarMatriz(double sort) {
		double ler;
		for(int i = 0 ; i< ((int)this.linha -1);i++ ) {
			for(int j = 0; j< this.coluna;j++) {
				ler = this.matriz[(int)this.linha -2 - i][j]; //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
				this.matriz[(int)this.linha - 1 - i][j] = ler;
			}
		}
		this.matriz[0][0] = sort;
		
	}
	public void criarMatriz(int linha, int coluna, int content) {
		// parametro content serve para criar matriz vazia se for -1, 1 se for random, 2
		// se pegar do banco de dados
		if (content == -1) {
			double matriz[][] = new double[linha][coluna];
			this.coluna = coluna;
			this.linha = linha;
			for(int i = 0 ; i < linha; i++) {
				for (int j = 0 ; j< coluna;j++) {
					matriz[i][j] = 0;
				}
			}
			this.matriz = matriz;
		} else {
			if (content == 2) {
				double matriz[][] = new double[linha][coluna];
				this.coluna = coluna;
				this.linha = linha;
				for (int i = 0; i < linha; i++) {
					for (int j = 0; j < coluna; j++) {
						matriz[i][j] = jogo.sorteio(1);
					}
				}
				this.matriz = matriz;
			} 
			else {
				double matriz[][] = new double[linha][coluna];
				this.coluna = coluna;
				this.linha = linha;
				this.matriz = matriz;
				for(int i = 0; i< linha; i ++) {
					for(int j=0; j<coluna;j++) {
						this.matriz[i][j] = jogo.sorteio(2);
					}
				}
				
			}
		}
	}

	public void multiplicarMatriz(Matriz mA, Matriz mB) {
		this.criarMatriz((int) mA.linha, (int) mB.coluna, -1);
		for (int i = 0; i < mA.linha; i++) {
			for (int j = 0; j < mB.coluna; j++) {
				for (int k = 0; k < mB.linha; k++) {
					this.matriz[i][j] += mA.matriz[i][k] * mB.matriz[k][j];
				}
			}
		}
	}

	public void hadamard(Matriz A) {
		if((this.linha == A.linha) && (this.coluna == A.coluna)) {
			for (int i = 0; i < A.linha; i++) {
				for (int j = 0; j < A.coluna; j++) {
					this.matriz[i][j] = (A.matriz[i][j]) * (this.matriz[i][j]);
				}
			}
		}
		else {
			System.out.println("Deu ruim Hadamard");
		}

	}

	public void soma(Matriz A) {
		if((this.linha == A.linha) && (this.coluna == A.coluna)) {
			for (int i = 0; i < A.linha; i++) {
				for (int j = 0; j < A.coluna; j++) {
					this.matriz[i][j] = A.matriz[i][j] + this.matriz[i][j];
				}
			}
		}
		else {
			System.out.println("Deu ruim Soma");
		}
	}

	public void subtracao(Matriz A) {
		if((this.linha == A.linha) && (this.coluna == A.coluna)) {
			for (int i = 0; i < A.linha; i++) {
				for (int j = 0; j < A.coluna; j++) {
					this.matriz[i][j] = this.matriz[i][j] - A.matriz[i][j];
				}
			}
		}
		else {
			System.out.println("Deu ruim Sub");
		}
	}

	public void escMult(double Esc) {
		for (int i = 0; i < this.linha; i++) {
			for (int j = 0; j < this.coluna; j++) {
				this.matriz[i][j] = this.matriz[i][j] * Esc;
			}
		}

	}

	public String mostrarMatriz() {

		String print = "";
		for (int i = 0; i < this.linha; i++) {
			print += "[";
			for (int j = 0; j < this.coluna; j++) {
				print += " " + this.matriz[i][j] + " ";
			}
			print += "]\n";
			//print += "\n\n\n";
		}
		return print;
	}
	
	public void dsigmoid() {
		for (int i = 0; i < this.linha; i++) {
			for (int j = 0; j < this.coluna; j++) {
				this.matriz[i][j] = this.matriz[i][j] * (1 - this.matriz[i][j]);
			}
		}
	}
	
	public void sigmoid() {
		for (int i = 0; i < this.linha; i++) {
			for(int j = 0; j<this.coluna;j++) {
				this.matriz[i][j] = 1 / (1 + Math.exp(- this.matriz[i][j]));
			}
		}
	}

	public void transpor(Matriz A) {

		this.criarMatriz((int) A.coluna, (int) A.linha, -1);
		for (int i = 0; i < A.linha; i++) {
			for (int j = 0; j < A.coluna; j++) {
				this.matriz[j][i] = A.matriz[i][j];
			}
		}
	}
	public void copy(Matriz A) {
		this.criarMatriz((int) A.linha,(int) A.coluna, -1);
		for (int i = 0; i < A.linha; i++) {
			for (int j = 0; j < A.coluna; j++) {
				this.matriz[i][j] = A.matriz[i][j];
			}
	}
}
}