
<%@page import="br.com.estagioiii.dao.CabecalhoDao"%>
<%@page import="br.com.estagioiii.model.UsuarioModel"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">  
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
            usuarioModel.setIdNovoQuestionario(CabecalhoDao.maiorId(usuarioModel.getId()) + 1);
        %>
        <h1>Estilos</h1>
        <ul>            
            <li><a href="texto.jsp" target="mostrar">Texto</a></li>
            <li><a href="multiplaescolha.jsp" target="mostrar">Multipla Escolha</a></li>
            <li><a href="multiplaescolhahorizontal.jsp" target="mostrar">Escolha Horizontal</a></li>
            <li><a href="caixadecombinacao.jsp" target="mostrar" >Caixa de Seleção</a></li>
            <li><a href="caixacombinacaohorizontal.jsp" target="mostrar" >Seleção Horizontal</a></li>
            <li><a href="caixadeselecao.jsp" target="mostrar" >Lista de Seleção</a></li>
        </ul>
    </body>
</html>
