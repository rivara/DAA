package DivideYVenceras;
/*Ejercicio 3
Se dice que una celda mij de una matriz es sumativa si mij = i + j ; también se dice que dicha
celda es restativa si mij = i j
. Por extensión, se dice que una matriz es sumativa si todas sus
celdas son sumativas y que una matriz es restativa si todas sus celdas son restativas.

Una matriz que no es sumativa ni restativa es neutra . La matriz no tiene porqué ser cuadrada.
Se desea diseñar un algoritmo que determine si una matriz es sumativa, restativa o neutra.
Por sencillez, debe usarse la siguiente cabecera:
public static char analizarMatriz (int[][] m)
donde una matriz sumativa puede representarse con el carácter  s , una restativa con  r  y
una neutra con  n 
             a) Resuelva el problema mediante un algoritmo de divide y vencerás .
             b) Calcule razonadamente su función de tiempo, expresándola mediante alguna
               notación asintótica. Por sencillez, el análisis puede suponer que la matriz es
               cuadrada.
  */

public class Hoja4E3 {


	private static char analizarDyV(int[][] m, int filaInf, int filaSup,
			int colInf, int colSup) {
		if (filaInf == filaSup && colInf == colSup) {
			if (colInf == 0 && colSup == 0)
				return '0';
			else if (m[filaInf][colInf] == filaInf + colInf){
				System.out.println('s');
				return 's';
			}
			else if (m[filaInf][colInf] == filaInf - colInf)
				return 'r';
			else
				return 'n';
		} else if (filaInf == filaSup) {
			int colMedia = (colInf + colSup) / 2;
			char r1 = analizarDyV(m, filaInf, filaSup, colInf, colMedia);
			char r2 = analizarDyV(m, filaInf, filaSup, colMedia + 1, colSup);
			return (r1 == '0' ? r2 : (r1 == r2) ? r1 : 'n');
		} else if (colInf == colSup) {
			int filaMedia = (filaInf + filaSup) / 2;
			char r1 = analizarDyV(m, filaInf, filaMedia, colInf, colSup);
			char r2 = analizarDyV(m, filaMedia + 1, filaSup, colInf, colSup);
			return (r1 == '0' ? r2 : (r1 == r2) ? r1 : 'n');
		} else {
			int filaMedia = (filaInf + filaSup) / 2;
			int colMedia = (colInf + colSup) / 2;
			char r1 = analizarDyV(m, filaInf, filaMedia, colInf, colMedia);
			char r2 = analizarDyV(m, filaInf, filaMedia, colMedia + 1, colSup);
			char r3 = analizarDyV(m, filaMedia + 1, filaSup, colInf, colMedia);
			char r4 = analizarDyV(m, filaMedia + 1, filaSup, colMedia + 1,
					colSup);
			return ((r1 == r2) && (r1 == r3) && (r1 == r4) ? r1 : 'n');
		}
	}
	public static char analizarMatriz(int[][] m) {
		return analizarDyV(m, 0, m.length - 1, 0, m[0].length - 1);
	}

	public static void main(String[] args) {

	    int arrayEntrada[][]={{0,1,2},{1,2,3}}; //Este es el array de elementos 
		//int arrayEntrada[][] = { { 0, -1, -2 }, { 1, 0, -1 } };
		char r = analizarMatriz(arrayEntrada);
		System.out.println("Tipo: " + r);
	

	}

}
