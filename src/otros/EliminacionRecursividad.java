package otros;
public class EliminacionRecursividad {
	
	public static int logEnteroRec (int b, int n) {
		if (n<b)
			return 0;
		else
			return 1+logEnteroRec(b,n/b);
	}
	
	//Función hecha segun regla general. Tenemos un problema porque D<y> es una operación que no es igual a su inversa trabajando con enteros.
	//Mejor usamos otro método
	public static int logEnteroIter (int b, int n) {
		int y = n;
		while (y>=b) {
			y = y/b;
		}
		int z = 0;

		while (y!=n) {
			y = y * b;
			z = z +1;
		}
		return z;
	}
	//Cumple la propiedad pseudocomutativa la operación de +1
	public static int logEnteroIter2 (int b, int n) {
		int y = n;
		int z = 0;
		while (y>=b) {
			z = z + 1;
			y = y / b;
		}
		return z;
	}
	
	public static int buscarRec (int e, int[] v) {
		return busquedaBin (e, v, 0, v.length-1);
	}
	private static int busquedaBin (int e, int[] v, int inf, int sup) {
		if (inf==sup)
			return (e==v[sup]?sup:-1);
		else {
			int med = (inf+sup) / 2;
			if (e>v[med])
				return busquedaBin (e, v, med+1, sup);
			else
				return busquedaBin (e, v, inf, med);
		}
	}
	//Como se trata de un algoritmo de recursividad final, eliminamos directamente el segundo bucle de la regla general
	public static int buscarIte (int e, int[] v) {
		int inf = 0;
		int sup = v.length-1;
		
		while (inf!=sup) {
			int med = (inf+sup) / 2;
			if (e>v[med]) {
				inf = med+1;
			}else {
				sup = med;
			}
		}
		int z = (e==v[sup]?sup:-1);
		
		return z;
		
	}
	public static void main (String args[]) {
		System.out.println ("Empezando la practica");
		System.out.println ("Logaritmo Recursivo: (2,8): "+logEnteroRec (2,8));
		System.out.println ("Logaritmo Iterativo: (2,8): "+logEnteroIter2 (2,8));
		System.out.println ("Logaritmo Recursivo: (2,9): "+logEnteroRec (2,9));
		System.out.println ("Logaritmo Iterativo: (2,9): "+logEnteroIter2 (2,9));
		
		int v [] = {1,2,3,6,7,9};
		
		System.out.println ("Bus Binaria Recursivo: 3: "+buscarRec (3,v));
		System.out.println ("Bus Binaria Iterativo: 3: "+buscarIte (3,v));
		System.out.println ("Bus Binaria Recursivo: 8: "+buscarRec (8,v));
		System.out.println ("Bus Binaria Iterativo: 8: "+buscarIte (8,v));
		
		
		
	}
}
