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

    <section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> Monitoreo de Armario de las Líneas </h3>
        <table class="table table-hover">
          <tbody>
          <tr>
            <td><h3><span>Línea B</span></h3><a href="lineaBM.jsp"><img class="img-responsive" src="img/lineab.png" alt=""></a></td>
            <td><h3><span>Línea 8</span></h3><a href="linea8M.jsp"><img class="img-responsive" src="img/linea8.png" alt=""></a></td>
            </tr>
          </tbody>
        </table>
      </section>
    </section>

    <footer>

    </footer>

      <%--Scripts--%>
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
  </body>
</html>
