package entidades;

public class Detalle_Ventas {
	private int ID_Venta;
	private int ID_Producto;
	private int Cantidad;
	private float Descuento;
	private float Precio;
	public int getID_Venta() {
		return ID_Venta;
	}
	public void setID_Venta(int iD_Venta) {
		ID_Venta = iD_Venta;
	}
	public int getID_Producto() {
		return ID_Producto;
	}
	public void setID_Producto(int iD_Producto) {
		ID_Producto = iD_Producto;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public float getDescuento() {
		return Descuento;
	}
	public void setDescuento(float descuento) {
		Descuento = descuento;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float precio) {
		Precio = precio;
	}
	
	

}
