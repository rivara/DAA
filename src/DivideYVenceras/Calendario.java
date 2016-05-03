package DivideYVenceras;

public class Calendario {
	
		public static void formarTabla (int [][] t, int primero, int ultimo) {
		int medio;
		if (ultimo - primero == 1) {
			 /*caso base: compiten entre ambos (el mismo día)*/
			t[primero][0]=ultimo;
			t[ultimo][0]=primero;
		}else {
			medio = (primero+ultimo) / 2;
			/*primera subsolución: participantes de 1 a 2k-1*/						
			formarTabla(t,primero,medio);
			/*segunda subsolución: participantes de 2k-1+1 a 2k*/  		  
			formarTabla(t,medio+1,ultimo);
			
			/*completa la tabla de los participantes de la primera subsolución con los de la segunda*/
			completarTabla(t, primero, medio, medio , ultimo-1, medio+1);
			/*completa la tabla de los participantes de la segunda subsolución con los de la primera*/
			completarTabla(t, medio+1, ultimo, medio, ultimo-1, primero);
			
		}		
	}
	
	public static void completarTabla(int [][]t, int  eqInf, int eqSup, int diaInf,int diaSup,int eqInicial) {
			
			for (int j = diaInf; j<=diaSup; j++) {
				
				t[eqInf][ j] = eqInicial + j- diaInf;
			}
			
			for (int i = eqInf + 1; i<=eqSup; i++) {
				/*Intercambio de contrincante*/
				/*el último contrincante de i-1 es ahora el primer contrincante de i*/	
				t[i][diaInf] = t[i-1][ diaSup];
				for (int j = diaInf + 1; j<=diaSup; j++) {
					  /*rotación de los contrincantes*/
					 t[i][j] = t[i-1][j-1]; /*el contrincante de ayer de i-1, es el contrincante de hoy para i*/
				}
			}
	}
	public static void main (String args[]) {
		
		int calendario [][] = new int [4][ 3];
		//Desde el jugador 0 al jugador 3
		formarTabla (calendario, 0,3);
		
		for ( int i=0; i < 4; i++ ) {
			System.out.print ("Jugador: "+i+"=>");
			for ( int j=0; j < 3; j++ ) {
				System.out.print (calendario[i][j]+ " ");
			}
			System.out.println ();
		} 
	}
}
