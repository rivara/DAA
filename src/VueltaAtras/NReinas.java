package VueltaAtras;




import java.util.Scanner;

/**
 *
 * @author jvergara
 */


public class NReinas {

    public static boolean es_factible (int intento, int paso, int solucion[]) {
    	
        for (int i = 0; i<=paso-1; i++) {
            if ((solucion[i]==solucion[paso]) || (Math.abs(solucion[i]-solucion[paso])==Math.abs(i-paso))){
        		return false;
            }
        }
        return true;
    }
            
    public static boolean ReinasN (int paso, int solucion [], int dimension) {
        Scanner leer = new Scanner(System.in);

        boolean exito=false;
        solucion[paso] = -1; //No esta colocada
        for (int intento=0; intento<dimension && !exito; intento++) {
            solucion [paso]= intento;
            if (es_factible (intento, paso, solucion)) {
                if (paso!=dimension-1) {
                   // imprimir (solucion);
                   // String linea = leer.nextLine();
                    exito=ReinasN (paso+1, solucion, dimension);
                }else {
                    exito=true;
                }
            }
        }
        return exito;
    }

    private static void imprimir (int[] v) {
        for (int i=0; i<v.length; i++)
            System.out.print (v[i]+" ");
        System.out.println();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int solucion [];
        Scanner leer = new Scanner(System.in);
        System.out.println("Dame la dimension del tablero MxM:");
        String linea = leer.nextLine();
        int dimension = Integer.parseInt(linea);
        
        solucion = new int[dimension];
        
       if (ReinasN (0, solucion, dimension)) {
           System.out.println("Tenemos solucion");
           imprimir (solucion);
       }else {
           System.out.println("No tenemos solucion");
       }
    }
}
