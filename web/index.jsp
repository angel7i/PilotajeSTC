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
            <a href="lineab.jsp" >
              <span>Línea B</span>
            </a>
          </li>
          <li class="sub-menu">
            <a href="linea8.jsp" >
              <span>Línea 8</span>
            </a>
          </li>
        </ul>
      </div>
    </aside>

    <section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> Línea</h3>
        <div class="row mt">
          <div class="col-lg-2">

        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
              <div class="project-wrapper">
                <div class="project">
                  <div class="photo-wrapper">
                    <div class="photo">
                      <a href="lineab.jsp"><img class="img-responsive" src="img/lineab.png" alt=""></a>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
              <div class="project-wrapper">
                <div class="project">
                  <div class="photo-wrapper">
                    <div class="photo">
                      <a href="linea8.jsp"><img class="img-responsive" src="img/linea8.png" alt=""></a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        </div>
            </div>
        </div>
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
