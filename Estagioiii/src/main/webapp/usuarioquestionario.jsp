

<%@page import="java.util.List"%>
<%@page import="br.com.estagioiii.dao.CabecalhoDao"%>
<%@page import="br.com.estagioiii.model.CabecalhoModel"%>
<%@page import="br.com.estagioiii.model.UsuarioModel"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>        
        <link rel="stylesheet" href="css/style1.css">  
        <script type="text/javascript" src="js/index.js"></script>
    </head>
    <body>
        <div class="wrapper">
            <div class="container">                
                <form name="form" method="post" action="Cadastro" onsubmit="return validarCadastro();">
                    <%
                        UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
                        List<CabecalhoModel> cabecalhoModel = CabecalhoDao.buscaTodoCabecalho(usuarioModel.getId());
                    %>
                    <h1>Cadastro</h1>
                    <p>&nbsp;</p>
                    <%
                            if (!cabecalhoModel.isEmpty()) {
                                %>
                    <select name="seleText" id="seleText" >
                         <%
                        
                                for (int i = 0; i < cabecalhoModel.size(); i++) {
                        %>
                        <option name="opcao<%= +i%>" id="opcao<%= +i%>" value="<%= cabecalhoModel.get(i).getAssuntoQuestionario()%>"> <%=cabecalhoModel.get(i).getAssuntoQuestionario()%> </option>
                        <%
                            }
                        %>
                                            </select><br/><br/>
                        <%
                            }
                        %>
                    <textarea name="textarea" id="textextareaarea" cols="45" rows="5" size="100"> Email : exemplo@gmail.com</textarea>
                    <input type="password" name="Password" id="Password" placeholder="senha">
                    <input type="password" name="Password2" id="Password2" placeholder="senha">
                    <button type="submit"  id="login-button" >Enviar</button>
                </form>
            </div>
        </div>
    </body>
</html>
