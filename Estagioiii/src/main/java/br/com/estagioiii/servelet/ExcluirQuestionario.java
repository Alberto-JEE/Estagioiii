/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.servelet;

import br.com.estagioiii.dao.AlternativaDao;
import br.com.estagioiii.dao.CabecalhoDao;
import br.com.estagioiii.dao.PerguntasDao;
import br.com.estagioiii.dao.RespostaDao;
import br.com.estagioiii.dao.RespostaTextoDao;
import br.com.estagioiii.model.UsuarioModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExcluirQuestionario extends HttpServlet {

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
        if (!request.getParameter("idCabecalho").equalsIgnoreCase("")) {
            HttpSession session = request.getSession();
            UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
            usuarioModel.setIdNovoQuestionario(Integer.parseInt(request.getParameter("idCabecalho")));
            RespostaTextoDao.excluiRespostasTexto(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
            RespostaDao.excluiRespostas(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
            AlternativaDao.deletaAlternativa(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
            PerguntasDao.deletaPergunta(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
            CabecalhoDao.deletaCabecalho(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
            response.sendRedirect("cabecalho.jsp");
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
