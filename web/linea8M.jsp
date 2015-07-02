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
      <h3><i class="fa fa-angle-right"></i> Monitoreo Línea 8</h3>
      <hr>

      <table class="table table-hover">
        <tbody>
        <tr>
          <td><span>Iztacalco</span><a href="estado8.jsp?estacion=iztacalco"><img class="img-responsive" src="img/iztacalco.png" alt=""></a></td>
          <td><span>Chabacano</span><a href="estado8.jsp?estacion=chabacano"><img class="img-responsive" src="img/chabacano.png" alt=""></a></td>
          <td><span>Garibaldi</span><a href="estado8.jsp?estacion=garibaldi8"><img class="img-responsive" src="img/garibaldi.png" alt=""></a></td>
          <td><span>Obrera</span><a href="estado8.jsp?estacion=obrera"><img class="img-responsive" src="img/obrera.png" alt=""></a></td>
        </tr>
        <tr>
          <td><span>Iztapalapa</span><a href="estado8.jsp?estacion=iztapalapa"><img class="img-responsive" src="img/iztapalapa.png" alt=""></a></td>
          <td><span>La Viga</span><a href="estado8.jsp?estacion=laviga"><img class="img-responsive" src="img/laviga.png" alt=""></a></td>
          <td><span>Constitución de 1917</span><a href="estado8.jsp?estacion=constitucion"><img class="img-responsive" src="img/constitucion.png" alt=""></a></td>
          <td><span>UAM-I</span><a href="estado8.jsp?estacion=uam"><img class="img-responsive" src="img/uam-i.png" alt=""></a></td>
        </tr>
        <tr>
          <td><span>Cerro de la Estrella</span><a href="estado8.jsp?estacion=cerroestrella"><img class="img-responsive" src="img/cerroestrella.png" alt=""></a></td>
          <td><span>Escuadrón 201</span><a href="estado8.jsp?estacion=escuadron"><img class="img-responsive" src="img/escuadron201.png" alt=""></a></td>
          <td><span>Salto del Agua</span><a href="estado8.jsp?estacion=saltoagua"><img class="img-responsive" src="img/saltodelagua.png" alt=""></a></td>
          <td><span>Bellas Artes</span><a href="estado8.jsp?estacion=bellasartes"><img class="img-responsive" src="img/bellasartes.png" alt=""></a></td>
        </tr>
        <tr>
          <td><span>San Juan de Letrán</span><a href="estado8.jsp?estacion=sanjuan"><img class="img-responsive" src="img/sanjuandeletran.png" alt=""></a></td>
          <td><span>Aculco</span><a href="estado8.jsp?estacion=aculco"><img class="img-responsive" src="img/aculco.png" alt=""></a></td>
          <td><span>Apatlaco</span><a href="estado8.jsp?estacion=apatlaco"><img class="img-responsive" src="img/apatlaco.png" alt=""></a></td>
          <td><span>Coyuya</span><a href="estado8.jsp?estacion=coyuya"><img class="img-responsive" src="img/coyuya.png" alt=""></a></td>
        </tr>
        <tr>
          <td><span>Doctores</span><a href="estado8.jsp?estacion=doctores"><img class="img-responsive" src="img/doctores.png" alt=""></a></td>
          <td><span>Atlalilco</span><a href="estado8.jsp?estacion=atlalilco"><img class="img-responsive" src="img/atlalilco.png" alt=""></a></td>
          <td><span>Santa Anita</span><a href="estado8.jsp?estacion=santaanita"><img class="img-responsive" src="img/santaanita.png" alt=""></a></td>
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
</body>
</html>
