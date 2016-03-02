package dyv;

public class Hoja4E2 {
	
	/*private static int OrdenPos(int numeros[], int ini, int fin) {
		// caso base
				if (ini == fin) {
					return 0;
				} else {

					int medio = (ini + fin) / 2;
					OrdenPos(numeros, ini, medio);
					OrdenPos(numeros, medio + 1, fin);

					// si el numero por la izquierda es menor y por la derecha que el actual

						if ((numeros[medio] > numeros[medio - 1])
								&& (numeros[medio] < numeros[medio + 1])) {
									 System.out.println("punto de desorden"+medio);
									 return medio;
					}
						
					return 0;
				}
				
			}*/

    public static int buscarDesordenado (int v[], int inicio, int fin) {
	if (inicio==fin) { 
		return -1;
	}else if (inicio+1==fin) { //Vector de dos posiciones 
		if (v[fin]<v[inicio]) {
			return fin;
		} else {
			return -1;
		}
	}else {
		int mitad = (inicio + fin) /2;
		if (v[mitad]> v[mitad+1]) {
			return mitad+1;
		}else if (v[mitad]<v[mitad-1]){
			return mitad;
		}else {
			int posicion = buscarDesordenado (v, inicio, mitad-1);
			if (posicion==-1) {
				posicion = buscarDesordenado (v, mitad+1, fin);
			}
			return -1;
		}
	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// llamada principal
			/*	int arrayEntrada[] = {1,2,3,4,5};
				int ordenado = OrdenPos(arrayEntrada, 1, arrayEntrada.length-1);
				System.out.println("si sale 0 esta ordenado");
				System.out.println("");
				System.out.println("esta ordenado" + ordenado);*/
	//   int arrayEntrada[]={1,2,3,4,5,0,7,8,9,10,11}; //Este es el array de elementos 
	    	int arrayEntrada[]={2,4,6,8,16,12,18,20,22,24}; //Este es el array de elementos 
	     	int posicion=buscarDesordenado (arrayEntrada, 0, arrayEntrada.length-1);
	    	System.out.println ("Elemento desordenado en: "+posicion);

	}
}
