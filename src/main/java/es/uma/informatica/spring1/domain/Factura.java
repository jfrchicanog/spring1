package es.uma.informatica.spring1.domain;

import java.util.Date;
import java.util.List;

public class Factura {
	private List<LineaFactura> lineas;
	private Date fecha;
	private Integer numero;
	public List<LineaFactura> getLineas() {
		return lineas;
	}
	public void setLineas(List<LineaFactura> lineas) {
		this.lineas = lineas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Double getTotal() {
		double total = 0.0;
		for (LineaFactura linea: lineas) {
			total += linea.getPrecio()*linea.getCantidad();
		}
		return total;
	}
}
