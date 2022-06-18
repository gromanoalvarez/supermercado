package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestSupermercado {

		
		@Test
		public void queSePuedaCrearUnSupermercado() {
			Supermercado argenchino = new Supermercado("Argenchino");
			assertNotNull(argenchino);
		}
		
		@Test 
		public void queElSupermercadoPuedaTenerCarritoDeCompras() {
			Supermercado argenchino = new Supermercado("Argenchino");
			Integer CANTIDAD_DE_CARRITOS_ESPERADOS=1;
			argenchino.registrarNuevoCarrito();
		
			assertEquals(CANTIDAD_DE_CARRITOS_ESPERADOS, (Integer)argenchino.getCarritosDisponibles().size());
		}
		
		@Test
		public void queSePuedaAgregarUnProductoAlCarrito() {
			Supermercado argenchino = new Supermercado("Argenchino");
			Integer CANTIDAD_DE_PRODUCTO_EN_CARRITO_ESPERADOS=1;
			argenchino.registrarNuevoCarrito();
			
			Producto leche =  new Leche();
			Carrito carritoAUsar = argenchino.tomarUnCarrito();
			carritoAUsar.agregarProducto(leche);
			
			assertEquals(CANTIDAD_DE_PRODUCTO_EN_CARRITO_ESPERADOS, (Integer)carritoAUsar.getProductosCargados().size());			
		}
		
		@Test
		public void queSePuedaAgregarMuchosDeUnProductoDeMismoTipoAlCarrito() {
			Supermercado argenchino = new Supermercado("Argenchino");
			Integer CANTIDAD_DE_PRODUCTO_EN_CARRITO_ESPERADOS=3;
			argenchino.registrarNuevoCarrito();
			
			Producto leche = new Leche();
			Producto leche2 = new Leche();
			Producto leche3 = new Leche();

			Carrito carritoAUsar = argenchino.tomarUnCarrito();
			carritoAUsar.agregarProducto(leche);
			carritoAUsar.agregarProducto(leche2);
			carritoAUsar.agregarProducto(leche3);

			assertEquals(CANTIDAD_DE_PRODUCTO_EN_CARRITO_ESPERADOS, (Integer)carritoAUsar.getProductosCargados().size());			
		}
		
		@Test
		public void queSePuedaConocerCantidadDeProductosDeMismoTipo() {
			Supermercado argenchino = new Supermercado("Argenchino");
			Integer CANTIDAD_DE_PRODUCTO_EN_TOTAL_CARRITO_ESPERADOS=4, CANTIDAD_DE_PRODUCTOS_REPETIDOS_ESPERADOS = 3;
			argenchino.registrarNuevoCarrito();
			
			Producto leche = new Leche();
			Producto leche2 = new Leche();
			Producto leche3 = new Leche();
			Producto harina = new Harina();

			Carrito carritoAUsar = argenchino.tomarUnCarrito();
			carritoAUsar.agregarProducto(leche);
			carritoAUsar.agregarProducto(leche2);
			carritoAUsar.agregarProducto(leche3);
			carritoAUsar.agregarProducto(harina);
			argenchino.hacerTicket(carritoAUsar);

			assertEquals(CANTIDAD_DE_PRODUCTO_EN_TOTAL_CARRITO_ESPERADOS, (Integer)carritoAUsar.getProductosCargados().size());
			assertEquals(CANTIDAD_DE_PRODUCTOS_REPETIDOS_ESPERADOS, carritoAUsar.getTipoLeche());
		}
		
		@Test
		public void queSiLaCompraTieneMenosDeVeinteProductosNoHayaDescuento() {
			
		}
		
		@Test
		public void queSiLaCompraTieneMasDeVeinteProductosHayaDescuento() {
			
		}

}
