package Modelo;

import Interfaces.IArbolPersonas;
import Interfaces.INodo;
import Interfaces.IPersona;

public class ArbolPersonas implements IArbolPersonas{

	private INodo raiz;

	public INodo getRaiz() {
		return raiz;
	}

	public void setRaiz(INodo raiz) {
		this.raiz = raiz;
	}

	public ArbolPersonas() {
		super();
		this.raiz = null;
	}

	public ArbolPersonas(INodo raiz) {
		super();
		this.raiz = raiz;

	}

	public String toString() {
		return "ArbolPersonas [raiz=" + raiz + "]";

	}

	public IPersona buscar(IPersona pers) {
			return buscarPorNombreDni(raiz, pers);
	}
	
	public void insertar(IPersona persona){
		  raiz = insertarRec(raiz, persona);
		}

	private INodo insertarRec(INodo nodo, IPersona pers){
		if (nodo == null){
		INodo personaNueva = new Nodo(pers);
		System.out.println(pers);
		System.out.println("Se ingreso correctamente");
		   return personaNueva;
	}
		
	int compNombre = pers.getNombre().compareTo(nodo.getDato().getNombre());
	
	if (compNombre < 0){
		  nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), pers));
		   
	} else if (compNombre > 0){
	   nodo.setDerecho(insertarRec(nodo.getDerecho(), pers));
	
	}else{
		//comparo por dni en caso de que el nombre sea igual
			
			int compDni = pers.getDni();
			
			if ( compDni < nodo.getDato().getDni()){
				nodo.setIzquierdo(insertarRec( nodo.getIzquierdo(),pers));

			}else if ( compDni > nodo.getDato().getDni()){
				nodo.setDerecho(insertarRec( nodo.getDerecho(),pers));
			}else{
				System.out.println("Esta persona ya fué ingresada");
			}
    }
	return nodo;
	}
		  
	
	private IPersona buscarPorNombreDni(INodo nodo, IPersona pers){
		if (nodo==null) {
			System.out.println("--Dato no encontrado--");
			return null;
		}
		
		int dniNodo = nodo.getDato().getDni();
		int compNombre = pers.getNombre().compareTo(nodo.getDato().getNombre());
		
		if (compNombre==0) {
			if (pers.getDni()==dniNodo) {
				System.out.println("ENCONTRADO ---> " + pers.getNombre() + ", " + pers.getDni());
				return nodo.getDato();
			}
			else if (pers.getDni()<dniNodo) {
				return buscarPorNombreDni(nodo.getIzquierdo(), pers);
			}
			else {
				return buscarPorNombreDni(nodo.getDerecho(), pers);
			}
		}
		else if (compNombre<0){
			return buscarPorNombreDni(nodo.getIzquierdo(), pers);			
		}
		else {
			return buscarPorNombreDni(nodo.getDerecho(), pers);
		}
		
	}
	
	
	private INodo eliminarRec(INodo nodo, IPersona persona) {
	    if (nodo == null) {
	        System.out.println("Dato no encontrado para eliminar");
	        return null;
	    }

	    int compNombre = persona.getNombre().compareTo(nodo.getDato().getNombre());

	    if (compNombre < 0) {
	        nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), persona));
	    } else if (compNombre > 0) {
	        nodo.setDerecho(eliminarRec(nodo.getDerecho(), persona));
	    } else {
	        int compDni = persona.getDni();
	        if (compDni < nodo.getDato().getDni()) {
	            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), persona));
	        } else if (compDni > nodo.getDato().getDni()) {
	            nodo.setDerecho(eliminarRec(nodo.getDerecho(), persona));
	        } else {
	            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
	                return null;
	            }
	            else if (nodo.getIzquierdo() == null) {
	                return nodo.getDerecho();
	            } else if (nodo.getDerecho() == null) {
	                return nodo.getIzquierdo();
	            }
	            else {
	                INodo sucesor = obtenerMinimo(nodo.getDerecho());
	                nodo.setDato(sucesor.getDato());
	                nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getDato()));
	            }
	        }
	    }

	    return nodo;
	}
	
	private INodo obtenerMinimo(INodo nodo) {
	    while (nodo.getIzquierdo() != null) {
	        nodo = nodo.getIzquierdo();
	    }
	    return nodo;
	}


	public void eliminar(IPersona persona) {
	    raiz = eliminarRec(raiz, persona);
	}
	
	public void inOrden() {
	    System.out.println("Recorrido InOrden:");
	    inOrdenRec(raiz);
	    System.out.println();
	}

	public void preOrden() {
	    System.out.println("Recorrido PreOrden:");
	    preOrdenRec(raiz);
	    System.out.println();
	}

	public void postOrden() {
	    System.out.println("Recorrido PostOrden:");
	    postOrdenRec(raiz);
	    System.out.println();
	}
	
	private void inOrdenRec(INodo nodo) {
	    if (nodo != null) {
	        inOrdenRec(nodo.getIzquierdo());
	        System.out.print(nodo.getDato() + " ");
	        inOrdenRec(nodo.getDerecho());
	    }
	}

	private void preOrdenRec(INodo nodo) {
	    if (nodo != null) {
	        System.out.print(nodo.getDato() + " ");
	        preOrdenRec(nodo.getIzquierdo());
	        preOrdenRec(nodo.getDerecho());
	    }
	}

	private void postOrdenRec(INodo nodo) {
	    if (nodo != null) {
	        postOrdenRec(nodo.getIzquierdo());
	        postOrdenRec(nodo.getDerecho());
	        System.out.print(nodo.getDato() + " ");
	    }
	}


	


}

