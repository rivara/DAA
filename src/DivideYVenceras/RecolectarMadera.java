/////////////////
//NO VISTO///////
/////////////////
package DivideYVenceras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class RecolectarMadera {

	public static long DyV(long[] alturas, int inicio, int fin, long k,
			long H_ini, long H_fin) {

		boolean exito = false;
		long H_nueva = 0;
		long madera = 0;
		do {
			H_nueva = (H_fin + H_ini) / 2;
			// Miramos cuanta madera sacamos
			madera = 0;
			for (int i = inicio; i <= fin; i++) {
				if (alturas[i] > H_nueva) {
					madera += alturas[i] - H_nueva;
				}
			}

			if (madera == k)
				exito = true;
			else if (madera > k) {
				// Podemos subir la H porque nos sobra
				H_ini = H_nueva + 1;
			} else {
				// La bajamos
				H_fin = H_nueva - 1;
			}

		} while ((H_ini <= H_fin) && (!exito));

		if (!exito) // Nos tenemos que pasar porque con uno menos no llegabamos
			H_nueva = H_fin;

		return H_nueva;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader cin = new BufferedReader(
				new InputStreamReader(System.in));
		long k = 0; // Peso de la madera a talar
		int n = 0; // Numero de arboles que hay
		try {
			String[] dosEnteros = cin.readLine().split(" ");
			n = Integer.parseInt(dosEnteros[0]);
			k = Long.parseLong(dosEnteros[1]);

			String[] trozos = cin.readLine().split(" ");
			long alturas_arboles[] = new long[n];
			int pos_mayor = 0;
			for (int i = 0; i < n; i++) {
				alturas_arboles[i] = Long.parseLong(trozos[i]);
				if (alturas_arboles[i] > alturas_arboles[pos_mayor]) {
					pos_mayor = i;
				}
			}

			long H = DyV(alturas_arboles, 0, n - 1, k, 0,
					alturas_arboles[pos_mayor]);

			System.out.println("La altura H sera: " + (long) H);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
