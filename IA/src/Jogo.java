
import java.util.Random;

public class Jogo {
	// se meu type for igual a 1 ele sorteia um numero aleatorio inteiro, se for igual a 0 ele retorna um double entre 0 e 1.
	public  double sorteio(int type) {

		double valor;
		Random rand = new Random();
		if(type == 1) {
			valor = rand.nextInt(37);
			if(valor==0) {
				valor = 0;
			}
			else {
				if((valor>=1) && (valor <=12)) {
					valor = 0.33;
				}
				else {
					if((valor > 12) && (valor <=24)) {
						valor = 0.66;
					}
					else {
						if((valor >24) && (valor <=36)) {
							valor = 0.99;
							
						}
					}
				}
			}
			//System.out.println(valor);
			return valor;
		}
		else {
			valor = rand.nextDouble();
			return valor;
		}
	}
}
