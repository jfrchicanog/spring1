package es.uma.informatica.spring1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;

@Component
public class CalculadorOfertas {
	
	private List<Oferta> ofertas;
	
	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	
	public void calcularOfertas(Factura factura) {
		
		List<LineaFactura> lineasOfertas = new ArrayList<>();
		for (Oferta oferta: ofertas) {
			lineasOfertas.addAll(oferta.aplicarOferta(factura));
		}
		factura.getLineas().addAll(lineasOfertas);
		
	}

}
