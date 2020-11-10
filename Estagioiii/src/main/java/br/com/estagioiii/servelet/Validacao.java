/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.servelet;

import br.com.estagioiii.dao.UsuarioDao;
import br.com.estagioiii.dao.UsuarioLogadoDao;
import br.com.estagioiii.model.UsuarioLogadoModel;
import br.com.estagioiii.model.UsuarioModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validacao extends HttpServlet {

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

        HttpSession session = request.getSession();

        String user = request.getParameter("Username");
        String pass = request.getParameter("Password");
        UsuarioModel usuarioModel = UsuarioDao.autenticacaoUsuario(user, pass);
        if (usuarioModel.isValidacao()) {
            session.setAttribute("Usuario", usuarioModel);
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            UsuarioLogadoModel usuarioLogado = UsuarioLogadoDao.autenticacaoUsuarioALogar(user, pass);
            if (usuarioLogado.isValidar()) {
                UsuarioModel usuarioLogaModel = UsuarioDao.buscaUsuario(usuarioLogado.getUsuarioMode().getId());
                usuarioLogaModel.setIdNovoQuestionario(usuarioLogado.getNome());
                usuarioLogaModel.setUsuarioLogadoModel(usuarioLogado);
                usuarioLogaModel.setValidacao(false);
                session.setAttribute("Usuario", usuarioLogaModel);
                getServletContext().getRequestDispatcher("/historico.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
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
