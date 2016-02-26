package dyv;

public class Hoja4E1 {
	private static boolean Orden(int numeros[], int ini, int fin) {
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
			
		}
//falla en la segunda mitad
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// llamada principal
				int arrayEntrada[] = {1,4,5,7,20,11};
				boolean ordenado = Orden(arrayEntrada, 1, arrayEntrada.length-1);
				System.out.println("esta ordenado: " + ordenado);

	}

}
