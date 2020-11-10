/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.servelet;

import br.com.estagioiii.auxiliares.EnviaEmail;
import br.com.estagioiii.auxiliares.MontaListaEmail;
import br.com.estagioiii.constantes.Mensagens;
import br.com.estagioiii.dao.CabecalhoDao;
import br.com.estagioiii.dao.UsuarioLogadoDao;
import br.com.estagioiii.model.CabecalhoModel;
import br.com.estagioiii.model.EnviaEmailModel;
import br.com.estagioiii.model.UsuarioLogadoModel;
import br.com.estagioiii.model.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsuarioQuestionario extends HttpServlet {

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
        boolean mensagem = false;
        if (MontaListaEmail.conexaoInternet()) {
            HttpSession session = request.getSession();
            UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
            List<CabecalhoModel> cabecalhoModel = CabecalhoDao.buscaTodoCabecalho(usuarioModel.getId());

            EnviaEmailModel enviaEmailModel = new EnviaEmailModel();
            UsuarioLogadoModel usuarioLogado = new UsuarioLogadoModel();
            for (int i = 0; i < cabecalhoModel.size(); i++) {
                if (request.getParameter("seleText").equalsIgnoreCase(cabecalhoModel.get(i).getAssuntoQuestionario())) {
                    usuarioLogado.setNome(cabecalhoModel.get(i).getIdNovoQuestionario());
                    break;
                }
            }
            usuarioLogado.setEmail(MontaListaEmail.montaLista(request.getParameter("textarea")));
            usuarioLogado.setSenha(request.getParameter("Password"));
            usuarioLogado.setUsuarioMode(usuarioModel);
            for (int i = 0; i < usuarioLogado.getEmail().size(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UsuarioQuestionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                usuarioLogado.setEmailLogar(usuarioLogado.getEmail().get(i).toString());
                if (!UsuarioLogadoDao.autenticacaoUsuario(usuarioLogado.getEmailLogar(), usuarioLogado.getSenha(), usuarioModel.getId()).isValidar()) {
                    if (UsuarioLogadoDao.insereUsuarioLogado(usuarioLogado)) {
                        enviaEmailModel.setAssunto("Registro");
                        enviaEmailModel.setDestinos(usuarioLogado.getEmailLogar());
                        enviaEmailModel.setMensagem(usuarioLogado.getNome() + " " + Mensagens.REGISTROCLIENTE + " Email Para Login " + usuarioLogado.getEmailLogar() + " Senha " + usuarioLogado.getSenha());
                        enviaEmailModel.setNomeDestinatario(usuarioLogado.getEmailLogar());
                        EnviaEmail.entregaDeEmail(enviaEmailModel);
                        mensagem = true;
                    }
                }
            }
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cada</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type='text/javascript' >"
                    + "if(" + mensagem + " == true){"
                    + "alert('" + Mensagens.CADASTROCLIENTE + "');"
                    + "window.self.location.href = 'usuarioquestionario.jsp';}else{"
                    + "alert('" + Mensagens.ERROREGISTRO + "') ;"
                    + "window.self.location.href = 'frameprincipal.jsp';}</script> ");
            out.println("</body>");
            out.println("</html>");
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
