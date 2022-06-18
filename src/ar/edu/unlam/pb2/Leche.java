package ar.edu.unlam.pb2;

public class Leche extends Producto{

	public Leche() {
		super();
		tipoDeProducto=TipoDeProducto.LECHE;
	}

	@Override
	public void establecerVencimiento() {
		super.tipoDeVencimiento= TipoDeVencimiento.CORTO;
	}
	
	@Override
	public void establecerDescuento() {
		super.descuento= true;
	}


}
