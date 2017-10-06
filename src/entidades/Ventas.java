package entidades;
import java.util.Date;
public class Ventas {
	private int ID_Venta;
	private int ID_Empleado;
	private int ID_Cliente;
	private Date Fecha;
	public int getID_Venta() {
		return ID_Venta;
	}
	public void setID_Venta(int iD_Venta) {
		ID_Venta = iD_Venta;
	}
	public int getID_Empleado() {
		return ID_Empleado;
	}
	public void setID_Empleado(int iD_Empleado) {
		ID_Empleado = iD_Empleado;
	}
	public int getID_Cliente() {
		return ID_Cliente;
	}
	public void setID_Cliente(int iD_Cliente) {
		ID_Cliente = iD_Cliente;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
}
