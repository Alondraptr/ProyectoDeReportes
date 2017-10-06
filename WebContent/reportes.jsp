<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.ArrayList,entidades.*, modelo.*,reportes.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas Nicaragua</title>
 <%

 ArrayList <Categoria> lista = new ArrayList<Categoria>();
 mdCategoria mc = new mdCategoria();
 lista = mc.cargarCategorias();
 
 ArrayList <Clientes> Clienteslista = new ArrayList<Clientes>();
 mdClientes cliente = new mdClientes();
 Clienteslista = cliente.cargarClientes();

 ArrayList <Ventas> Vlista = new ArrayList<Ventas>();
 mdVentas V= new mdVentas();
 Vlista = V.cargarVentas();
       %>
  
<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="index.jsp"><span>Ventas</span>Nicaragua</a>							
			</div>
		</div><!-- /.container-fluid -->
	</nav>
		<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name">Username</div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li ><a href="index.jsp"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
			<li class="active"><a href="reportes.jsp"><em class="fa fa-bar-chart">&nbsp;</em> Reportes</a></li>
		</ul>
	</div><!--/.sidebar-->
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="index.jsp">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Reportes</li>
			</ol>
		</div><!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Reportes</h1>
			</div>
		</div><!--/.row-->
		<div class="panel panel-container">
<!-- Factura con su Detalle Reporte #1  -->
		<h4>Factura con Detalle</h4>
		<br/>
      <div class="row">
				<div class="col-xs-6 no-padding">
					<div class="panel panel-teal panel-widget ">
					 
	 <form method="POST" action="./SlReporteFacturaDetalle"target="_blank">
          <label>Venta</label>
		<select id="venta" name="venta">
			<%
				for(Ventas cat1: Vlista)
				{
			%>
					<option value="<%=cat1.getID_Venta()%>">
						<%=cat1.getID_Venta()%>
					</option>
			<%
				}
			%>
		</select>
		
		<select id="formato" name="formato">
			<option value="1">PDF</option>
			<option value="2">Excel</option>
		</select>
		
		<button type="submit">Generar reporte</button>
	</form>
              </div>
          </div>  
            
      </div>   <!-- Fin -->	
      <!--Total de venta por mes #2  -->
		<h4>Total de venta por mes</h4>
		<br/>
      <div class="row">
				<div class="col-xs-6 no-padding">
					<div class="panel panel-teal panel-widget ">
					 
	 <form method="POST" action="./SlReporteVentaPorMes"target="_blank">
          <label>Mes</label>
		<select id="mes" name="mes">
		
			<option value="1">Enero</option>

            <option value="2">Febrero</option>

            <option value="3">Marzo</option>

            <option value="4">Abril</option>

            <option value="5">Mayo</option>

            <option value="6">Junio</option>

            <option value="7">Julio</option>

            <option value="8">Agosto</option>

            <option value="9">Septiembre</option>

            <option value="10">Octubre</option>

            <option value="11">Noviembre</option>

            <option value="12">Diciembre</option>

        </select>
		<select id="formato" name="formato">
			<option value="1">PDF</option>
			<option value="2">Excel</option>
		</select>
		
		<button type="submit" >Generar reporte</button>
	</form>
              </div>
          </div>  
            
      </div>   <!-- Fin -->	
	<!-- La categoría con mayor venta Reporte #3  -->
	<h4>Categoría con mayor ventas</h4>
	<br/>
      <div class="row">
				<div class="col-xs-6 no-padding">
					<div class="panel panel-teal panel-widget ">
					 
	 <form method="POST" action="./SlReporteCategoriaMayorVenta"target="_blank">
          <label>Selecione un Formato</label>
				
		<select id="formato" name="formato">
			<option value="1">PDF</option>
			<option value="2">Excel</option>
		</select>
		
		<button type="submit">Generar reporte</button>
	</form>
              </div>
          </div>  
            
      </div>   <!-- Fin -->
	<!-- Lista de productos por Categorias Reporte #4  -->
	<h4>Cantidad de Productos por Categorias</h4>
	<br/>
      <div class="row">
				<div class="col-xs-6 no-padding">
					<div class="panel panel-teal panel-widget ">
					 
	 <form method="POST" action="./SlReporteProductoCategoria" target="_blank">
          <label>Selecione un Formato</label>
				
		<select id="formato" name="formato">
			<option value="1">PDF</option>
			<option value="2">Excel</option>
		</select>
		
		<button type="submit">Generar reporte</button>
	</form>
              </div>
          </div>  
            
      </div>   <!-- Fin -->
      <!--Total de venta por fechas #5  -->
		<h4>Total de venta por fechas</h4>
		<br/>
      <div class="row">
				<div class="col-xs-6 no-padding">
					<div class="panel panel-teal panel-widget" >
					 
	 <form method="POST" action="./SlReporteVentaFecha"target="_blank">
	 <label>Selecione el periodo de fechas</label>
	 <br/>
          <label>Comienza</label>
		<input type="date" id="comienzo" name="comienzo" step="1" min="2016-01-01" max="2020-12-31" value="2017-08-01">
		<br/>
		<label>Termina</label>
		<input type="date" id="fin" name="fin" step="1" min="2016-01-01" max="2020-12-31" value="2017-08-03">
		<br/><br/>
		<select id="formato" name="formato">
			<option value="1">PDF</option>
			<option value="2">Excel</option>
		</select>
		
		<button type="submit">Generar reporte</button>
	</form>
              </div>
          </div>  
            
      </div>   <!-- Fin -->	
   </div>
</body>
</html>