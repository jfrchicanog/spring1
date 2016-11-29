package es.uma.informatica.spring1;

import java.util.List;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;

public class CalculadorOfertas {
	
	public void calcularOfertas(Factura factura) {
		Oferta3x2 oferta = new Oferta3x2();
		List<LineaFactura> lineasOfertas = oferta.aplicarOferta(factura);
		factura.getLineas().addAll(lineasOfertas);
	}

}
