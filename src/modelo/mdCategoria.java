package modelo;
import java.util.ArrayList;
import java.sql.*;
import entidades.Categoria;
public class mdCategoria extends Conexion{
	public ArrayList <Categoria> cargarCategorias()
	{
		ArrayList <Categoria> lista = new ArrayList <Categoria>();
		String sql = ("SELECT * FROM Categorias;");
		
		try
		{
			Connection cn = getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
											
			while(rs.next())		
			{					    					
				Categoria  enti = new Categoria();
				
				enti.setID_Categoria(rs.getInt("ID_Categoria"));
				enti.setNombre_Cat(rs.getString("Nombre_Cat"));
				enti.setDescripcion(rs.getString("Descripción"));

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
