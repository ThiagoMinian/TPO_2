package Modelo;

import Interfaces.INodo;
import Interfaces.IPersona;

public class Nodo implements INodo{

	private IPersona dato;
	private INodo derecho;
	private INodo izquierdo;

	public IPersona getDato() {
		return dato;
	}

	public void setDato(IPersona dato) {
		this.dato = dato;
	}

	public INodo getDerecho() {
		return derecho;
	}

	public void setDerecho(INodo derecho) {
		this.derecho = derecho;
	}

	public INodo getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(INodo izquierdo) {
		this.izquierdo = izquierdo;
	}

	public Nodo() {
		super();
		this.dato = null;
		this.derecho = null;
		this.izquierdo = null;

	}

	public Nodo(IPersona dato) {
		super();
		this.dato = dato;
		this.derecho = null;
		this.izquierdo = null;
	}

	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", derecho=" + derecho + ", izquierdo=" + izquierdo + "]";

	}
}

