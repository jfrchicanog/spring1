package es.uma.informatica.spring1;

import java.util.List;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;

public interface Oferta {

	List<LineaFactura> aplicarOferta(Factura factura);

}