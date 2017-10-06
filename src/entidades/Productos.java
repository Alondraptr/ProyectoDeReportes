package entidades;

public class Productos {
	private int ID_Producto;
	private int ID_Categoria;
	private String NombrePro;
	private float Precio;
	private int InStock;
	public int getID_Producto() {
		return ID_Producto;
	}
	public void setID_Producto(int iD_Producto) {
		ID_Producto = iD_Producto;
	}
	public int getID_Categoria() {
		return ID_Categoria;
	}
	public void setID_Categoria(int iD_Categoria) {
		ID_Categoria = iD_Categoria;
	}
	public String getNombrePro() {
		return NombrePro;
	}
	public void setNombrePro(String nombrePro) {
		NombrePro = nombrePro;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float precio) {
		Precio = precio;
	}
	public int getInStock() {
		return InStock;
	}
	public void setInStock(int inStock) {
		InStock = inStock;
	}

	
}
