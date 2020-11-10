/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.servelet;

import br.com.estagioiii.dao.AlternativaDao;
import br.com.estagioiii.dao.CabecalhoDao;
import br.com.estagioiii.dao.PerguntasDao;
import br.com.estagioiii.dao.TipoQuestionarioDao;
import br.com.estagioiii.model.AlternativaModel;
import br.com.estagioiii.model.CabecalhoModel;
import br.com.estagioiii.model.QuestionarioModel;
import br.com.estagioiii.model.UsuarioModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CaixaCombinacao extends HttpServlet {

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
        if (!("").equalsIgnoreCase(request.getParameter("tende"))) {
            HttpSession session = request.getSession();
            UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
            
            if ((CabecalhoDao.cabecalhoConfere(usuarioModel.getId(), null, usuarioModel.getIdNovoQuestionario()) == null) && (request.getParameter("text2") != null) && (request.getParameter("text3") != null)) {
                CabecalhoModel cabecalhoModel = new CabecalhoModel();
                cabecalhoModel.setTituloQuestionario(request.getParameter("text2"));
                cabecalhoModel.setAssuntoQuestionario(request.getParameter("text3"));
                cabecalhoModel.setUsuarioModel(usuarioModel);
                cabecalhoModel.setIdNovoQuestionario(usuarioModel.getIdNovoQuestionario());
                CabecalhoDao.insereUsuario(cabecalhoModel);
            }
            QuestionarioModel questionarioModel = new QuestionarioModel();
            questionarioModel.setPergunta(request.getParameter("textfie"));
            questionarioModel.setTipoQuestionarioModel(TipoQuestionarioDao.tipoQuestionario(3));
            questionarioModel.setUsuarioModel(usuarioModel);
            questionarioModel.setCabecalhoModel(CabecalhoDao.cabecalhoConfere(usuarioModel.getId(), null, usuarioModel.getIdNovoQuestionario()));
            if (PerguntasDao.insereQuestionario(questionarioModel)) {
                questionarioModel.setId(PerguntasDao.maiorId());
                for (int i = 0; i <= Integer.parseInt(request.getParameter("tende")); i++) {
                    if (request.getParameter("text" + i) != null) {
                        AlternativaModel alternativaModel = new AlternativaModel();
                        alternativaModel.setAlternativa(request.getParameter("text" + i));
                        alternativaModel.setQuestionarioModel(questionarioModel);
                        AlternativaDao.insereAlternativas(alternativaModel);
                    }
                }
                response.sendRedirect("frameprincipal.jsp");
            } else {
                response.sendRedirect("frameprincipal.jsp");
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
