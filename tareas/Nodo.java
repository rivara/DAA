
public class Nodo implements Comparable {
	int n = 0, m = 0;
	int datos_costes[][] = null;
	int solucion[] = null;
	int cota = 0;
	int etapa = -1;

	Nodo(int n, int m, int datos_costes[][]) {
		this.n = n;
		this.m = m;
		this.datos_costes = datos_costes;
		this.solucion = new int[n];
	}

	public int dame_operario(int datos_costes[][], int tipo_tarea) {
		int mejor_operario = 0;
		for (int i = 0; i < n; i++) {
			if (datos_costes[i][tipo_tarea] < datos_costes[mejor_operario][tipo_tarea]) {
				mejor_operario = i;
			}
		}
		return mejor_operario;
	}

	public void setCota() {
		int coste = 0;

		// Calculamos real
		for (int i = 0; i <= etapa; i++) {
			coste = coste + datos_costes[solucion[i]][i];
		}

		for (int i = etapa + 1; i < n; i++) {

			int mejor_para_esa_tarea = dame_operario(datos_costes, i);
			// System.out.println
			// ("Mejor para la tarea: "+i+" es "+mejor_para_esa_tarea);
			coste = coste + datos_costes[mejor_para_esa_tarea][i];
		}

		this.cota = coste;
	}

	@Override
	public int compareTo(Object o) {
		Nodo otroNodo = (Nodo) o;
		if (this.cota < otroNodo.cota)
			return 1;
		else if (this.cota > otroNodo.cota)
			return -1;
		else
			return 0;
	}

}
