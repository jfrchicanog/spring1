package es.uma.informatica.spring1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {
	
	@Bean
	public CalculadorOfertas crearCalculadorOFertas() {
		List<Oferta> ofertas = new ArrayList<>();
		ofertas.add(new Oferta3x2());
		ofertas.add(new Descuento20Porciento("Queso"));
		
		CalculadorOfertas calculador = new CalculadorOfertas(ofertas);
		
		return calculador;
	}

}
