package DivideYVenceras;

class busquedaNumero {
	public static int buscarIndice(int v[], int inicio, int fin) {
		// System.out.println ("Entramos con: "+(inicio)+" "+fin);
		if (inicio == fin) {
			if (v[inicio] == inicio)
				return inicio;
			else
				return -1;
		} else {
			int mitad = (inicio + fin) / 2;
			if (v[mitad] == mitad) {
				return mitad;
			} else if (v[mitad] > mitad) {
				return buscarIndice(v, inicio, mitad);
			} else {
				return buscarIndice(v, mitad + 1, fin);
			}
		}

	}

	public static void main(String args[]) {
		int arrayEntrada[] = { -1, 1, 3, 4, 6, 20, 22, 24 }; // Este es el array
																// de elementos

		int elemento = buscarIndice(arrayEntrada, 0, arrayEntrada.length - 1);
		System.out.println("Posicion buscada: " + elemento);

	}

}
