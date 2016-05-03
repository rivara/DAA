package mochilabt;

/*********************************************************************
Nombre: 
Expediente/titulacion: 
Nombre:
Expediente/titulacion: 
Nombre:
Expediente/titulacion: 
*********************************************************************/

public class Objeto
{
	int peso = 0;
	
	int beneficio = 0;
	
	int unidades = 0;
	
	// rellenar por el alumno
        public Objeto (int peso, int beneficio, int unidades) {
            this.peso = peso;
            this.beneficio = beneficio;
            this.unidades = unidades;
        }
        
        public int getBeneficio () {
            return beneficio;
        }
        public int getPeso () {
            return peso;
        }
}