package VueltaAtras;


public class Ordenar {
	
	
	public static boolean esFactible (int v[], int solucion[], int etapa, int intento, boolean usados[]){
		if (etapa==0)
			return true;
		else {
			if (solucion[etapa-1]>v[intento]) 
				return false;
			if (usados[intento])
				return false;
			
			return true;
		}
	}
	
	public static boolean ordenarAux(int v[], int solucion[], int etapa, boolean usados[]) {
		boolean exito = false;
		for (int intento=0; intento<v.length && !exito; intento++) {
			if (esFactible (v,solucion, etapa, intento, usados)) {
				solucion[etapa] = v[intento];
				usados[intento] = true;
				if (etapa==v.length-1) {
					exito = true;
				}else {
					exito = ordenarAux (v, solucion, etapa+1, usados);
					if (!exito) {
						solucion[etapa] = -1;
						usados[intento] = false;
					}
				}
			}
		}
		return exito;
	}
	public static int [] ordenar (int v[]) {
		int solucion[] = new int [v.length];
		boolean usados[] = new boolean [v.length];
		
		ordenarAux (v, solucion, 0, usados);
		
		return solucion;
	}
	public static void main (String args[]) {
		int v [] = {1,3,-5,-7,9,2};
		int ordenado[];
		
		ordenado = ordenar (v);
		
		for (int i=0; i< ordenado.length; i++)  {
			System.out.println (ordenado[i]+" ");
		}
	}
}
