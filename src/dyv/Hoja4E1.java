package dyv;

/*Implementa un algoritmo que devuelva true o false según si un vector está ordenado o no.
2 5 8 12 15 21 22 24 24 27 true
2 1 28 40 36 11 72 4 44 56 false
Pista: Puedes considerar dos casos base, vector de una posición o vector de dos
posiciones.*/

public class Hoja4E1 {
	public static int estaOrdenado(int v[], int inicio, int fin) {
		if (inicio == fin) {
			return -1;
		} else if (inicio + 1 == fin) {
			if (v[inicio] <= v[fin]) {
				return -1;
			} else {
				return inicio;
			}
		} else {
			int mitad = (inicio + fin) / 2;
			if ((v[mitad] < v[mitad - 1]) || (v[mitad + 1] < v[mitad]))
				return mitad;
			else {
				int pos_1 = estaOrdenado(v, inicio, mitad);
				int pos_2 = estaOrdenado(v, mitad + 1, fin);
				if (pos_1 > pos_2)
					return pos_1;
				else
					return pos_2;
			}
		}
	}

	public static void main(String[] args) {
		int arrayEntrada[] = { 1, 2, 8, 10, 20, 23, 24,25,21 }; // Este es el array
		int posicion_erronea = estaOrdenado(arrayEntrada, 0,
				arrayEntrada.length - 1);
		if (posicion_erronea == -1)
			System.out.println("Vector Ordenado");
		else
			System.out.println("Vector No Ordenado");
	}

}
