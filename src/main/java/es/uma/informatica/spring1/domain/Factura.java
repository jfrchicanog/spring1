package es.uma.informatica.spring1.domain;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

public class Factura {
	private NumberFormat format;
	
	private List<LineaFactura> lineas;
	private Date fecha;
	private Integer numero;

	public Factura() {
		format = new DecimalFormat("#0.00");
	}
	
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
	
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		for (LineaFactura linea: lineas) {
			cadena.append(linea.toString()+"\n");
		}
		cadena.append("--------------------------------\n");
		cadena.append("Total:\t\t"+format.format(getTotal()));
		return cadena.toString();
	}
}
