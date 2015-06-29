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
  <link href="css/bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">



</head>
<body>
<section id="container">

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
          <span>Pasivación Línea B</span>
        </a>
      </li>
      <li class="sub-menu">
        <a href="linea8P.jsp" >
          <span>Pasivación Línea 8</span>
        </a>
      </li>
    </ul>
  </div>
</aside>

<!--main content start-->
<section id="main-content">
  <section class="wrapper ">
    <h3><i class="fa fa-angle-right"></i> Monitoreo Línea B</h3>
    <hr>

    <table class="table table-hover">
      <tbody>
      <tr>
        <td><span>Romero Rubio</span><a href="estadoB.jsp?estacion=romerorubio"><img class="img-responsive" src="img/romerorubio.png" alt=""></a></td>
        <td><span>Buenavista</span><a href="estadoB.jsp?estacion=buenavista"><img class="img-responsive" src="img/buenavista.png" alt=""></a></td>
        <td><span>Garibaldi</span><a href="estadoB.jsp?estacion=garibaldiB"><img class="img-responsive" src="img/garibaldi.png" alt=""></a></td>
        <td><span>Tepito</span><a href="estadoB.jsp?estacion=tepito"><img class="img-responsive" src="img/tepito.png" alt=""></a></td>
      </tr>
      <tr>
        <td><span>San Lázaro</span><a href="estadoB.jsp?estacion=sanlazaro"><img class="img-responsive" src="img/sanlazaro.png" alt=""></a></td>
        <td><span>Deportivo Oceanía</span><a href="estadoB.jsp?estacion=oceania"><img class="img-responsive" src="img/oceania.png" alt=""></a></td>
        <td><span>Villa Aragón</span><a href="estadoB.jsp?estacion=villaaragon"><img class="img-responsive" src="img/villaaragon.png" alt=""></a></td>
        <td><span>Impulsora</span><a href="estadoB.jsp?estacion=impulsora"><img class="img-responsive" src="img/impulsora.png" alt=""></a></td>
      </tr>
      <tr>
        <td><span>Múzquiz</span><a href="estadoB.jsp?estacion=muzquiz"><img class="img-responsive" src="img/muzquiz.png" alt=""></a></td>
        <td><span>Olímpica</span><a href="estadoB.jsp?estacion=olimpica"><img class="img-responsive" src="img/olimpica.png" alt=""></a></td>
        <td><span>Ciudad Azteca</span><a href="estadoB.jsp?estacion=cdazteca"><img class="img-responsive" src="img/cdazteca.png" alt=""></a></td>
        <td><span>PMT Cd Azteca</span><a href="estadoB.jsp?estacion=pmtcdazteca"><img class="img-responsive" src="img/cdazteca.png" alt=""></a></td>
      </tr>
      </tbody>
    </table>
  </section>
</section>


  <footer>

  </footer>
  </section>
<%--Scripts--%>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<!--common script for all pages-->
<script src="js/common-scripts.js"></script>
</body>
</html>
