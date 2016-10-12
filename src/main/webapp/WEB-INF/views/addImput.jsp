<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: amayas
  Date: 25/09/16
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Imputation</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet" />
    <!-- jquery-ui Core CSS -->
    <link href="<c:url value='/static/css/jquery-ui/jquery-ui.min.css'/>" rel="stylesheet" />
    <!-- Custom CSS -->
    <link href="<c:url value='/static/css/styles.css'/>" rel="stylesheet" />
</head>
<body>

    <div id="wrapper">
        <div class="overlay"></div>

        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Brand
                    </a>
                </li>
                <li>
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Events</a>
                </li>
                <li>
                    <a href="#">Team</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
                <li>
                    <a href="<c:url value='/download/imputations' />">Télécharger imputations</a>
                </li>
            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                <span class="hamb-top"></span>
                <span class="hamb-middle"></span>
                <span class="hamb-bottom"></span>
            </button>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <form:form method="post" class="form-inline addTaskForm" modelAttribute="imputation">
                            <div class="form-group">
                                <div class="top-buffer">
                                    <form:input type="text" class="form-control" id="time" path="timeSpent" placeholder="Temps" />
                                    <form:input type="text" class="form-control" id="task" path="task" placeholder="Tâche"/>
                                    <form:input type="text" class="form-control" id="datepicker" path="date" placeholder="Date"/>
                                </div>
                                <div class="top-buffer">
                                    <form:select class="form-control" id="statut" path="status">
                                        <form:option value="facturable">Facturable</form:option>
                                        <form:option value="depassement">Dépassement</form:option>
                                        <form:option value="interne">Interne</form:option>
                                    </form:select>
                                    <form:select class="form-control" id="projet" path="project">
                                        <form:option value="test1">projet 1</form:option>
                                        <form:option value="test2">projet 2</form:option>
                                        <form:option value="test3">projet 3</form:option>
                                        <form:option value="test4">projet 4</form:option>
                                    </form:select>
                                </div>
                                <div class="top-buffer">
                                    <button type="submit" class="btn btn-primary">Ajouter la tâche</button>
                                    <button id="cancelAddTask" class="btn btn-danger">Annuler</button>
                                </div>
                            </div>

                        </form:form>
                        <a class="addTaskLink" href="#"><span class="glyphicon glyphicon-plus"></span>&nbsp;Ajouter une tâche</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->


    <!-- jQuery -->
    <script src="<c:url value='/static/js/jquery.js'/>"></script>

    <!-- jQuery -->
    <script src="<c:url value='/static/js/jquery-ui/jquery-ui.min.js'/>"></script>

    <!--jquery-ui french localization for datepicker -->
    <script src="<c:url value='/static/js/jquery-ui/datepicker-fr.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='/static/js/bootstrap.min.js'/>"></script>

    <!-- custom script -->
    <script src="<c:url value='/static/js/script.js'/>"></script>

</body>
</html>
