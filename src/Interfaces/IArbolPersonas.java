package Interfaces;

public interface IArbolPersonas {
	
	public INodo getRaiz();
	public void setRaiz(INodo raiz);
	public String toString();
	public void insertar(IPersona persona);
	public IPersona buscar(IPersona persona);
	public void eliminar(IPersona persona);
	

}
