import java.util.Random;
import java.util.Scanner;

public class InteligenciaArtificial {
	public static void main(String[] args) {

		BancoDeDados banco = new BancoDeDados();
		Scanner scan = new Scanner(System.in);
		Random rad = new Random();
		banco.conectarBanco();
		//banco.inserirDado(posicao,numero);
		//banco.atualizarDado(posicao,numero);
		//banco.lerDado(posicao,decisao);
		//banco.excluirDado(=,1); // o primeiro parametro server para decidir o operador, o segundo se for -1 exclui tudo
		System.out.println("teste");

		//mA.criarMatriz(3,1,false);  o parametro false ou true serve para definir se a matriz criada é de 0 ou aleatoria
		// exclui todas para cima do 51  banco.excluirDado(">51", 0);

		RedeNeural rede1 = new RedeNeural();
		Matriz e1 = new Matriz();
		Matriz e2 = new Matriz();
		Matriz e3 = new Matriz();
		Matriz e4 = new Matriz();
		Matriz E = new Matriz();
		Matriz E2 = new Matriz();
		e1.criarMatriz(2, 1, -1);
		e2.criarMatriz(2, 1, -1);
		e3.criarMatriz(2, 1, -1);
		e4.criarMatriz(2, 1, -1);
		
		Matriz C = new Matriz();
		
		System.out.println(C.mostrarMatriz());
		
		double[][] mat1= {{1.0},{1.0}};
		double[][] mat2= {{0.0},{1.0}};
		double[][] mat3= {{1.0},{0.0}};
		double[][] mat4= {{0.0},{0.0}};
		E.criarMatriz(1, 1, -1);
		E2.criarMatriz(1, 1, -1);
		
		double[][] d1= {{1.0}};
		double[][] d2= {{0.0}};
	
		
		e1.setMatriz(mat1);
		e2.setMatriz(mat2);
		e3.setMatriz(mat3);
		e4.setMatriz(mat4);
		
		E.setMatriz(d1);
		E2.setMatriz(d2);
		
		rede1.criarRede(2,4,1);
		int p = 0;
		while(p == 0) {
			System.out.println("Digite: \n" + "-0 para finalizar\n" + "-Ou o número de vezes para treinar");
			int n = scan.nextInt();
			
			if(n!=0) {
				for(int i = 0; i < n;i++) {
					int val = rad.nextInt(4);
					System.out.println("rad"+val);			
					switch(val) {
					case 0:
						rede1.treino(e1, E2);
						break;
					case 1:
						
						rede1.treino(e2, E);
						
						break;
					case 2:
						
						rede1.treino(e3, E);
						
						break;
					case 3:
						rede1.treino(e4, E2);
						break;
					default:
						System.out.println("Deu ruim");
						
					}
					System.out.println(rede1.showInfo(rede1));
					
					
					
				
				}
			}
		}
	}
}
