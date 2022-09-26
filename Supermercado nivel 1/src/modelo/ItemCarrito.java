package modelo;

public class ItemCarrito {

	private int idItem;
	private int cantidad;
	private Producto producto;

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ItemCarrito(int idItem, int cantidad, Producto producto) {
		this.idItem = idItem;
		this.cantidad = cantidad;
		this.producto = producto;
	}

}
