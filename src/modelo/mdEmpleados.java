package modelo;
import java.util.ArrayList;
import java.sql.*;

import entidades.Empleados;
public class mdEmpleados extends Conexion{
	public ArrayList <Empleados> cargarEmpleados()
	{
		ArrayList <Empleados> lista = new ArrayList <Empleados>();
		String sql = ("SELECT * FROM Empleados;");
		
		try
		{
			Connection cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
											
			while(rs.next())		
			{					    					
				Empleados  enti = new Empleados();
				
				enti.setID_Empleado(rs.getInt("ID_Empleado"));
				enti.setNombre(rs.getString("Nombre"));
				enti.setApellido(rs.getString("Apellido"));
				enti.setCedula(rs.getString("Cedula"));
				enti.setTelefono(rs.getString("Telefono"));

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
