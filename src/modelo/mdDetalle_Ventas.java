package modelo;
import java.util.ArrayList;
import java.sql.*;

import entidades.Detalle_Ventas;
public class mdDetalle_Ventas extends Conexion{
	public ArrayList <Detalle_Ventas> cargarDetalle_Ventas()
	{
		ArrayList <Detalle_Ventas> lista = new ArrayList <Detalle_Ventas>();
		String sql = ("SELECT * FROM Detalle_Ventas;");
		
		try
		{
			Connection cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
											
			while(rs.next())		
			{					    					
				Detalle_Ventas  enti = new Detalle_Ventas();
				
				enti.setID_Producto(rs.getInt("ID_Producto"));
				enti.setID_Venta(rs.getInt("ID_Venta"));
				enti.setCantidad(rs.getInt("Cantidad"));
				enti.setDescuento(rs.getFloat("Descuento"));
				enti.setPrecio(rs.getFloat("Precio"));

				lista.add(enti);
			}
			
			//Cerramos la conexion
			ps.close();
			cn.close();
		}
		catch(Exception e)
		{
			System.out.println("Datos: Error al cargar la lista de categoria -> "+e.getMessage());
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
