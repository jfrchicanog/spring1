package es.uma.informatica.spring1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.uma.informatica.spring1.domain.Factura;

public class CalculadorOfertasTest {
	private ApplicationContext contexto;
	
	@Before
	public void setup() {
		contexto = new ClassPathXmlApplicationContext("spring-conf.xml");
	}
	
	@Test
	public void test() {
		
		Factura factura = contexto.getBean(Factura.class);
		CalculadorOfertas calculador = contexto.getBean(CalculadorOfertas.class);
		
		calculador.calcularOfertas(factura);
		
		Assert.assertEquals(27.20, factura.getTotal(), 0.001);
		Assert.assertEquals(5, factura.getLineas().size());
		
		System.out.println(factura.toString());
		
	}

}
