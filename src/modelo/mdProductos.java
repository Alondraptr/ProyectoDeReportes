package modelo;
import java.util.ArrayList;
import java.sql.*;

import entidades.Productos;
public class mdProductos extends Conexion{
	public ArrayList <Productos> cargarProductos()
	{
		ArrayList <Productos> lista = new ArrayList <Productos>();
		String sql = ("SELECT * FROM Productos;");
		
		try
		{
			Connection cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
											
			while(rs.next())		
			{					    					
				Productos enti = new Productos();
				
				enti.setID_Producto(rs.getInt("ID_Producto"));
				enti.setID_Categoria(rs.getInt("ID_Categoria"));
				enti.setNombrePro(rs.getString("NombrePro"));
				enti.setInStock(rs.getInt("InStock"));
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
