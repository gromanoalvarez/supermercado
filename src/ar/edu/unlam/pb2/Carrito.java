package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;

public class Carrito {
	
	private Integer capacidadEnkilos;
	private Integer numeracion = 0;
	private boolean estaDisponible;
	private ArrayList<Producto> productosCargados;
	
	private ArrayList<Producto> tipoLeche ;
	private ArrayList<Producto> tipoHarina ;
	private ArrayList<Producto> tipoManteca ;
	private ArrayList<Producto> tipoAzucar ;

	public Carrito () {
		this.capacidadEnkilos=100;
		numeracion++;
		estaDisponible=true;
		productosCargados= new ArrayList<Producto>();
		
		 tipoLeche = new ArrayList<>();
		 tipoHarina = new ArrayList<>();
		 tipoManteca = new ArrayList<>();
		 tipoAzucar = new ArrayList<>();
	}

	public Integer getCapacidadEnkilos() {
		return capacidadEnkilos;
	}

	public Integer getNumeracion() {
		return numeracion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeracion == null) ? 0 : numeracion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		if (numeracion == null) {
			if (other.numeracion != null)
				return false;
		} else if (!numeracion.equals(other.numeracion))
			return false;
		return true;
	}

	public boolean estaDisponible() {
		return estaDisponible;
	}

	public void cambiarDisponibilidad() {
		if(estaDisponible)estaDisponible=false;
		else {estaDisponible=true;}
	}

	public void agregarProducto(Producto productoSolicitado) {
		productosCargados.add(productoSolicitado);
	}

	public ArrayList<Producto> getProductosCargados() {
		return productosCargados;
	}

	public void getProductosDeMismoTipoCargados() {
		for(Producto p: productosCargados) {
			switch(p.getTipoDeProducto()) {
				case LECHE:	
					tipoLeche.add(p);
					break;
				case HARINA:	
					tipoHarina.add(p);
					break;
				case MANTECA:	
					tipoManteca.add(p);
					break;
				case AZUCAR:	
					tipoAzucar.add(p);
					break;
			}
		}
	}

	public ArrayList<Producto> getTipoLeche() {
		return tipoLeche;
	}

	public ArrayList<Producto> getTipoHarina() {
		return tipoHarina;
	}

	public ArrayList<Producto> getTipoManteca() {
		return tipoManteca;
	}

	public ArrayList<Producto> getTipoAzucar() {
		return tipoAzucar;
	}
	
	
	
	
	

}
