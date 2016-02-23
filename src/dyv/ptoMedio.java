package dyv;

public class ptoMedio {

	private static int ptoMedio(int numeros[], int ini, int fin) {

		// caso base
		if (ini == fin) {
			return ini;
		} else {

			int medio = (ini + fin) / 2;
			ptoMedio(numeros, ini, medio);
			ptoMedio(numeros, medio + 1, fin);

			if ((medio - 1 > 0) && (medio + 1 < numeros.length)) {

				if ((numeros[medio] < numeros[medio - 1])
						&& (numeros[medio] < numeros[medio + 1])) {
					return medio;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// llamada principal
		int arrayEntrada[] = { 1, 2, 3, 0, 4, 5 };
		int pos = ptoMedio(arrayEntrada, 1, arrayEntrada.length - 1) + 1;
		System.out.println("el punto medio esta en la posicion: " + pos);

	}

}
