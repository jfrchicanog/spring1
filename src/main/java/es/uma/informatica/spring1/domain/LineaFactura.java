package es.uma.informatica.spring1.domain;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LineaFactura {
	private Producto producto;
	private Integer cantidad;
	private NumberFormat format;

	public LineaFactura() {
		format = new DecimalFormat("#0.00");
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return producto.getPrecio();
	}
	
	public String toString() {
		return producto.getNombre()+"\t"+cantidad+" x " + format.format(producto.getPrecio())+"\t"+format.format((producto.getPrecio()*cantidad));
	}
}
