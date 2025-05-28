package Test;

import Interfaces.IArbolPersonas;
import Interfaces.IPersona;
import Modelo.ArbolPersonas;
import Modelo.Persona;

public class TestBuscar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IArbolPersonas ab = new ArbolPersonas();
		IPersona p1 = new Persona("Juan", 1234);
		IPersona p2 = new Persona("Ana", 5555);
		IPersona p3 = new Persona("German", 4677);
		ab.insertar(p1);
		ab.insertar(p2);
		
		ab.buscar(p1);
		ab.buscar(p2);
		ab.buscar(p3);
		
	}

}

