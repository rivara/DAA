

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {
	public static boolean es_factible(int solucion_parcial[], int intento,
			int hasta) {
		for (int i = 0; i <= hasta; i++) {
			if (solucion_parcial[i] == intento)
				return false;
		}
		return true;
	}

/*	public static ArrayList<Nodo> getComplecciones(Nodo padre, int n, int m) {
		ArrayList<Nodo> hijos = new ArrayList<Nodo>();

		for (int operario = 0; operario < m; operario++) {
			int datos_costes[][] = new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					datos_costes[i][j] = padre.datos_costes[i][j];
				}
			}

			Nodo nuevo = new Nodo(padre.n, padre.m, datos_costes);
			CopiarSolucion(padre.solucion, nuevo.solucion);

			nuevo.etapa = padre.etapa + 1;
			if (es_factible(nuevo.solucion, operario, nuevo.etapa - 1)) {
				nuevo.solucion[nuevo.etapa] = operario;
				nuevo.setCota();
				hijos.add(nuevo);
			}
		}
		return hijos;
	}

	public static void main(String args[]) {
		int n = 4, m = 4;
		int datos_costes[][] = { { 20, 3, 4, 5 }, { 5, 20, 3, 4 },
				{ 4, 3, 4, 5 }, { 4, 3, 2, 3 } };

		int solucion_mejor[] = new int[4];

		int cota_superior = 0;

		for (int i = 0; i < n; i++) {
			solucion_mejor[i] = i;
			cota_superior = cota_superior + datos_costes[solucion_mejor[i]][i];
		}
		System.out.println("Coste inicial: " + cota_superior);
		System.out.println("Solucion inicial");
		imprimir_solucion(solucion_mejor);

		ArrayList<Nodo> lista = new ArrayList<Nodo>();
		Nodo nodo = new Nodo(n, m, datos_costes);
		nodo.setCota();
		System.out.println("Cota al empezar: " + nodo.cota);
		lista.add(nodo);

		while (!lista.isEmpty()) {

			Nodo mas_prometedor = lista.remove(0);

			// Sacamos los nodos hijos
			ArrayList<Nodo> complecciones = getComplecciones(mas_prometedor, n,
					m);
			for (Nodo hijo : complecciones) {
				if (hijo.etapa == n - 1) {
					System.out.println("Solucion nueva con coste: " + hijo.cota
							+ " y tenemos otra con coste" + cota_superior);
					if (hijo.cota < cota_superior) {
						System.out
								.println("Actualizamos solucion por otra mejor, con mas beneficio");
						imprimir_solucion(hijo.solucion);
						// Tenemos un hijo solucion, actualizamos
						CopiarSolucion(hijo.solucion, solucion_mejor);
						// Actualizamos la cota
						cota_superior = hijo.cota;
					}
				} else if (hijo.cota < cota_superior) {
					lista.add(hijo);
				} else {
					System.out.println("Nodo rechazado, cota: " + hijo.cota
							+ " y cota superior: " + cota_superior);
				}
			}

			Collections.sort(lista);
		}

		imprimir_solucion(solucion_mejor);
	}

	public static void CopiarSolucion(int[] origen, int[] destino) {
		for (int i = 0; i < origen.length; i++) {
			destino[i] = origen[i];
		}
	}

	public static void imprimir_solucion(int solucion[]) {
		for (int i = 0; i < solucion.length; i++) {
			System.out.println("Tarea tipo " + i + " la hace: " + solucion[i]);
		}
	}
}
*/