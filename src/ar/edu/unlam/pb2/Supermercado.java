package ar.edu.unlam.pb2;

import java.util.HashSet;

public class Supermercado {
	private String nombre;
	private HashSet<Carrito> carritosDisponibles;
	
	public Supermercado(String nombre) {
		this.nombre=nombre;
		carritosDisponibles= new HashSet<Carrito>();
	}
	public void registrarNuevoCarrito() {
		Carrito carrito1 = new Carrito();
		carritosDisponibles.add(carrito1);
	}
	public HashSet<Carrito> getCarritosDisponibles() {
		return carritosDisponibles;
	}
	public Carrito tomarUnCarrito() {
		if(carritosDisponibles!=null) {
			for(Carrito c: carritosDisponibles) {
				if(c.estaDisponible()) {
					c.cambiarDisponibilidad();
					return c;
				}
			}
		}return null;
	}
	
	

}
