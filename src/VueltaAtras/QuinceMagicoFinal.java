package VueltaAtras;

public class QuinceMagicoFinal {

	public static void QuinceMagicoFinal() {
		int matriz[][] = new int[3][3];
		quinceMagicoAux(0, 0, matriz);

	}

	private static void quinceMagicoAux(int etapaX, int etapaY, int[][] tablero) {
		for (int intento = 1; intento <= 9; intento++) {
			tablero[etapaX][etapaY] = intento;
			if (esFactible(tablero, etapaX, etapaY)) {
				if ((etapaX == 2) && (etapaY == 2)) {
					imprimir(tablero);
				} else {
					int posSigX = DameSigX(etapaX, etapaY);
					int posSigY = DameSigY(etapaX, etapaY);
					quinceMagicoAux(posSigX, posSigY, tablero);
				}
			}
			tablero[etapaX][etapaY] = 0;
		}
	}

	private static boolean esFactible(int[][] tablero, int etapaX, int etapaY) {
		// fila conecta
		boolean on = true;
		boolean ok = true;
		int aux = 0;
		for (int columna = 0; columna <= etapaY; columna++) {
			aux = aux + tablero[etapaX][columna];
		}
		if (etapaY == 2) {
			ok = ok && (aux == 15);
		} else {
			ok = ok && (aux < 15);
		}
		// columna concreta
		aux = 0;
		for (int fila = 0; fila <= etapaX; fila++)
			aux = aux + tablero[fila][etapaY];

		// comprobar la diagonal principal
		aux = 0;
		for (int i = 0; i <= 2; i++)
			aux = aux + tablero[i][i];

		if ((etapaX == 2) && (etapaY == 2)) {
			ok = ok && (aux == 15);
		} else {
			if (etapaX == etapaY)
				ok = ok && (aux < 15);
		}
		return ok;

	}

	private static int DameSigY(int y, int x) {
		if (y == 2) {
			return x + 1;
		} else {
			return x;
		}
	}

	private static int DameSigX(int x, int y) {
		if (y == 2) {
			return 0;
		} else {
			return y + 1;
		}
	}

	private static void imprimir(int[][] tablero) {
		for (int y = 0; y <= 1; y++) {
			for (int x = 0; x <= 1; x++) {
				System.out.print(tablero[x][y]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		QuinceMagicoFinal();
	}
}
