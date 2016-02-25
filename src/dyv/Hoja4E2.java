package dyv;

public class Hoja4E2 {
	private static int OrdenPos(int numeros[], int ini, int fin) {
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
				
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// llamada principal
				int arrayEntrada[] = {1,2,3,4,5};
				int ordenado = OrdenPos(arrayEntrada, 1, arrayEntrada.length-1);
				System.out.println("si sale 0 esta ordenado");
				System.out.println("");
				System.out.println("esta ordenado" + ordenado);

	}
}
