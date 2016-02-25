package dyv;

public class Hoja4E3 {
	private static String MatrizTipo(int numeros[][], int ini, int fin) {
		// caso base
				if (ini == fin) {
					return "neutra";
				} else {

					int medio = (ini + fin) / 2;
					MatrizTipo(numeros, ini, medio);
					MatrizTipo(numeros, medio + 1, fin);

					// si el numero por la izquierda es menor y por la derecha que el actual

					/*	if ((numeros[medio][] > numeros[medio - 1])
								&& (numeros[medio] < numeros[medio + 1])) {
									 System.out.println("punto de desorden"+medio);
									 return "restativa";
					}*/
						
					return "sumamtiva";
				}
				
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// llamada principal
				int arrayEntrada[][] = {{1,2,3,4,5},{1,2,3,4}};
				String ordenado = MatrizTipo(arrayEntrada, 1, arrayEntrada.length-1);
				System.out.println("si sale 0 esta ordenado");
				System.out.println("");
				System.out.println("esta ordenado" + ordenado);

	}

}
