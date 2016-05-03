package mochilabt;


import java.util.Scanner;

/*********************************************************************
Nombre: 
Expediente/titulacion: 
Nombre:
Expediente/titulacion: 
Nombre:
Expediente/titulacion: 
*********************************************************************/


public class Algoritmo
{
	static Objeto[] o;
		
	
	// variable global donde la funci�n 'calcular' dejar� depositada la mochila con los objetos que componen el beneficio �ptimo
	static Mochila optima = null;		
	
	static int capacidad = 150; //Es el peso maximo de la mochila

	public static void main(String args[])
	{
		o=new Objeto[10];
		
		// El contenido de este array es modificable para poder probar distintos escenarios del problema
		o[0]=new Objeto(	50,	1000,	3);
		o[1]=new Objeto(	35,	700, 	7);
		o[2]=new Objeto(	78,	2000, 	1);
		o[3]=new Objeto(	58,	1400, 	4);
		o[4]=new Objeto(	28,	1100, 	2);
		o[5]=new Objeto(	32,	600, 	6);
		o[6]=new Objeto(	10,	350, 	3);
		o[7]=new Objeto(	9,	280, 	2);
		o[8]=new Objeto(	24,	650, 	2);
		o[9]=new Objeto(	80,	800, 	1);

		// Llamamos al algoritmo
                optima = new Mochila(capacidad);
		calcular (optima);
                   
                
                System.out.println ("Num de objetos despues de BT: "+ optima.getNumObjetos());
		// Variables para resultados
		int cargaTotal = 0;
		int gananciaTotal = 0;
	
		for (int i=0; i<optima.getNumObjetos(); i++)
		{
			System.out.println("El objeto " + i + " es de beneficio: " + optima.getObjeto(i).beneficio+ " peso: "+ optima.getObjeto(i).peso);
			
			cargaTotal += optima.getObjeto(i).getPeso();
			gananciaTotal += optima.getObjeto(i).getBeneficio();
		}
		System.out.println("En total, el tren lleva un total de:");
		System.out.println("  - Carga: " + cargaTotal);
		System.out.println("  - Ganancias: " + gananciaTotal);
	
	}
	
	public static void Ordenar(Objeto[] o) {
            Objeto aux;
            for (int i = 0; i < o.length - 1; i++) {
                for (int x = i + 1; x < o.length; x++) {
                    if (o[x].beneficio/o[x].peso < o[i].beneficio/o[i].peso) {
                        aux = o[i];
                        o[i] = o[x];
                        o[x] = aux;
                    }
                }
            }
        }
	public static void calcular (Mochila m)
	{
           Ordenar (o);
           calcularBT (m, 0);
	}
	
        public static boolean calcularBT (Mochila m, int etapa) { 
             
            boolean exito = false;

            //Scanner es = new Scanner (System.in);
            //es.nextLine();
            for (int i=0; i<=o[etapa].unidades && !exito; i++) {
                for (int j=0; j< i; j++) { //Seleccionar si i = 0 y no seleccionar si i = 1
                    m.addObjeto(o[etapa]);
                } 
              if (m.sumapesos() <= m.capacidad) { //Es factible este estado
                   if (m.sumapesos() ==  m.capacidad) {
                       exito = true;
                   }else if (etapa< o.length-1) {
                       exito = calcularBT (m, etapa+1);
                   }
                }
                if (!exito){
                    for (int j=0; j< i; j++) { //Seleccionar si i = 0 y no seleccionar si i = 1
                        m.quitarObjeto();
                    } 
                }
            }
            return exito;
        }
	
	
}