

<%@page import="br.com.estagioiii.model.UsuarioModel"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>

<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
        <title>Questionário</title>
        <link rel="stylesheet" href="css/style2.css">
    </head>
    <frameset rows="20%,*">
        <frame src="cabecalho.jsp"/>
        <frameset cols="15%,*" bordercolor="#50a3a2">
            <frame src="framemenu.jsp" name="visual" noresize="noresize"/>
            <frame src="frameprincipal.jsp" name="mostrar" noeresize="noresize"/>
        </frameset>        
    </frameset>
</html>