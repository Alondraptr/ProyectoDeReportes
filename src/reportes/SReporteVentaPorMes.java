package reportes;
import java.sql.*;
import java.util.HashMap;

import modelo.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SlReporteProductoCategoria
 */
@WebServlet("/SlReporteVentaPorMes")
public class SReporteVentaPorMes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SReporteVentaPorMes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try{
			
			String opc = "";
			
			opc = request.getParameter("opc");

				int mes;
				mes = Integer.parseInt(request.getParameter("mes"));
				String formato = request.getParameter("formato");
				
				Connection con = new Conexion().getConnection();
		
				
					HashMap<String, Object> hm = new HashMap<>();
					hm.put("Fecha", mes);
	
					OutputStream outputStream = response.getOutputStream();
					ServletContext context = getServletContext();
					String path = context.getRealPath("/");
					String template = "/rpt/VentaMensual.jasper";
					
					if(formato.equals("1")){
						Exporter exporter = new JRPdfExporter();
						JasperPrint jasperPrint = JasperFillManager.fillReport(path+template, hm, con);
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition",  "inline; filename=\"Venta Mensual.pdf\"");
						
						exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
						exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
						exporter.exportReport();
					}
					else if(formato.equals("2")){
						Exporter exporter = new JRXlsExporter();
						JasperPrint jasperPrint = JasperFillManager.fillReport(path+template, hm, con);
						response.setContentType("application/xls");
						response.setHeader("Content-Disposition",  "inline; filename=\"Venta Mensual.xls\"");
						
						exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
						exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
						exporter.exportReport();
					}
				}
				 catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./index.jsp");
			System.out.println("SERVLET: ERROR AL GENERAR EL REPORTE "+e.getMessage());
		}
	}
	}
