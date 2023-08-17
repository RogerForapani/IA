
public class RedeNeural {
	Matriz weigth = new Matriz();
	Matriz weigth2 = new Matriz();
	Matriz tendencias = new Matriz();
	Matriz tendencias2 = new Matriz();
	Matriz entradainf = new Matriz();
	Matriz saidainf = new Matriz();
	Matriz targetinf = new Matriz();
	double learningRate;
	//2,2,1
	
	public void criarRede(int entrada, int oculta, int saida) {// 2, 3 , 1 
		this.weigth.criarMatriz(oculta,entrada,1); // [2,2]
		this.weigth2.criarMatriz(saida, oculta, 1);
		this.tendencias.criarMatriz(oculta, 1, 1);
		this.tendencias2.criarMatriz(saida, 1, 1);
		this.learningRate = 0.3;
	}
	
	
	public void treino(Matriz entrada,Matriz target) { // 3,2,4 [2,1]
		Matriz hiden = new Matriz();
		Matriz output = new Matriz();
		Matriz erroSaida = new Matriz();
		Matriz erroOculta = new Matriz();
		Matriz hidenT = new Matriz();
		Matriz deltaPeso2 = new Matriz();
		Matriz deltaPesos2T=new Matriz();
		Matriz output_error = new Matriz();
		Matriz input_T = new Matriz();
		this.targetinf.copy(target);
		this.entradainf.copy(entrada);

		hiden.multiplicarMatriz(this.weigth,entrada);
		hiden.soma(this.tendencias);
		hiden.sigmoid();
		output.multiplicarMatriz(this.weigth2,hiden);
		output.soma(this.tendencias2);
		output.sigmoid();
		this.saidainf.copy(output);
		erroSaida.copy(target);
		erroSaida.subtracao(output);
		output_error.copy(erroSaida);
		output.dsigmoid();
		erroSaida.hadamard(output);
		erroSaida.escMult(this.learningRate);
		this.tendencias2.soma(erroSaida);
		
		hidenT.transpor(hiden);
		deltaPeso2.multiplicarMatriz(erroSaida, hidenT);
		Matriz pesin = new Matriz();
		pesin.copy(this.weigth2);
		pesin.soma(deltaPeso2);
		this.weigth2.copy(pesin);
		deltaPesos2T.transpor(pesin);
		erroOculta.multiplicarMatriz(deltaPesos2T, output_error);
		
		hiden.dsigmoid();
		input_T.transpor(entrada);
		erroOculta.hadamard(hiden);
		erroOculta.escMult(this.learningRate);
		
		this.tendencias.soma(erroOculta);
		
		Matriz deltaO = new Matriz();
		deltaO.multiplicarMatriz(erroOculta, input_T);
		this.weigth.soma(deltaO);
	}
	public String showInfo(RedeNeural rede) {
		String info ="";
		int va;
		info += "---------- Rede Info ------------";
		info += "\nEntrada: \n";
		info += this.entradainf.mostrarMatriz();
		info += "---- Saída:\n"+ this.saidainf.mostrarMatriz();
		info += "----";
		info += "Resposta esperada: \n" + this.targetinf.mostrarMatriz();
		info += "\nAcertou ?";
		if(this.saidainf.getMatriz()[0][0] <= 0.50) {
			va = 0;
		}
		else {
			va = 1;
		}
		if ((int)this.targetinf.getMatriz()[0][0] == va) {
			
			info += "Sim!";
		}
		else {
		
			info += "Não!";
			
		}
		info += "\nFim!!!!!!\n ----------------------------------\n----------------------------------";
		return info;
	}
}

