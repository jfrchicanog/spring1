package es.uma.informatica.spring1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.uma.informatica.spring1.domain.Factura;

public class CalculadorOfertasTest {
	private ApplicationContext context;
	
	@Before
	public void setup() {
		context = new AnnotationConfigApplicationContext(MiConfiguracion.class);
	}

	@Test
	public void test() {

		CalculadorOfertas calculador = context.getBean(CalculadorOfertas.class);
		Factura factura = context.getBean(Factura.class);
		calculador.calcularOfertas(factura);
		
		Assert.assertEquals(27.20, factura.getTotal(), 0.001);
		Assert.assertEquals(5, factura.getLineas().size());
		
		System.out.println(factura.toString());
		
	}


}
