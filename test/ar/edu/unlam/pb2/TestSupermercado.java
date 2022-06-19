package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
			//Asignación Polimorfica
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
			//Asignación Polimorfica
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
			
			//Asignación Polimorfica
			Producto leche = new Leche();
			Producto harina = new Harina();
			Producto leche2 = new Leche();
			Producto leche3 = new Leche();


			Carrito carritoAUsar = argenchino.tomarUnCarrito();
			carritoAUsar.agregarProducto(leche);
			carritoAUsar.agregarProducto(leche2);
			carritoAUsar.agregarProducto(leche3);
			carritoAUsar.agregarProducto(harina);
			argenchino.hacerTicket(carritoAUsar);

			assertEquals(CANTIDAD_DE_PRODUCTO_EN_TOTAL_CARRITO_ESPERADOS, (Integer)carritoAUsar.getProductosCargados().size());
			assertEquals(CANTIDAD_DE_PRODUCTOS_REPETIDOS_ESPERADOS, (Integer)carritoAUsar.getTipoLeche().size());
		}
		
		@Test
		public void queSiLaCompraTieneMenosDeVeinteProductosNoHayaDescuento() {
			Integer CANTIDAD_DE_PRODUCTO_EN_TOTAL_CARRITO_ESPERADOS=19;
			Supermercado argenchino = new Supermercado("Argenchino");
			argenchino.registrarNuevoCarrito();
			Carrito carritoAUsar = argenchino.tomarUnCarrito();

			//Asignación Polimorfica
			for(int i=0;i<19;i++) {
				Producto leche = new Leche();
				carritoAUsar.agregarProducto(leche);
			}
			
			argenchino.hacerTicket(carritoAUsar);
			assertEquals(CANTIDAD_DE_PRODUCTO_EN_TOTAL_CARRITO_ESPERADOS, (Integer)carritoAUsar.getProductosCargados().size());
			assertFalse(carritoAUsar.getProductosCargados().get(1).getDescuento());
			
		}
		
		@Test
		public void queSiLaCompraTieneMasDeVeinteProductosHayaDescuento() {
			Integer CANTIDAD_DE_PRODUCTO_EN_TOTAL_CARRITO_ESPERADOS=21;
			Supermercado argenchino = new Supermercado("Argenchino");
			argenchino.registrarNuevoCarrito();
			Carrito carritoAUsar = argenchino.tomarUnCarrito();

			for(int i=0;i<=20;i++) {
				Producto leche = new Leche();
				carritoAUsar.agregarProducto(leche);
			}
			
			argenchino.hacerTicket(carritoAUsar);
			assertEquals(CANTIDAD_DE_PRODUCTO_EN_TOTAL_CARRITO_ESPERADOS, (Integer)carritoAUsar.getProductosCargados().size());
			assertTrue(carritoAUsar.getProductosCargados().get(1).getDescuento());
			//HERENCIA
			//De un Leche "que es" un Producto accede a getDescuento declarado en Producto
			assertTrue(carritoAUsar.getTipoLeche().get(10).getDescuento());
		}

}
