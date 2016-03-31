//SIN VER
/*Supongamos que disponemos de n trabajadores y n tareas. Sea bij > 0 el coste de 
asignarle el trabajo j al trabajador i. Una asignación de tareas puede ser expresada 
como una asignación de los valores 0 ó 1 a las variables xij, donde 
xij = 0 significa que al trabajador i no le han asignado la tarea j, y xij = 1 indica que 
sí. Una asignación válida es aquella en la que a cada trabajador sólo le corresponde 
una tarea y cada tarea está asignada a un trabajador. Dada una asignación válida, 
definimos el coste de dicha asignación como: 

 Diremos que una asignación es óptima si es de mínimo coste. Cara a diseñar un 
algoritmo ávido para resolver este problema podemos pensar en dos estrategias 
distintas: asignar cada trabajador la mejor tarea posible, o bien asignar cada tarea al 
mejor trabajador disponible. Sin embargo, ninguna de las dos estrategias tiene por 
qué encontrar siempre soluciones óptimas. ¿Es alguna mejor que la otra?
 */

package Voraz;

/**
 *
 * @author jvergara
 */
public class PlanificacionTareas {

    /**
     * @param args the command line arguments
     */
    static final int NTRABAJADORES = 3;
    static final int NTAREAS = 3;
    static int [][] costes= {{16,20,28},{11,15,17},{17,1,20}};
    
    static boolean [][]asignacion = {{false,false,false},{false,false,false},{false,false,false}};
    
    public static boolean ocupado_trabajador ( boolean [][] asignacion, int trabajador) {
        for (int i = 0; i< NTAREAS; i++) {
            if (asignacion [trabajador][i])
                return true;
        }
        return false;
    }
    public static int MejorTrabajador (int [][]costes, boolean [][] asignacion, int tarea) {
        
        int min = 10000;
        int mejortrabajador = -1;
        for (int trabajador = 0; trabajador < NTRABAJADORES; trabajador++) {
            if ((ocupado_trabajador (asignacion, trabajador)==false) && (costes [trabajador][tarea]<min)) {
                min=costes [trabajador][tarea];
                mejortrabajador = trabajador;
            }
        }
        return mejortrabajador;
        
    }
    public static void Planificar (int [][]costes, boolean [][] asignacion) {
        for (int i = 0; i < NTAREAS; i++) { //Las columnas son las tareas y las filas los trabajadores
            //Hay que sacar el mejor trabajador para la tarea i
            asignacion[MejorTrabajador(costes,asignacion,i)] [i]=true;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Planificar (costes, asignacion);
        for (int i = 0; i< NTRABAJADORES; i++) {
            for (int j = 0; j < NTAREAS; j++) {
                if (asignacion[i][j]) {
                    System.out.println ("Trabajador: " + i+ " hara la tarea: "+j);
                }
            }
        }
        
    }
}
