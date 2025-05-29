package Test;

import Modelo.ArbolPersonas;
import Modelo.Persona;

public class TestOrders {
    public static void main(String[] args) {
        ArbolPersonas arbol = new ArbolPersonas();

        // Insertamos personas con diferentes nombres y dni
        arbol.insertar(new Persona("Juan", 123));
        arbol.insertar(new Persona("Ana", 456));
        arbol.insertar(new Persona("Luis", 111));
        arbol.insertar(new Persona("Ana", 222)); // mismo nombre, diferente DNI
        arbol.insertar(new Persona("Zoe", 789));
        arbol.insertar(new Persona("Carlos", 321));

        // Pruebas de recorrido
        System.out.println("=== INORDEN ===");
        arbol.inOrden();

        System.out.println("\n=== PREORDEN ===");
        arbol.preOrden();

        System.out.println("\n=== POSTORDEN ===");
        arbol.postOrden();
    }
}
