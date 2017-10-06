package modelo;
import java.util.ArrayList;
import java.sql.*;

import entidades.Ventas;
public class mdVentas extends Conexion{
	public ArrayList <Ventas> cargarVentas()
	{
		ArrayList <Ventas> lista = new ArrayList <Ventas>();
		String sql = ("SELECT * FROM Ventas;");
		
		try
		{
			Connection cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
											
			while(rs.next())		
			{					    					
				Ventas enti = new Ventas();
				
				enti.setID_Venta(rs.getInt("ID_Venta"));				
				enti.setID_Empleado(rs.getInt("ID_Empleado"));
				enti.setID_Cliente(rs.getInt("ID_Cliente"));
				enti.setFecha(rs.getDate("Fecha"));

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
