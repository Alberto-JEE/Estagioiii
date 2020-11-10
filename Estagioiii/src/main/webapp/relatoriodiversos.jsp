
<%@page import="java.util.List"%>
<%@page import="br.com.estagioiii.dao.CabecalhoDao"%>
<%@page import="br.com.estagioiii.model.CabecalhoModel"%>
<%@page import="br.com.estagioiii.model.UsuarioModel"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style1.css">  
        <script type="text/javascript" src="js/index.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="container">                
                <form name="form" method="post" action="Relatorio" onsubmit="return validar();">
                    <%
                        UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
                        List<CabecalhoModel> cabecalhoModel = CabecalhoDao.buscaTodoCabecalho(usuarioModel.getId());
                    %>
                    <h1>Cadastro</h1>
                    <p>&nbsp;</p>
                    <select name="seleTextOpcao" id="seleTextOpcao" >
                        <option name="opcaoGeral" id="opcaoGeral" value="Geral"> Geral
                        <option name="opcaoEspecifico" id="opcaoEspecifico" value="Específico"> Específico
                    </select><br/><br/>
                    <select name="seleText" id="seleText" >
                        <%
                            if (!cabecalhoModel.isEmpty()) {
                                for (int i = 0; i < cabecalhoModel.size(); i++) {
                        %>
                        <option name="opcao<%= +i%>" id="opcao<%= +i%>" value="<%= cabecalhoModel.get(i).getAssuntoQuestionario()%>"
                                > <%=cabecalhoModel.get(i).getAssuntoQuestionario()%> </option>
                        <%
                            }
                        %>
                        <%
                            }
                        %>
                    </select><br/><br/>
                    <button type="submit"  id="login-button" >Gerar</button>
                </form>
            </div>
        </div>
    </body>
</html>
