package Modelo;

import Interfaces.IPersona;

public class Persona implements IPersona{

	private int dni;
	private String nombre;

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona() {
		super();
		this.dni = 0;
		this.nombre = "";
	}

	public Persona(String nombre, int dni) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	public String toString() {
		return "Persona [Nombre=" + nombre + ", DNI=" + dni + "]";
	}
}

