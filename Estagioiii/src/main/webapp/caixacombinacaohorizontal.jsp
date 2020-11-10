

<%@page import="br.com.estagioiii.model.UsuarioModel"%>
<%@page import="br.com.estagioiii.dao.CabecalhoDao"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/index.js"></script>
        <link rel="stylesheet" href="css/style.css" />
        <title>JSP Page</title>  
    </head>
    <body>
        <div class="wrapper">
            <div class="container">  
                <form id="formulario" name="formulario" method="post" action="CombinacaoHorizontal"  onsubmit="return validarCombinacaoHorizontal()"> 
                    <h1 style = "text-align:center" >Única Aternativa Horizontal</h1>
                    <br />
                    <%
                        UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
                        if (CabecalhoDao.cabecalhoConfere(usuarioModel.getId(), null, usuarioModel.getIdNovoQuestionario()) == null) {
                    %>
                    &nbsp; &nbsp;Informe o Cabeçalho<br />
                    &nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="text2"  id="text2" size="177"/><br /><br />
                    &nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="text3"  id="text3" size="177"/>
                    <br /> <br /> 
                    <% } %>
                    <input type="button" name="buttonsm" id="buttonsm" style="color: #1E90FF; float:right" value="+" onclick="adicionarCaixaHorizontal(id)" />
                    <input type="submit" id="cadastrar" value="Salvar" style="float:right"  />
                    <br />  
                    <p>&nbsp; &nbsp;
                        Pergunta 
                        <input type="text" name="textfie" id="textfie" size="100" />
                    </p>                    
                    <%
                        for (int i = 0; i < 4; i++) {
                    %>
                    <input type="radio" name="RadioGrup" id="RadioGrup"  />
                    <input type="text" name="text<%= +i%>" id="text<%= +i%>" />  
                    <input type="button" name="buttonsc<%= +i%>" id="buttonsc<%= +i%>" style="color: #FF0000 " value="X"  onclick="removerCaixaHorizontal(id)"/> 
                    <%
                        }
                    %>
                    <input type="hidden" name="tende" id="tende" value="" />
                    <script>
                        document.getElementById("tende").value = contadorCaixaHorizontal;
                        contador = 3;
                        cantadorSelecao = 3;
                        contadorHorizontal = 3;
                        contadorCaixa = 3;
                        contadorTexto = 0;
                        contadorCaixaHorizontal = 3;
                    </script>
                </form>  
            </div>
        </div>   
    </body>
</html>
