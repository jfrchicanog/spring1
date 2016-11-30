package es.uma.informatica.spring1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import es.uma.informatica.spring1.domain.Factura;
import es.uma.informatica.spring1.domain.LineaFactura;
import es.uma.informatica.spring1.domain.Producto;

public class Descuento20Porciento implements Oferta {
	private String nombreProducto;
	
	public Descuento20Porciento(String nombreProducto) {
		this.nombreProducto=nombreProducto;
	}

	@Override
	public List<LineaFactura> aplicarOferta(Factura factura) {
		List<LineaFactura> nuevasLineas = new ArrayList<>();
		for (LineaFactura linea: factura.getLineas()) {
			if (linea.getProducto().getNombre().equals(nombreProducto)) {
				Producto oferta = new Producto();
				oferta.setNombre("Oferta del 20% en "+linea.getProducto().getNombre());
				oferta.setPrecio(-0.2*linea.getProducto().getPrecio()*linea.getCantidad());
				LineaFactura lineaOferta = new LineaFactura();
				lineaOferta.setProducto(oferta);
				lineaOferta.setCantidad(1);
				nuevasLineas.add(lineaOferta);
			}
		}
		return nuevasLineas;
	}

}
