package es.uma.informatica.spring1;

import java.util.ArrayList;
import java.util.List;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;
import es.uma.informatica.spring1.domain.Producto;

public class Oferta3x2 {
	
	public List<LineaFactura> aplicarOferta(Factura factura) {
		List<LineaFactura> nuevasLineas = new ArrayList<>();
		for (LineaFactura linea: factura.getLineas()) {
			if (linea.getCantidad() >= 3) {
				int packs = linea.getCantidad()/3;
				Producto oferta = new Producto();
				oferta.setNombre("Oferta 3x2 en "+linea.getProducto());
				oferta.setPrecio(-packs*linea.getProducto().getPrecio());
				LineaFactura lineaOferta = new LineaFactura();
				lineaOferta.setProducto(oferta);
				lineaOferta.setCantidad(1);
				nuevasLineas.add(lineaOferta);
			}
		}
		return nuevasLineas;
	}

}
