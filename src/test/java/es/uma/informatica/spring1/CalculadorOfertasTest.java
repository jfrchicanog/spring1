package es.uma.informatica.spring1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;
import es.uma.informatica.spring1.domain.Producto;

public class CalculadorOfertasTest {
	
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}

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
		
		
		CalculadorOfertas calculador = context.getBean(CalculadorOfertas.class);
		
		calculador.calcularOfertas(factura);
		
		Assert.assertEquals(23.44, factura.getTotal(), 0.001);
		Assert.assertEquals(6, factura.getLineas().size());
		
	}

}
