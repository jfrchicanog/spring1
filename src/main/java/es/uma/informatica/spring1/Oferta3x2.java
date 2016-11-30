package es.uma.informatica.spring1;

import java.util.ArrayList;
import java.util.List;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;
import es.uma.informatica.spring1.domain.Producto;

public class Oferta3x2 implements Oferta {
	
	private String nombreProducto;
	
	public Oferta3x2(String nombreProducto) {
		this.nombreProducto=nombreProducto;
	}
	
	@Override
	public List<LineaFactura> aplicarOferta(Factura factura) {
		List<LineaFactura> nuevasLineas = new ArrayList<>();
		for (LineaFactura linea: factura.getLineas()) {
			if (linea.getProducto().getNombre().equals(nombreProducto) && linea.getCantidad() >= 3) {
				int packs = linea.getCantidad()/3;
				Producto oferta = new Producto();
				oferta.setNombre("Oferta 3x2 en "+linea.getProducto().getNombre());
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
