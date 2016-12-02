package es.uma.informatica.spring1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;
import es.uma.informatica.spring1.domain.Producto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CalculadorOfertasTest {
	
	@Autowired
	private CalculadorOfertas calculador;

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
		ofertas.add(new Oferta3x2());
		ofertas.add(new Descuento20Porciento("Queso"));
		
		calculador.setOfertas(ofertas);
		
		calculador.calcularOfertas(factura);
		
		Assert.assertEquals(23.44, factura.getTotal(), 0.001);
		Assert.assertEquals(6, factura.getLineas().size());
		
	}

}
