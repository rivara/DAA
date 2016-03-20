package DivideYVenceras;

class cifras
{
	 public static void main(String[] args)
	 {
		int arrayEntrada[]={2475 , 87223 , 78736, 37 , 137 , 237}; 
		
		boolean cifras[];
		
		cifras = CifrasComunes (arrayEntrada, 0, arrayEntrada.length-1);
		
		for (int i=0; i < cifras.length; i++) {
			if (cifras[i]) {
				System.out.println ("Cifra Comun: "+i);
			}
		}
		  
	 }
 
 //Este metodo es el que implementa DyV
	 public static boolean[] CifrasComunes (int numeros[], int ini, int fin) {
		if (ini==fin) {
			return DameCifrasNumero (numeros[ini]);
		}else {
			int medio = (ini + fin) /2;
			boolean cifras1[];
			boolean cifras2[];
			cifras1 = CifrasComunes (numeros, ini, medio);
			cifras2 = CifrasComunes (numeros, medio+1, fin);
			return combinar (cifras1, cifras2);
		}
	 }

	public static boolean[] DameCifrasNumero (int numero) {
		boolean cifras[] = {false, false, false, false, false, false, false, false, false, false};
		do {
			int cifra = numero % 10;
			numero = numero /10;
			cifras [cifra] =  true; 
		}while (numero!=0);
		return cifras;
	}
	public static boolean [] combinar (boolean cifras1[], boolean cifras2[]) {
		boolean cifras[] = new boolean [10];
		//Ahora hacemos el and 
		for (int i=0; i < cifras1.length; i++) {
			cifras [i] = cifras1 [i] && cifras2[i];
		}
		return cifras;
	}

}












