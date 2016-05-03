package Voraz;

//Aplicar la siguiente estrategia:
//1. Calcular el numero total de dias de los que se dispone
//2. Coger la huerta de maximo beneficio y asignarsela al dia que le corresponde segun su caducidad
//3. Coger la siguiente huerta de maximo beneficio y asignarsela al dia que le corresponde. 
//Si ese dia esta ocupado, asignarsela al dia anterior y seguir asi hasta poder asignarla o rechazarla
//4. Seguir con el paso 3 hasta completar los dias.

public class Hortelano {
	private static int N=5; //numero de huertas
	private static int K=8; //maxima caducidad
	private static int LIBRE=-1; //marca que no hay huerta asignada
	
	
	//ppal
		public static int [] soluVoraz(int h[][]){
			int s[] = new int [K]; 
			int c,j;
			//inicializa solucion 
			for (int i=0; i<K; i++){
				s[i]=LIBRE; 
			}
			
			for (int i=0; i<N; i++){
				c=seleccionCandidato(h);
				j=h[0][c]-1; // el dia n se anota en la posicion n-1 
				quitarCandidato(h,c);
				while ((j>0) && (s[j]!=LIBRE)){
					j=j-1;
				}
				if ((j>=0)&& (s[j]==LIBRE))
					s[j]=c;
			}
			return s; 
		}

	
	
	private static int seleccionCandidato(int h[][]){ 
		//buscamos la maxima caducidad
		int max=0;
		for (int i=0;i<N;i++){ 
			if (h[1][i]>h[1][max])
				max=i; 
		}
		return max; 
	}
	private static void quitarCandidato(int h[][], int c){ 
		h[1][c]=-1; //-1 marca de no hay candidato
	}
	
	
	public static void main (String args[]) {
		//X maximo beneficio
		//Y caducidad
		int h[][] = {{3,8,2,3,1}, {1, 2, 5, 6, 4}};

		int s[] = soluVoraz (h);

		for (int i=0; i<s.length; i++) {
			System.out.println ("S["+i+"]= "+s[i]);
		}
	}
}







