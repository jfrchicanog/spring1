package es.uma.informatica.spring1.domain;

public class LineaFactura {
	private Producto producto;
	private Integer cantidad;

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
}
