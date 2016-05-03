package mochilabt;

/*********************************************************************
Nombre: 
Expediente/titulacion: 
Nombre:
Expediente/titulacion: 
Nombre:
Expediente/titulacion: 
*********************************************************************/

public class Mochila
{
	Objeto[] objetos = new Objeto[0];	// Objetos contenidos en esta Mochila
	
	int capacidad;	// Maxima cantidad de objetos que admite. Mentira, es peso maximo
	
        int tope;
	// rellenar por el alumno
        public Mochila (int capacidad) {
            this.capacidad = capacidad;
            this.objetos = new Objeto [capacidad];
            this.tope = -1;
        }
        public Objeto getObjeto (int index) {
            return objetos [index];
        }
        public void addObjeto (Objeto o) {
            tope = tope +1;
            objetos [tope] = o;
        }
        public void quitarObjeto () {
            //objetos[tope] = null;
            tope = tope - 1;
        }
        public int getNumObjetos () {
            return this.tope+1;
        }
        public int sumapesos () {
            int acu = 0;
            for (int i=0; i<=tope; i++) {
                acu = acu + this.objetos[i].getPeso();
            }
            return acu;
        }
        public void imprimir () {
            System.out.println ("VOLCADO DE MOCHILA: "+ this.sumapesos() + "contiene num objetos: "+ this.tope);
            for (int i=0; i<=tope; i++) {
                System.out.println ("Peso: "+ this.objetos[i].getPeso());
                System.out.println ("Beneficio: "+ this.objetos[i].getBeneficio());
            }
            System.out.println ("******************");
        }
}