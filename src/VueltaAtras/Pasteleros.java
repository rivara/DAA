package VueltaAtras;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Pasteleros {

	/**
	 * @param args
	 */
	
	public static int cota = 0;
	
	public static void main(String[] args) {
		int n=0, m=0;
		int datos_pasteleros [][] =null;
		int pasteles [] = null;
		
		int solucion_mejor [] = null;
		int solucion_parcial [] = null;
		
		
		//PASO 1: Leemos los datos del fichero de entrada
		File f = new File(args[0]);
		
    	BufferedReader entrada;
    	try {
    		entrada = new BufferedReader( new FileReader( f ) );
    		String linea = entrada.readLine();
    		String trozos[] = linea.split(" ");
    		n= Integer.parseInt (trozos[0]);
    		m= Integer.parseInt (trozos[1]);
    		datos_pasteleros = new int [n+1][m+1];
    		pasteles = new int [n+1];
    		solucion_mejor = new int [n+1];
    		solucion_parcial = new int [n+1];
    	    for (int i = 1; i<n+1; i++){
    			linea = entrada.readLine();
    			trozos = linea.split(" ");
                for (int j = 1; j< m+1; j++) {
                    datos_pasteleros[i][j] = Integer.parseInt(trozos[j-1]);
                    
                }
    		}
    	    linea = entrada.readLine();
    	    String aux[] = linea.split(" ");
    	    for (int i = 1; i<n+1; i++){
    	    	pasteles[i] = Integer.parseInt(aux[i-1]);
    	    }
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	//PASO 2: Selecccionamos una solucion valida pero que no tiene porque ser la mejor
    	//La usaremos como cota inicial. En nuestro caso tomamos un pastelero para hacer cada pastel secuencialmente
    	cota = 0;
    	
    	for (int i=1; i<n+1; i++) { //Son n pasteles
    		solucion_mejor [i] =  i; //El pastel i lo hace el pastelero i
    		cota = cota + datos_pasteleros [i][pasteles[i]]; //Sumamos el coste de que el pastelero i haga el pastel del tipo del pastel numero i
    	}
    	System.out.println ("Coste inicial: "+ cota);
    	System.out.println ("Solucion inicial");
    	imprimir_solucion (solucion_mejor, pasteles);
    	
    	int etapa = 1; //Asigna el primer pastel 
    	BT (datos_pasteleros,pasteles,solucion_mejor, etapa, solucion_parcial,n,m);
    	System.out.println ("***********************");
    	System.out.println ("Coste final: "+ cota);
    	System.out.println ("Solucion final");
    	imprimir_solucion (solucion_mejor, pasteles);
    	
	}
	public static boolean es_factible (int solucion_parcial [], int intento) {
		
		for (int i=1; i<solucion_parcial.length; i++) {
			if (solucion_parcial[i]==intento)
				return false;
		}
		return true;
	}
	public static int calcular_beneficio (int datos_pasteleros[][], int pasteles[], int solucion_parcial [], int etapa, int n, int m) {
		int coste = 0;
		for (int i=1; i<=etapa;i++) {
			coste = coste + datos_pasteleros[solucion_parcial[i]][pasteles[i]];
		}
		return coste;
	}
	public static void CopiarSolucion (int [] origen, int [] destino) {
		for (int i = 0; i< origen.length; i++){
			destino[i]=origen[i];
		}
	}
	public static int dame_mejor (int datos_pasteleros[][], int tipo_pastel,int n) {
		int mejor_pastelero = 1;
		for (int i=1; i<=n;i++) {
			if (datos_pasteleros[i][tipo_pastel]>datos_pasteleros[mejor_pastelero][tipo_pastel]) {
				mejor_pastelero = i;
			}
		}
		return mejor_pastelero;
	}
	public static int calcular_cota (int datos_pasteleros[][], int pasteles[], int solucion_parcial [], int etapa, int n, int m) {
		int coste = 0;
		
		//Calculamos real
		for (int i=1; i<=etapa;i++) {
			coste = coste + datos_pasteleros[solucion_parcial[i]][pasteles[i]];
		}
		//Calculamos lo que queda por asignar considerando algo muy muy bueno aunque sea imposible. Por ejemplo, asignar el mejor de los costes que la tabla
		//Cuando mas mejoremos la cota mejor sera nuestra poda
		//Es como calcula: Como mucho, a cuando de beneficio podría llegar esto
		for (int i=etapa+1; i<=n;i++) {
			//Dame el mejor pastelero para ese tipo de pastel, aunque este ocupado
			int mejor_para_ese_pastel = dame_mejor (datos_pasteleros, pasteles[i],n);
			coste = coste + datos_pasteleros[mejor_para_ese_pastel][pasteles[i]];
		}
		
		return coste;
	}
	public static void BT (int datos_pasteleros[][], int pasteles[], int solucion_mejor[], int etapa, 
								 int solucion_parcial [], int n, int m){
		for (int intento = 1; intento <=n; intento++) { //Podemos probar a que ese pastel lo haga cualquier pastelero
			if (es_factible (solucion_parcial, intento)) { //Miramos si en nuestra solucion no esta ya el pastelero ocupado
				//Marcamos 
				solucion_parcial [etapa] = intento;
				if (calcular_cota (datos_pasteleros, pasteles, solucion_parcial, etapa, n, m)>=cota) { //Si pasa la poda
					if (n==etapa) { //Es solucion y es mejor o igual, nos quedamos con ella y actualizamos cota
						//Si hacemos solucion_mejor = solucion_parcial no vale porque solo apuntamos referencias
						CopiarSolucion (solucion_parcial, solucion_mejor);
						cota = calcular_beneficio (datos_pasteleros, pasteles, solucion_parcial, etapa, n, m);
					}else {
						BT (datos_pasteleros,pasteles,solucion_mejor, etapa+1, solucion_parcial,n,m);
					}
				}
				//Desmarcamos 
				solucion_parcial [etapa] = 0;
			}
		}
		
	}
    
    
    
	public static void imprimir_solucion (int solucion[], int pasteles[]){
		for (int i = 1; i < pasteles.length; i++) {
			System.out.println ("Pastel numero "+i+" tipo: "+pasteles[i]+" asignado a "+solucion[i]);
		}
	}
	
	
}
