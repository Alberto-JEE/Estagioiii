
<%@page import="br.com.estagioiii.model.UsuarioModel"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <title>Estágio UNEMAT</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css"/>
        <script type="text/javascript" src="js/index.js"></script>
    </head>
    <body class="no-sidebar" >
        <input type="hidden" name="acao" />  
        <div id="page-wrapper" >             
            <div id="header-wrapper" class="wrapper">
                <div id="header">                    
                    <%
                        UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
                        if (usuarioModel != null) {
                            if (usuarioModel.isValidacao()) {
                    %>
                    <nav id="nav">
                        <ul>
                            <li class="current"><a href="estagio.jsp">Home</a></li>
                            <li><a href="questionario.jsp" >Questionario</a></li>
                            <li><a href="relatoriodiversos.jsp">Relatórios</a></li>
                            <li><a href="#">Tendência</a></li>
                        </ul>
                    </nav>
                    <div id="logo">
                        <h1>Estágio Unemat</h1>
                        <p>&nbsp;</p>
                    </div>
                    <%
                        }
                    } else {
                    %>
                    <nav id="nav">
                        <ul>
                            <li class="current"><a href="estagio.jsp">Home</a></li>
                            <li><a href="#" >Questionario</a></li>
                            <li><a href="#">Relatórios</a> </li>
                            <li><a href="#">Tendência</a></li>
                        </ul>
                    </nav>
                    <div id="logo">
                        <h1>Estágio Unemat</h1>
                        <p>&nbsp;</p>
                        <form name="form" method="post">
                            <button type="submit" id="login-button" onclick="window.open('registro.jsp')">Registrar</button>  
                            <button type="submit" id="cadastro" onclick="window.open('index.jsp')">Login</button>
                        </form>
                    </div>
                    <%
                        }
                    %>                   
                </div>
                <div class="wrapper style2">
                    <div class="title">Estágio</div>
                    <article class="box post">
                        <header class="style1">
                            <h2>A Universidade do Estado de Mato Grosso </h2>
                            <p>Curso Ciência da Computação Barra do Bugres</p>
                        </header>
                    </article>
                </div>
            </div>
        </div>
    </body>
</html>
