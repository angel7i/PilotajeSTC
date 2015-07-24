<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">

  <title>Sistema de Monitoreo de Armario de Pilotaje Automático</title>

  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="js/primeui/themes/bootstrap/theme.css" />
  <link rel="stylesheet" href="fonts/font-awesome-4.3.0/css/font-awesome.min.css" />
  <link href="css/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="js/primeui/primeui-2.0-min.css" />
  <link rel="stylesheet" href="css/jquery-ui-themes-1.11.4/themes/ui-lightness/jquery-ui.min.css" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">



</head>
<body>

<%
  String estacion = null;

  switch (request.getParameter("estacion"))
  {
    case "iztacalco":
      estacion = "Iztacalco";
      break;
    case "chabacano":
      estacion = "Chabacano";
      break;
    case "garibaldi8":
      estacion = "Garibaldi";
      break;
    case "obrera":
      estacion = "Obrera";
      break;
    case "iztapalapa":
      estacion = "Iztapalapa";
      break;
    case "laviga":
      estacion = "La Viga";
      break;
    case "constitucion":
      estacion = "Constitución de 1917";
      break;
    case "uam":
      estacion = "UAM-I";
      break;
    case "cerroestrella":
      estacion = "Cerro de la Estrella";
      break;
    case "escuadron":
      estacion = "Escuadrón 201";
      break;
    case "saltoagua":
      estacion = "Salto del Agua";
      break;
    case "bellasartes":
      estacion = "Bellas Artes";
      break;
    case "sanjuan":
      estacion = "San Juan de Letrán";
      break;
    case "aculco":
      estacion = "Aculco";
      break;
    case "apatlaco":
      estacion = "Apatlaco";
      break;
    case "coyuya":
      estacion = "Coyuya";
      break;
    case "doctores":
      estacion = "Doctores";
      break;
    case "atlalilco":
      estacion = "Atlalilco";
      break;
    case "santaanita":
      estacion = "Santa Anita";
      break;
  }
%>
<input type="hidden" id="estacion" value='<%=request.getParameter("estacion")%>' />

<header class="header black-bg">
  <div class="sidebar-toggle-box">
    <div data-placement="right" data-original-title="Inicio">
      <img src="img/metrol.png" id="ml"/>
    </div>
  </div>
  <h3>Sistema de Monitoreo de Armario de Pilotaje Automático</h3>
</header>


<aside>
  <div id="sidebar"  class="nav-collapse ">
    <ul class="sidebar-menu" id="nav-accordion">
      <li class="sub-menu">
        <a href="index.jsp" >
          <span>Líneas</span>
        </a>
      </li>
      <li class="sub-menu">
        <a href="lineaBM.jsp" >
          <span>Monitoreo Línea B</span>
        </a>
      </li>
      <li class="sub-menu">
        <a href="linea8M.jsp" >
          <span>Monitoreo Línea 8</span>
        </a>
      </li>
      <li class="sub-menu">
        <a href="lineaBP.jsp" >
          <span>Reportes Línea B</span>
        </a>
      </li>
      <li class="sub-menu">
        <a href="linea8P.jsp" >
          <span>Reportes Línea 8</span>
        </a>
      </li>
    </ul>
  </div>
</aside>

<section id="main-content">
  <section class="wrapper">
    <h3><i class="fa fa-angle-right"></i> <%=estacion%></h3>

    <div class="row">
      <div class="col-md-12">
        <div class="content-panel">



          <table class="table table-hover" id="t1">
            <h4><i class="fa fa-angle-right"></i> Estado actual de las señales estación <%=estacion%></h4>
            <hr>

            <div id="message" ></div>
            <div id="resetForm" class="form-inline" role="form" style="display:none;">
              <div class="form-group">
                <label class="sr-only" for="user">Usuario</label>
                <input type="email" class="form-control" id="user" placeholder="Usuario">
              </div>
              <div class="form-group">
                <label class="sr-only" for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Contraseña">
              </div>
              <button id="doReset" type="submit">Reset</button>
              <button id="cancelReset" type="submit">Cancelar</button>
            </div>


            <h4><button id="reset" type="button" style="display:none;">Resetear</button></h4>
            <thead>
            <tr>
              <th>Nombre</th>
              <th>Estado</th>
              <th>Actividad</th>
              <th>Fecha</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>VIF1</td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>VIF2</td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>VCOR</td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>NPC</td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>Fuente 1</td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>Fuente 2</td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>Fuente 3</td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>Fuente 4</td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </section>
</section>

<footer>

</footer>

<%--Scripts--%>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/jquery-ui-1.11.4/jquery-ui.min.js"></script>
<script src="js/primeui/primeui-2.0-min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/control8.js"></script>
</body>
</html>
