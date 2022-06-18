package ar.edu.unlam.pb2;

public abstract class Producto {
	
	protected TipoDeProducto tipoDeProducto;
	protected TipoDeVencimiento tipoDeVencimiento;
	protected Boolean descuento;
	
	public Producto() {
		tipoDeProducto=null;
		tipoDeVencimiento=null;
		descuento=false;
	}

	public Producto(TipoDeProducto tipoDeProducto) {
		this.tipoDeProducto=tipoDeProducto;
		tipoDeVencimiento=null;
		descuento=false;
	}

	public TipoDeProducto getTipoDeProducto() {
		return tipoDeProducto;
	}
	
	public TipoDeVencimiento getVencimiento() {
		return tipoDeVencimiento;
	}

	public abstract void establecerVencimiento();
	public abstract void establecerDescuento();
}
