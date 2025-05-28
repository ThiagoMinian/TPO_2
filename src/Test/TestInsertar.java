package Test;

import Modelo.ArbolPersonas;
import Interfaces.IArbolPersonas;
import Interfaces.INodo;
import Interfaces.IPersona;
import Modelo.Persona;
public class TestInsertar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IArbolPersonas ab = new ArbolPersonas();
		IPersona p1 = new Persona("Juan", 1234);
		IPersona p2 = new Persona("Ana", 5555);
		IPersona p3 = new Persona("Juan", 4567);
		ab.insertar(p1);
		ab.insertar(p2);
		ab.insertar(p3);
		ab.insertar(p1);
		
          // duplicado exacto, debería rechazarl
	
        mostrarInorden(ab.getRaiz());
    }

    public static void mostrarInorden(INodo nodo) {
        if (nodo != null) {
            mostrarInorden(nodo.getIzquierdo());
            System.out.print(nodo.getDato());
            mostrarInorden(nodo.getDerecho());
        }
    }

}

