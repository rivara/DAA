package dyv;

public class Hoja4E1 {
/*	private static boolean Orden(int numeros[], int ini, int fin) {
	// caso base
			if (ini == fin) {
				return true;
			} else {
				
				int medio = (ini + fin) / 2;
				
				if ((numeros[medio] > numeros[medio - 1])
						&& (numeros[medio] < numeros[medio + 1])) {
							 return true;
			}else{
				Orden(numeros, medio + 1, fin);
				Orden(numeros, ini, medio);
				

				// si el numero por la izquierda es menor y por la derecha que el actual
				
				
			}	
			
			}
			return false;
			
		}*/
	 public static int estaOrdenado (int v[], int inicio, int fin) {
			if (inicio==fin) {
				return -1;
			}else if (inicio+1==fin) {
				if (v[inicio]<=v[fin]) {
					return -1;
				}else {
					return inicio;
				}
			}else {
				int mitad = (inicio + fin) /2;
				
				if ((v[mitad]<v[mitad-1]) || (v[mitad+1]<v[mitad])) 
					return mitad;
				else {
					int pos_1 =  estaOrdenado (v, inicio, mitad);
					int pos_2 =  estaOrdenado (v, mitad+1, fin);
					if (pos_1>pos_2)
						return pos_1;
					else
						return pos_2;
				}
			}
		 }
//falla en la segunda mitad
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*		// llamada principal
				int arrayEntrada[] = {1,4,5,7,20,11};
				boolean ordenado = Orden(arrayEntrada, 1, arrayEntrada.length-1);
				System.out.println("esta ordenado: " + ordenado);

	}*/
int arrayEntrada[]={1,2,3,8,6,23,23,24}; //Este es el array de elementos 
		
		int posicion_erronea = estaOrdenado (arrayEntrada, 0, arrayEntrada.length-1);
		if (posicion_erronea==-1)
			System.out.println ("Vector Ordenado");
		else
			System.out.println ("No esta ordenado: "+posicion_erronea);
	}

}
