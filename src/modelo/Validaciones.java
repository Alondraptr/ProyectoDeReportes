package modelo;
import java.sql.*;

public class Validaciones extends Conexion{
	
	//Validaci�n del reporte de Talleres de Formaci�n
		public boolean validarExistenciaProductosPorCategoria(int idCategoria)
		{
			boolean existe=false;
			try
			{
				String sql = ("SELECT * FROM Categorias WHERE ID_Categoria='"+idCategoria+"'");
				Connection cn = getConnection();
				PreparedStatement s = cn.prepareStatement(sql);
				ResultSet rs = s.executeQuery();
				if(rs.next())
				{
					existe = true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("DATOS Validacion Reportes: AL PARECER EL DATO, NO EXISTE "+e.getMessage());
			}
			
			return existe;
		}
}
