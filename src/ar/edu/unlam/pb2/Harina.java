package ar.edu.unlam.pb2;

public class Harina extends Producto{

	public Harina() {
		super();
		tipoDeProducto=TipoDeProducto.HARINA;
	}

	@Override
	public void establecerVencimiento() {
		super.tipoDeVencimiento= TipoDeVencimiento.LARGO;
	}
	
	@Override
	public void establecerDescuento() {
		super.descuento= false;
	}
}
