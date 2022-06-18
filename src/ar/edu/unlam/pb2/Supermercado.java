package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.TreeMap;

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
	
	private void pasarProductosDelCarritoALaCaja(Carrito carrito) {
		carrito.getProductosDeMismoTipoCargados();
		if(carrito.getProductosCargados().size() > 20) {
			hacerDescuentoPorCompraMayorista(carrito);
		}
	}
	private void hacerDescuentoPorCompraMayorista(Carrito carrito) {
		for(Producto p: carrito.getProductosCargados()) {
			p.establecerDescuento();
		}
	}
	
	public TreeMap<TipoDeProducto, Integer> hacerTicket(Carrito carrito) {
		pasarProductosDelCarritoALaCaja(carrito);
		TreeMap<TipoDeProducto, Integer> ticket = new TreeMap<TipoDeProducto, Integer>(); 
		ticket.put(TipoDeProducto.AZUCAR,carrito.getTipoAzucar().size());
		ticket.put(TipoDeProducto.HARINA,carrito.getTipoHarina().size());
		ticket.put(TipoDeProducto.LECHE,carrito.getTipoLeche().size());
		ticket.put(TipoDeProducto.MANTECA,carrito.getTipoManteca().size());
		return ticket;
	}

}
