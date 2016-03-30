package DivideYVenceras;

/*Ejercicio 2
 Implementa un algoritmo que, dado un vector ordenado salvo en una de sus posiciones, que
 puede ser cualquiera de ellas, devuelva el número de la posición donde se encuentra la
 posición no ordenada.
 Ejemplos:
 7 3 4 5 10 12 22 36 41 48 57 (posición cero, la primera posición del vector)
 1 3 4 5 10 12 22 13 41 48 57 (octava posición del vector)
 1 3 4 5 10 12 22 36 41 48 21 (undécima posición del vector)*/

public class Hoja4E2 {

	public static int buscarDesordenado(int v[], int inicio, int fin) {
		if (inicio == fin) {
			return -1;
		} else if (inicio + 1 == fin) { // Vector de dos posiciones
			if (v[fin] < v[inicio]) {
				return fin;
			} else {
				return -1;
			}
		} else {
			int mitad = (inicio + fin) / 2;
			if (v[mitad] > v[mitad + 1]) {
				return mitad + 1;
			} else if (v[mitad] < v[mitad - 1]) {
				return mitad;
			} else {
				int posicion = buscarDesordenado(v, inicio, mitad - 1);
				if (posicion == -1) {
					posicion = buscarDesordenado(v, mitad + 1, fin);
				}
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		int arrayEntrada[] = { 2, 4, 6, 8, 9,11,12}; 
		int posicion = buscarDesordenado(arrayEntrada, 0,
				arrayEntrada.length - 1);
		System.out.println("Elemento desordenado esta en la posicion: " + posicion);

	}
}
