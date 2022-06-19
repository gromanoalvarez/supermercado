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

	public final TipoDeProducto getTipoDeProducto() {
		return tipoDeProducto;
	}
	
	public final TipoDeVencimiento getVencimiento() {
		return tipoDeVencimiento;
	}
	
	public final Boolean getDescuento() {
		return descuento;
	}

	public abstract void establecerVencimiento();
	public abstract void establecerDescuento();

	@Override
	public String toString() {
		return "Producto [tipoDeProducto=" + tipoDeProducto + ", tipoDeVencimiento=" + tipoDeVencimiento
				+ ", descuento=" + descuento + "]";
	}
	
	
}
