package dyv;

public class Hoja4E1 {
	private static boolean Orden(int numeros[], int ini, int fin) {
	// caso base
			if (ini == fin) {
				return true;
			} else {

				int medio = (ini + fin) / 2;
				Orden(numeros, ini, medio);
				Orden(numeros, medio + 1, fin);

				// si el numero por la izquierda es menor y por la derecha que el actual

					if ((numeros[medio] > numeros[medio - 1])
							&& (numeros[medio] < numeros[medio + 1])) {
								 System.out.println("punto medio real"+medio);
								 return true;
				}
					
				return false;
			}
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// llamada principal
				int arrayEntrada[] = {1,2,3,4,5};
				boolean ordenado = Orden(arrayEntrada, 1, arrayEntrada.length-1);
				System.out.println("esta ordenado" + ordenado);

	}

}
