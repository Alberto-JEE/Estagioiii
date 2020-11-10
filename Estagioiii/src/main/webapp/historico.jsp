

<%@page import="br.com.estagioiii.dao.RespostaTextoDao"%>
<%@page import="br.com.estagioiii.model.RespostaTextoModel"%>
<%@page import="br.com.estagioiii.dao.RespostaDao"%>
<%@page import="br.com.estagioiii.model.RespostaModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.estagioiii.dao.AlternativaDao"%>
<%@page import="br.com.estagioiii.model.AlternativaModel"%>
<%@page import="java.util.List"%>
<%@page import="br.com.estagioiii.dao.CabecalhoDao"%>
<%@page import="br.com.estagioiii.model.UsuarioModel"%>
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/index.js"></script>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <link rel="stylesheet" type="text/css" href="css/styles.css" />  
        <title>Histórico</title>
    </head>
    <body>
        <div id="main">
            <form name="formulario" id="formulario" method="post" action="Questionario" style="background-color: #FFFFE0" onsubmit="return validarHistorico()" >  
                <ul id="holder">

                    <%
                        UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
                        List<RespostaModel> respostaModel = RespostaDao.autResposta(usuarioModel.getId(), usuarioModel.getUsuarioLogadoModel().getId());
                        List<RespostaTextoModel> respostaTextoModel = RespostaTextoDao.autRespostaTexto(usuarioModel.getId(), usuarioModel.getUsuarioLogadoModel().getId(), usuarioModel.getIdNovoQuestionario());
                        List<AlternativaModel> alternativaModel = AlternativaDao.buscaTodasAlternativaUsuario(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
                    if (!alternativaModel.isEmpty()) {
                            Integer numeroPergunta = 1;
                            int indice = 1;
                            int compara = -1;
                            int radIndice = 1;
                            alternativaModel.get(0).getQuestionarioModel().getCabecalhoModel().setAuxiliar(true);
                            for (int i = 0; i < alternativaModel.size(); i++) {
                                if ((CabecalhoDao.cabecalhoConfere(null, alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().getId(), usuarioModel.getIdNovoQuestionario()) != null) && (alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().isAuxiliar())) {
                    %>
                    <li>
                        <h1 style = "text-align:center; color: #0196e3;"><%= alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().getTituloQuestionario()%></h1>
                        <p  style = "text-align:center; color: #111111;"><%= alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().getAssuntoQuestionario()%></p>
                        <% alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().setAuxiliar(false);
                        %>
                    </li>
                    <%
                        }
                        if (6 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                            if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                                compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                    %>
                    <li>
                        <p>
                            <strong>&nbsp; &nbsp;
                                <%= numeroPergunta + " ) " + alternativaModel.get(i).getQuestionarioModel().getPergunta()%>
                            </strong>
                        </p>
                        <br/>
                        <%numeroPergunta++;
                            Integer adiciIndice = 1;
                        %>                            
                        <div  id="aqui<%= +indice%>">
                            <%
                                for (int j = 0; j < alternativaModel.size(); j++) {
                                    if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                            %>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<%= adiciIndice%>
                            <input type="radio" name="RadioGrup<%= +radIndice%>" id="RadioGrup<%= +radIndice%>" value="<%= alternativaModel.get(j).getAlternativa()%>" 
                                   <%
                                       if (((!respostaModel.isEmpty()) && (usuarioModel.isValidacao())) || ((!respostaModel.isEmpty()) && (usuarioModel.getUsuarioLogadoModel().isValidar()))) {
                                           for (int n = 0; n < respostaModel.size(); n++) {
                                               if ((int) alternativaModel.get(j).getId() == (int) respostaModel.get(n).getAtividadeModel().getId()) {%>
                                   checked
                                   <%
                                               }
                                           }
                                       }
                                   %>
                                   /> <%= alternativaModel.get(j).getAlternativa()%>
                            <%
                                        adiciIndice++;
                                    }
                                }
                            %>
                        </div>
                        <%
                            radIndice++;
                            indice++;
                        %>
                    </li>
                    <%
                            }
                        }
                        if (5 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                            if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                                compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                    %>
                    <li>
                        <p>
                            <strong>&nbsp; &nbsp;
                                <%= numeroPergunta + " ) " + alternativaModel.get(i).getQuestionarioModel().getPergunta()%>
                            </strong>
                        </p>
                        <br/>
                        <%numeroPergunta++;
                            Integer adiciIndice = 1;
                        %>                            
                        <div  id="aqui<%= +indice%>">
                            <%
                                for (int j = 0; j < alternativaModel.size(); j++) {
                                    if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                            %>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<%= adiciIndice%>
                            <input type="checkbox" name="checkbox<%= +indice%>" id="checkbox<%= +indice%>"  />
                            <%= alternativaModel.get(j).getAlternativa()%>
                            <%
                                if (((!respostaModel.isEmpty()) && (usuarioModel.isValidacao())) || ((!respostaModel.isEmpty()) && (usuarioModel.getUsuarioLogadoModel().isValidar()))) {
                                    for (int n = 0; n < respostaModel.size(); n++) {
                                        if ((int) alternativaModel.get(j).getId() == (int) respostaModel.get(n).getAtividadeModel().getId()) {%>
                            <script>
                                marcadores("checkbox<%= +indice%>");
                            </script>
                            <%
                                                }
                                            }
                                        }
                                        indice++;
                                        adiciIndice++;
                                    }
                                }%>
                        </div>
                    </li>
                    <% }
                        }
                        if (4 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                            if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                                compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                    %>
                    <li>
                        <p>
                            <strong>&nbsp; &nbsp;
                                <%= numeroPergunta + " ) " + alternativaModel.get(i).getQuestionarioModel().getPergunta()%>
                            </strong>
                        </p>
                        <br/>
                        <div  id="aqui<%= +indice%>">
                            <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
                                <select name="seleText<%= +indice%>" id="seleText<%= +indice%>" >
                                    <%numeroPergunta++;
                                        for (int j = 0; j < alternativaModel.size(); j++) {
                                            if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                                    %>
                                    <option name="opcoa<%= +indice%>" id="opcao<%= +indice%>" value="<%= alternativaModel.get(j).getAlternativa()%>"
                                            <%
                                                if (((!respostaModel.isEmpty()) && (usuarioModel.isValidacao())) || ((!respostaModel.isEmpty()) && (usuarioModel.getUsuarioLogadoModel().isValidar()))) {
                                                    for (int n = 0; n < respostaModel.size(); n++) {
                                                        if ((int) alternativaModel.get(j).getId() == (int) respostaModel.get(n).getAtividadeModel().getId()) {%>
                                            selected
                                            <%
                                                        }
                                                    }
                                                }
                                            %>
                                            > <%= alternativaModel.get(j).getAlternativa()%> </option>
                                    <%
                                                indice++;
                                            }
                                        }
                                    %>

                                </select>
                            </p>
                        </div>                                  
                    </li>
                    <%
                            }
                        }
                        if (3 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                            if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                                compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                    %>
                    <li>
                        <p>
                            <strong>&nbsp; &nbsp;
                                <%= numeroPergunta + " ) " + alternativaModel.get(i).getQuestionarioModel().getPergunta()%> 
                            </strong>
                        </p>
                        <br/>
                        <div  id="aqui<%= +indice%>">
                            <%numeroPergunta++;
                                Integer adiciIndice = 1;
                                for (int j = 0; j < alternativaModel.size(); j++) {
                                    if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                            %>
                            <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<%= adiciIndice%>
                                <input type="radio" name="RadioGrup<%= +radIndice%>" id="RadioGrup<%= +radIndice%>" value="<%= alternativaModel.get(j).getAlternativa()%>" 
                                       <%
                                           if (((!respostaModel.isEmpty()) && (usuarioModel.isValidacao())) || ((!respostaModel.isEmpty()) && (usuarioModel.getUsuarioLogadoModel().isValidar()))) {
                                               for (int n = 0; n < respostaModel.size(); n++) {
                                                   if ((int) alternativaModel.get(j).getId() == (int) respostaModel.get(n).getAtividadeModel().getId()) {%>
                                       checked
                                       <%
                                                   }
                                               }
                                           }
                                       %>
                                       /> <%= alternativaModel.get(j).getAlternativa()%>
                            </p>
                            <%
                                        adiciIndice++;

                                    }
                                }
                                indice++;
                                radIndice++;
                            %>
                        </div>
                    </li>
                    <%
                            }
                        }
                        if (2 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                            if ((int) compara != (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                                compara = (int) alternativaModel.get(i).getQuestionarioModel().getId();
                    %>
                    <li>
                        <p>
                            <strong>&nbsp; &nbsp;
                                <%= numeroPergunta + " ) " + alternativaModel.get(i).getQuestionarioModel().getPergunta()%>
                            </strong>
                        </p>
                        <br/>
                        <%numeroPergunta++;
                            Integer adiciIndice = 1;
                            for (int j = 0; j < alternativaModel.size(); j++) {
                                if ((int) alternativaModel.get(j).getQuestionarioModel().getId() == (int) alternativaModel.get(i).getQuestionarioModel().getId()) {
                        %>
                        <div  id="aqui<%= +indice%>">
                            <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<%= adiciIndice%>
                                <input type="checkbox" name="checkbox<%= +indice%>" id="checkbox<%= +indice%>"  />
                                <%= alternativaModel.get(j).getAlternativa()%>
                            </p>
                        </div>
                        <%
                            if (((!respostaModel.isEmpty()) && (usuarioModel.isValidacao())) || ((!respostaModel.isEmpty()) && (usuarioModel.getUsuarioLogadoModel().isValidar()))) {
                                for (int n = 0; n < respostaModel.size(); n++) {
                                    if ((int) alternativaModel.get(j).getId() == (int) respostaModel.get(n).getAtividadeModel().getId()) {%>
                        <script>
                            marcadores("checkbox<%= +indice%>");
                        </script>
                        <%
                                            }
                                        }
                                    }
                                    adiciIndice++;
                                    indice++;
                                }
                            }
                        %>
                    </li>
                    <%
                            }
                        }

                        if (1 == (int) alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                    %>
                    <li>
                        <div  id="aqui<%= +indice%>">
                            <p>
                                <strong>&nbsp; &nbsp;
                                    <%= numeroPergunta + " ) " + alternativaModel.get(i).getQuestionarioModel().getPergunta()%> 
                                </strong>
                            </p>
                            <br/>
                            <p>
                                <textarea name="textarea<%= +indice%>" id= "textextareaarea<%= +indice%>" cols="45" rows="5" size="100" ><%
                                        if (((!respostaModel.isEmpty()) && (usuarioModel.isValidacao())) || ((!respostaModel.isEmpty()) && (usuarioModel.getUsuarioLogadoModel().isValidar()))) {
                                            for (int n = 0; n < respostaModel.size(); n++) {
                                                if ((int) alternativaModel.get(i).getId() == (int) respostaModel.get(n).getAtividadeModel().getId()) {
                                                    for (int m = 0; m < respostaTextoModel.size(); m++) {
                                                        if ((int) respostaTextoModel.get(m).getRespostaModel().getId() == (int) respostaModel.get(n).getId()) {
                                    %><%= respostaTextoModel.get(m).getResposta()%><%
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    %>
                                </textarea>
                            </p> 
                        </div>
                        <%
                            numeroPergunta++;
                            indice++;
                        %>
                    </li>
                    <%
                            }
                        }
                    %>
                    </ul>
                    <input type="hidden" name="tende" id="tende" value="<%= indice%>" />                            
                    <%
                        }
                    %>                
                <br/>
                <input  type="submit" id="cadastrar"  value="Salvar" style="float:right;"  />
            </form>
        </div>  
    </body>
</html>
