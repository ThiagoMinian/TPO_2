package Test;

import Interfaces.IArbolPersonas;
import Interfaces.IPersona;
import Interfaces.INodo;
import Modelo.ArbolPersonas;
import Modelo.Persona;

public class TestEliminar {

    public static void main(String[] args) {
        IArbolPersonas ab = new ArbolPersonas();

        IPersona p1 = new Persona("Juan", 1234); 
        IPersona p2 = new Persona("Ana", 5555);  
        IPersona p3 = new Persona("Juan", 4567);  
        IPersona p4 = new Persona("Lucas", 1111);
        IPersona p5 = new Persona("Zoe", 9999);   

        ab.insertar(p1);
        ab.insertar(p2);
        ab.insertar(p3);
        ab.insertar(p4);
        ab.insertar(p5);

        System.out.println("Árbol original (inorden):");
        mostrarInorden(ab.getRaiz());
        System.out.println("");

        System.out.println("Eliminando nodo hoja (Zoe, 9999):");
        ab.eliminar(p5);
        mostrarInorden(ab.getRaiz());
        System.out.println("");

        System.out.println("Eliminando nodo con un hijo (Lucas, 1111):");
        ab.eliminar(p4);
        mostrarInorden(ab.getRaiz());
        System.out.println("");

        System.out.println("Eliminando nodo con dos hijos (Juan, 1234):");
        ab.eliminar(p1);
        mostrarInorden(ab.getRaiz());
        System.out.println("");

        System.out.println("Eliminando nodo inexistente (Pedro, 8888):");
        ab.eliminar(new Persona("Pedro", 8888));
        mostrarInorden(ab.getRaiz());
        System.out.println("");
    }

    public static void mostrarInorden(INodo nodo) {
        if (nodo != null) {
            mostrarInorden(nodo.getIzquierdo());
            System.out.println(nodo.getDato());
            mostrarInorden(nodo.getDerecho());
            System.out.println("");
        }
    }
}
