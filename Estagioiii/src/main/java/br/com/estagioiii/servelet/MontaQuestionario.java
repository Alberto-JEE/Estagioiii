/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.servelet;

import br.com.estagioiii.dao.AlternativaDao;
import br.com.estagioiii.dao.CabecalhoDao;
import br.com.estagioiii.dao.RespostaDao;
import br.com.estagioiii.dao.RespostaTextoDao;
import br.com.estagioiii.model.AlternativaModel;
import br.com.estagioiii.model.RespostaModel;
import br.com.estagioiii.model.RespostaTextoModel;
import br.com.estagioiii.model.UsuarioModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MontaQuestionario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (!("").equals(request.getParameter("tende"))) {
            HttpSession session = request.getSession();
            UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
            List<RespostaModel> resposta = new ArrayList<>();
            List<RespostaTextoModel> respostaTexto = new ArrayList<>();
            int compara = -1;
            int indice = 1;
            int radIndice = 1;
            int maiorIndice = RespostaDao.maiorId() + 1;
            List<AlternativaModel> alternativaModel = AlternativaDao.buscaTodasAlternativaUsuario(usuarioModel.getId(),usuarioModel.getIdNovoQuestionario());
            if (!alternativaModel.isEmpty()) {
                alternativaModel.get(0).getQuestionarioModel().getCabecalhoModel().setAuxiliar(true);
                for (int i = 0; i < alternativaModel.size(); i++) {
                    if ((CabecalhoDao.cabecalhoConfere(null, alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().getId(), usuarioModel.getIdNovoQuestionario()) != null) && (alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().isAuxiliar())) {
                        alternativaModel.get(i).getQuestionarioModel().getCabecalhoModel().setAuxiliar(false);
                    }
                    if (6 == (int)alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int)compara != (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int)alternativaModel.get(i).getQuestionarioModel().getId();

                            for (int j = 0; j < alternativaModel.size(); j++) {
                                if ((int)alternativaModel.get(j).getQuestionarioModel().getId() == (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                                    if (request.getParameter("RadioGrup" + radIndice).equalsIgnoreCase(alternativaModel.get(j).getAlternativa())) {// pegar valor do j
                                        RespostaModel respostaModel = new RespostaModel();
                                        respostaModel.setId(maiorIndice);
                                        respostaModel.setAtividadeModel(alternativaModel.get(j));
                                        respostaModel.setUsuarioLogado(usuarioModel.getUsuarioLogadoModel());
                                        resposta.add(respostaModel);
                                        maiorIndice++;
                                    }
                                }
                            }
                            radIndice++;
                            indice++;
                        }
                    }
                    if (5 == (int)alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int)compara != (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int)alternativaModel.get(i).getQuestionarioModel().getId();

                            for (int j = 0; j < alternativaModel.size(); j++) {
                                if ((int)alternativaModel.get(j).getQuestionarioModel().getId() == (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                                    boolean checkbox = Boolean.parseBoolean((request.getParameter("checkbox" + indice) != null ? "true" : "false"));
                                    if (checkbox) {
                                        RespostaModel respostaModel = new RespostaModel();
                                        respostaModel.setId(maiorIndice);
                                        respostaModel.setAtividadeModel(alternativaModel.get(j));
                                        respostaModel.setUsuarioLogado(usuarioModel.getUsuarioLogadoModel());
                                        resposta.add(respostaModel);
                                        maiorIndice++;
                                    }
                                    indice++;
                                }
                            }
                        }
                    }
                    if (4 == (int)alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int)compara != (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int)alternativaModel.get(i).getQuestionarioModel().getId();
                            int seleIndice = indice;
                            for (int j = 0; j < alternativaModel.size(); j++) {
                                if ((int)alternativaModel.get(j).getQuestionarioModel().getId() == (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                                    if (request.getParameter("seleText" + seleIndice).equalsIgnoreCase(alternativaModel.get(j).getAlternativa())) {
                                        RespostaModel respostaModel = new RespostaModel();
                                        respostaModel.setId(maiorIndice);
                                        respostaModel.setAtividadeModel(alternativaModel.get(j));
                                        respostaModel.setUsuarioLogado(usuarioModel.getUsuarioLogadoModel());
                                        resposta.add(respostaModel);
                                        maiorIndice++;
                                    }
                                    indice++;
                                }
                            }
                        }
                    }
                    if (3 == (int)alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int)compara != (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int)alternativaModel.get(i).getQuestionarioModel().getId();

                            for (int j = 0; j < alternativaModel.size(); j++) {
                                if ((int)alternativaModel.get(j).getQuestionarioModel().getId() == (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                                    if (request.getParameter("RadioGrup" + radIndice).equalsIgnoreCase(alternativaModel.get(j).getAlternativa())) {// pegar valor do j
                                        RespostaModel respostaModel = new RespostaModel();
                                        respostaModel.setId(maiorIndice);
                                        respostaModel.setAtividadeModel(alternativaModel.get(j));
                                        respostaModel.setUsuarioLogado(usuarioModel.getUsuarioLogadoModel());
                                        resposta.add(respostaModel);
                                        maiorIndice++;
                                    }
                                }
                            }
                            radIndice++;
                            indice++;
                        }
                    }
                    if (2 == (int)alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if ((int)compara != (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                            compara = (int)alternativaModel.get(i).getQuestionarioModel().getId();

                            for (int j = 0; j < alternativaModel.size(); j++) {
                                if ((int)alternativaModel.get(j).getQuestionarioModel().getId() == (int)alternativaModel.get(i).getQuestionarioModel().getId()) {
                                    boolean checkbox = Boolean.parseBoolean((request.getParameter("checkbox" + indice) != null ? "true" : "false"));
                                    if (checkbox) {
                                        RespostaModel respostaModel = new RespostaModel();
                                        respostaModel.setId(maiorIndice);
                                        respostaModel.setAtividadeModel(alternativaModel.get(j));
                                        respostaModel.setUsuarioLogado(usuarioModel.getUsuarioLogadoModel());
                                        resposta.add(respostaModel);
                                        maiorIndice++;
                                    }
                                    indice++;
                                }
                            }
                        }
                    }

                    if (1 == (int)alternativaModel.get(i).getQuestionarioModel().getTipoQuestionarioModel().getId()) {
                        if (!("").equals(request.getParameter("textarea" + indice))) {
                            RespostaModel respostaModel = new RespostaModel();
                            respostaModel.setId(maiorIndice);
                            respostaModel.setAtividadeModel(alternativaModel.get(i));
                            respostaModel.setUsuarioLogado(usuarioModel.getUsuarioLogadoModel());
                            resposta.add(respostaModel);
                            maiorIndice++;

                            RespostaTextoModel respostaTextoModel = new RespostaTextoModel();
                            respostaTextoModel.setResposta(request.getParameter("textarea" + indice));
                            respostaTextoModel.setRespostaModel(respostaModel);
                            respostaTexto.add(respostaTextoModel);

                        }
                        indice++;
                    }

                }
                if (RespostaDao.autenticacaoResposta(usuarioModel.getId(),usuarioModel.getUsuarioLogadoModel().getId()).isRespondido()) {
                    RespostaTextoDao.deletaRespostasTexto(usuarioModel.getId(), usuarioModel.getUsuarioLogadoModel().getId(),usuarioModel.getIdNovoQuestionario());
                    RespostaDao.deletaRespostas(usuarioModel.getId(), usuarioModel.getUsuarioLogadoModel().getId(),usuarioModel.getIdNovoQuestionario());
                    for (RespostaModel respostaA : resposta) {
                        RespostaDao.insereResposta(respostaA);
                    }
                    for (RespostaTextoModel respostaTX : respostaTexto) {
                        RespostaTextoDao.insereRespostaTexto(respostaTX);
                    }

                } else {
                    for (RespostaModel respostaA : resposta) {
                        RespostaDao.insereResposta(respostaA);
                    }
                    for (RespostaTextoModel respostaTX : respostaTexto) {
                        RespostaTextoDao.insereRespostaTexto(respostaTX);
                    }
                }
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
