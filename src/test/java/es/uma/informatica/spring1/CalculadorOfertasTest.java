package es.uma.informatica.spring1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;
import es.uma.informatica.spring1.domain.Producto;

public class CalculadorOfertasTest {
	
	private ApplicationContext context;
	
	@Before
	public void setup() {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}

	@Test
	public void test() {
		
		Factura factura = context.getBean(Factura.class);
		CalculadorOfertas calculador = context.getBean(CalculadorOfertas.class);
		
		calculador.calcularOfertas(factura);
		
		Assert.assertEquals(23.44, factura.getTotal(), 0.001);
		Assert.assertEquals(6, factura.getLineas().size());
		
	}

}
