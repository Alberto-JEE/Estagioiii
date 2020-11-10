
<%@page import="br.com.estagioiii.dao.CabecalhoDao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.estagioiii.model.CabecalhoModel"%>
<%@page import="br.com.estagioiii.model.UsuarioModel"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="5">
        <link rel="stylesheet" href="assets/css/main_1.css" media="all" />
        <title>JSP Page</title>        
    </head>
    <body bgcolor="#505b6c">   
        <h1 >Questionário</h1>
        <%
            UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
            if (usuarioModel != null) {
                List<CabecalhoModel> cabecalhoModel = CabecalhoDao.buscaTodoCabecalho(usuarioModel.getId());
        %>
        <ul id="menu">            
            <li><a href="novoquestionario.jsp" target="visual">Novo</a></li>
            <li>
                <a href="#">Editar</a>
                <%
                    if (!cabecalhoModel.isEmpty()) {
                %>       
                <ul class="submenu">   
                    <%
                        for (int i = 0; i < cabecalhoModel.size(); i++) {
                    %>
                    <li><a  href="Edita?idCabecalho=<%= cabecalhoModel.get(i).getIdNovoQuestionario()%>" target="mostrar">
                            <%=cabecalhoModel.get(i).getAssuntoQuestionario()%> 
                        </a>
                    </li>
                    <%
                        }
                    %>
                </ul>
                <%
                    }
                %>
            </li> 
            <li>
                <a href="#" >Excluir</a>
                <%
                    if (!cabecalhoModel.isEmpty()) {
                %>       
                <ul class="submenu">   
                    <%
                        for (int i = 0; i < cabecalhoModel.size(); i++) {
                    %>
                    <li><a  href="javascript:if(confirm('Tem Certeza que Deseja Excluir')){location='Excluir?idCabecalho=<%= cabecalhoModel.get(i).getIdNovoQuestionario()%>'};" target="mostrar">
                            <%=cabecalhoModel.get(i).getAssuntoQuestionario()%> 
                        </a>
                    </li>
                    <%
                        }
                    %>
                </ul>
                <%
                    }
                %>
            </li>
            <li>
                <a href="#" >Visualizar</a>
                <%
                    if (!cabecalhoModel.isEmpty()) {
                %>       
                <ul class="submenu">   
                    <%
                        for (int i = 0; i < cabecalhoModel.size(); i++) {
                    %>
                    <li><a  href="Visualiza?idCabecalho=<%= cabecalhoModel.get(i).getIdNovoQuestionario()%>" target="mostrar">
                            <%=cabecalhoModel.get(i).getAssuntoQuestionario()%> 
                        </a>
                    </li>
                    <%
                        }
                    %>
                </ul>
                <%
                    }
                %>
            </li>
            <li><a href="usuarioquestionario.jsp" target="mostrar">Envio Email</a></li> 
        </ul><br/>           
        <p>Usuario <%= usuarioModel.getLoginName()%></p>
        <%
            }
        %>
    </body>
</html>
