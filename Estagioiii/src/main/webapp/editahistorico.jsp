<%@page import="br.com.estagioiii.dao.CabecalhoDao"%>
<%@page import="br.com.estagioiii.model.AlternativaModel"%>
<%@page import="br.com.estagioiii.dao.AlternativaDao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.estagioiii.model.UsuarioModel"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/index.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="main">
            <form name="formulario" id="formulario" method="post" action="SalvaEdicao" style="background-color: #FFFFE0" onsubmit="return validarHistorico()" >  
                <br />

                <%
                    UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
                    List<AlternativaModel> alternativaModel = AlternativaDao.buscaTodasAlternativaUsuario(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
                    if (!alternativaModel.isEmpty()) {
                        Integer numeroPergunta = 1;
                        int indice = 1;
                        int compara = -1;
                        int radIndice = 1;
                        int indPergunta = 1;
                        alternativaModel.get(0).getQuestionarioModel().getCabecalhoModel().setAuxiliar(true);
                        for (int i = 0; i < alternativaModel.size(); i++) {
                            if ((CabecalhoDao.cabecalhoConfere(null, alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().getId(), usuarioModel.getIdNovoQuestionario()) != null) && (alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().isAuxiliar())) {
                %>
                <br/><br/>
                <input  type="submit" id="cadastrar"  value="Salvar" style="float:right;"  />
                <br/><br/>
                &nbsp; &nbsp;Informe o Cabeçalho<br />
                &nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="text2"  id="text2" size="177" value="<%= alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().getTituloQuestionario()%>"/><br /><br />
                &nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="text3"  id="text3" size="177" value="<%= alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().getAssuntoQuestionario()%>"/><br /><br /> 
                <% alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().setAuxiliar(false);
                %>
                <%
                    }
                    if (6 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                %>
                <div  id="aqui<%= +indice%>">
                    <p>
                    <input type="button" name="buttonsm" id="buttonsm" style="color: #1E90FF; float:right" value="+" onclick="edicaoCaixaHorizontal(id)" />
                    <input type="button" name="<%= +indice%>" id="<%= +indice%>" style="color: #FF0000; float:right" value="X" onclick="removerEdicao(id)" />
                    </p> 
                    <p>
                        &nbsp; &nbsp;<%= numeroPergunta + " ) "%>
                        <input type="text" name="textfie<%= +indPergunta%>" id="textfie<%= +indPergunta%>" size="100" value="<%= alternativaModel.get(i).getQuestionarioModel().getPergunta()%>" />
                    </p> 
                    <%
                        indPergunta++;
                        numeroPergunta++;
                        Integer adiciIndice = 1;
                        for (int j = 0; j < alternativaModel.size(); j++) {
                            if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                    %>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<%= adiciIndice%>
                    <input type="radio" name="RadioGrup<%= +radIndice%>" id="RadioGrup<%= +radIndice%>" /> 
                    <input type="text" name="text<%= +indice%>" id="text<%= +indice%>" value="<%= alternativaModel.get(j).getAlternativa()%>" />  
                    <input type="button" name="buttonsc<%= +indice%>" id="buttonsc<%= +indice%>" style="color: #FF0000 " value="X"  onclick="removerCaixaHorizontal(id)"/> 
                    <%
                                adiciIndice++;
                                indice++;
                            }
                        }
                    %>
                </div>
                <%
                    radIndice++;
                %>
                <%
                        }
                    }
                    if (5 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                %>
                <div  id="aqui<%= +indice%>">
                    <p>
                        <input type="button" name="buttonsm" id="buttonsm" style="color: #1E90FF; float:right" value="+" onclick="edicaoHorizontal(id)" />
                        <input type="button" name="<%= +indice%>" id="<%= +indice%>" style="color: #FF0000; float:right" value="X" onclick="removerEdicao(id)" />
                    </p>
                    <p>
                        &nbsp; &nbsp;<%= numeroPergunta + " ) "%>
                        <input type="text" name="textfie<%= +indPergunta%>" id="textfie<%= +indPergunta%>" size="100" value="<%= alternativaModel.get(i).getQuestionarioModel().getPergunta()%>" />
                    </p> 
                    <%
                        indPergunta++;
                        numeroPergunta++;
                        Integer adiciIndice = 1;
                        for (int j = 0; j < alternativaModel.size(); j++) {
                            if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                    %>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<%= adiciIndice%>
                    <input type="checkbox" name="checkbox<%= +indice%>" id="checkbox<%= +indice%>"  />
                    <input type="text" name="textfield<%= +indice%>" id="textfield<%= +indice%>"  value="<%= alternativaModel.get(j).getAlternativa()%>"/>
                    <input type="button" name="buttons<%= +indice%>" id="buttons<%= +indice%>" style="color: #FF0000 " value="X" onclick=" removerHorizontal(id)" />&nbsp; &nbsp;&nbsp; &nbsp;
                    <%
                                indice++;
                                adiciIndice++;
                            }
                        }%>
                </div>
                <% }
                    }
                    if (4 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                %>
                <div  id="aqui<%= +indice%>">
                    <p>
                    <input type="button" name="buttonsm" id="buttonsm" style="color: #1E90FF; float:right" value="+" onclick="edicaoSelecao(id)" />
                    <input type="button" name="<%= +indice%>" id="<%= +indice%>" style="color: #FF0000; float:right" value="X" onclick="removerEdicao(id)" />
                    </p>                             
                    <p>
                        &nbsp; &nbsp;<%= numeroPergunta + " ) "%>
                        <input type="text" name="textfie<%= +indPergunta%>" id="textfie<%= +indPergunta%>" size="100" value="<%= alternativaModel.get(i).getQuestionarioModel().getPergunta()%>" />
                    </p> 
                    <%
                        indPergunta++;
                        numeroPergunta++;
                        for (int j = 0; j < alternativaModel.size(); j++) {
                            if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                    %>
                    <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
                        &nbsp; &nbsp;<input type="text" name="text<%= +indice%>" id="text<%= +indice%>" size="110" value="<%= alternativaModel.get(j).getAlternativa()%>" />  
                        &nbsp; &nbsp;<input type="button" name="buttonsc<%= +indice%>" id="buttonsc<%= +indice%>" style="color: #FF0000 " value="X"  onclick="removerSelecao(id)"/> 
                    </p>
                    <%
                                indice++;
                            }
                        }
                    %>
                </div> 
                <%
                        }
                    }
                    if (3 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                %>
                <div  id="aqui<%= +indice%>">
                    <p>
                    <input type="button" name="buttonsm" id="buttonsm" style="color: #1E90FF; float:right" value="+" onclick="edicaoCaixa(id)" />
                    <input type="button" name="<%= +indice%>" id="<%= +indice%>" style="color: #FF0000; float:right" value="X" onclick="removerEdicao(id)" />
                    </p>  
                    <p>
                        &nbsp; &nbsp;<%= numeroPergunta + " ) "%>
                        <input type="text" name="textfie<%= +indPergunta%>" id="textfie<%= +indPergunta%>" size="100" value="<%= alternativaModel.get(i).getQuestionarioModel().getPergunta()%>" />
                    </p>                 
                    <%
                        indPergunta++;
                        numeroPergunta++;
                        Integer adiciIndice = 1;
                        for (int j = 0; j < alternativaModel.size(); j++) {
                            if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                    %>
                    <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<%= adiciIndice%>
                        <input type="radio" name="RadioGrup<%= +radIndice%>" id="RadioGrup<%= +radIndice%>" value="" /> 
                        <input type="text" name="text<%= +indice%>" id="text<%= +indice%>" size="100" value="<%= alternativaModel.get(j).getAlternativa()%>"/>  
                        <input type="button" name="buttonsc<%= +indice%>" id="buttonsc<%= +indice%>" style="color: #FF0000 " value="X"  onclick="removerCaixa(id)"/> 
                    </p>
                    <%
                                adiciIndice++;
                                indice++;
                            }
                        }
                        radIndice++;
                    %>
                </div>
                <%
                        }
                    }
                    if (2 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                %>
                <div  id="aqui<%= +indice%>">
                    <p>
                        <input type="button" name="buttonsm" id="buttonsm" style="color: #1E90FF; float:right" value="+" onclick="edicao(id)" />
                        <input type="button" name="<%= +indice%>" id="<%= +indice%>" style="color: #FF0000; float:right" value="X" onclick="removerEdicao(id)" />
                    </p>
                    <br /> 
                    <p>
                        &nbsp; &nbsp;<%= numeroPergunta + " ) "%>
                        <input type="text" name="textfie<%= +indPergunta%>" id="textfie<%= +indPergunta%>" size="100" value="<%= alternativaModel.get(i).getQuestionarioModel().getPergunta()%>" />
                    </p> 
                    <%
                        indPergunta++;
                        numeroPergunta++;
                        Integer adiciIndice = 1;
                        for (int j = 0; j < alternativaModel.size(); j++) {
                            if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                    %>                
                    <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<%= adiciIndice%>
                        <input type="checkbox" name="checkbox<%= +indice%>" id="checkbox<%= +indice%>"  />
                        <input type="text" name="textfield<%= +indice%>" id="textfield<%= +indice%>" size="100"  value=" <%= alternativaModel.get(j).getAlternativa()%>"/>
                        <input type="button" name="buttons<%= +indice%>" id="buttons<%= +indice%>" style="color: #FF0000 " value="X" onclick="remover(id)" /> 
                    </p>                
                <%
                            adiciIndice++;
                            indice++;
                        }
                    }
                %>
                </div>
                <%
                        }
                    }

                    if (1 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                %>
                <div  id="aqui<%= +indice%>">
                    <input type="button" name="buttonsm" id="buttonsm" style="color: #1E90FF; float:right" value="+" onclick="edicaoTexto(id)" />
                    <input type="button" name="<%= +indice%>" id="<%= +indice%>" style="color: #FF0000; float:right" value="X" onclick="removerEdicao(id)" />
                    <br />                 
                    <p>
                        &nbsp; &nbsp;<%= numeroPergunta + " ) "%>
                        <input type="text" name="textfie<%= +indPergunta%>" id="textfie<%= +indPergunta%>" size="100" value="<%= alternativaModel.get(i).getQuestionarioModel().getPergunta()%>" />
                    </p> 
                    <p>
                        <textarea name="textarea<%= +indice%>" id= "textextareaarea<%= +indice%>" cols="45" rows="5" size="100" ></textarea>
                    </p> 
                </div>
                <%
                    indPergunta++;
                    numeroPergunta++;
                    indice++;
                %>
                <%
                        }
                    }
                %>
                <input type="hidden" name="tende" id="tende" value="<%= indice%>" />
                <input type="hidden" name="contapergunta" id="contapergunta" value="<%= numeroPergunta%>"/>
                <input type="hidden" name="indipergunta" id="indipergunta" value="<%= indPergunta%>"/>
                <input type="hidden" name="tendeconfere" id="tendeconfere" value="<%= indice%>" /> 
                <%
                    }
                %>
            </form>
        </div>  
    </body>
</html>
