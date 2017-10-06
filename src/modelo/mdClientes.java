package modelo;
import java.util.ArrayList;
import java.sql.*;

import entidades.Clientes;
public class mdClientes extends Conexion{
	public ArrayList <Clientes> cargarClientes()
	{
		ArrayList <Clientes> lista = new ArrayList <Clientes>();
		String sql = ("SELECT * FROM Clientes;");
		
		try
		{
			Connection cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
											
			while(rs.next())		
			{					    					
				Clientes  enti = new Clientes();
				
				enti.setID_Cliente(rs.getInt("ID_Cliente"));
				enti.setNombre_cliente(rs.getString("Nombre_cliente"));
				enti.setApellido_cliente(rs.getString("Apellido_cliente"));
				enti.setTel(rs.getString("Tel"));

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
