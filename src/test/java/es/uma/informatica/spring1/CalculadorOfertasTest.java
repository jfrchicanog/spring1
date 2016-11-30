package es.uma.informatica.spring1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;
import es.uma.informatica.spring1.domain.Producto;

public class CalculadorOfertasTest {

	@Test
	public void test() {
		
		List<LineaFactura> lineas = new ArrayList<>();
		
		Producto producto = new Producto();
		producto.setNombre("Leche");
		producto.setPrecio(1.50);
		
		LineaFactura linea = new LineaFactura();
		linea.setProducto(producto);
		linea.setCantidad(6);
		
		lineas.add(linea);
		
		producto = new Producto();
		producto.setNombre("Queso");
		producto.setPrecio(3.40);
		
		linea = new LineaFactura();
		linea.setProducto(producto);
		linea.setCantidad(2);
		
		lineas.add(linea);
		
		producto = new Producto();
		producto.setNombre("Atún");
		producto.setPrecio(3.00);
		
		linea = new LineaFactura();
		linea.setProducto(producto);
		linea.setCantidad(6);
		
		lineas.add(linea);
		
		Factura factura = new Factura();
		factura.setLineas(lineas);
		
		List<Oferta> ofertas = new ArrayList<>();
		ofertas.add(new Oferta3x2("Leche"));
		ofertas.add(new Descuento20Porciento("Atún"));
		
		CalculadorOfertas calculador = new CalculadorOfertas(ofertas);
		
		calculador.calcularOfertas(factura);
		
		Assert.assertEquals(27.20, factura.getTotal(), 0.001);
		Assert.assertEquals(5, factura.getLineas().size());
		
		System.out.println(factura.toString());
		
	}

}
