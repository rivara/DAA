
package DivideYVenceras;



public class solucion_sumativa_restativa {
	public static char analizarMatriz (int[][] m) {
		return analizarDyV (m, 0, m.length-1, 0, m[0].length-1);
	}
	private static char analizarDyV (int[][] m,
									 int filaInf, int filaSup,
										int colInf, int colSup) {
		if (filaInf==filaSup && colInf==colSup) {
			if (colInf==0 && colSup==0)
				return '0';
			else if (m[filaInf][colInf]==filaInf+colInf)
				return 's';
			else if (m[filaInf][colInf]==filaInf-colInf)
				return 'r';
			else
				return 'n';
		}
		else if (filaInf==filaSup) {
			int colMedia = (colInf+colSup) / 2;
			char r1 = analizarDyV (m, filaInf, filaSup, colInf,colMedia);
			char r2 = analizarDyV (m, filaInf, filaSup, colMedia+1, colSup);
			return (r1=='0' ? r2 : (r1==r2) ? r1 : 'n');
		}
		else if (colInf==colSup) {
			int filaMedia = (filaInf+filaSup) / 2;
			char r1 = analizarDyV (m, filaInf, filaMedia, colInf, colSup);
			char r2 = analizarDyV (m, filaMedia+1, filaSup, colInf, colSup);
			return (r1=='0' ? r2 : (r1==r2) ? r1 : 'n');
		}
		else {
			int filaMedia = (filaInf+filaSup) / 2;
			int colMedia = (colInf+colSup) / 2;
			char r1 = analizarDyV (m, filaInf, filaMedia,colInf, colMedia);
			char r2 = analizarDyV (m, filaInf, filaMedia,colMedia+1, colSup);
			char r3 = analizarDyV (m, filaMedia+1, filaSup,colInf, colMedia);
			char r4 = analizarDyV (m, filaMedia+1, filaSup,colMedia+1, colSup);
			return ((r1==r2) && (r1==r3) && (r1==r4)? r1 : 'n');
		}
	}
	
public static void main(String args[]){
	int [][] tabla1= {{1,2,3,4},{1,2,3,4}};
	analizarMatriz(tabla1);
}



}