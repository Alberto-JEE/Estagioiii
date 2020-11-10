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
import br.com.estagioiii.model.AlternativaModel;
import br.com.estagioiii.model.CabecalhoModel;
import br.com.estagioiii.model.CalculaModel;
import br.com.estagioiii.model.QuestionarioModel;
import br.com.estagioiii.model.RelatorioEspecificoInternoModel;
import br.com.estagioiii.model.RelatorioEspecificoModel;
import br.com.estagioiii.model.RelatorioRespostaModel;
import br.com.estagioiii.model.RespostaModel;
import br.com.estagioiii.model.RespostaTextoModel;
import br.com.estagioiii.model.UsuarioModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alberto
 */
public class RelatorioResposta extends HttpServlet {

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
        UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("Usuario");
        List<CabecalhoModel> cabecalhoModel = CabecalhoDao.buscaTodoCabecalho(usuarioModel.getId());
        for (int i = 0; i < cabecalhoModel.size(); i++) {
            if (request.getParameter("seleText").equalsIgnoreCase(cabecalhoModel.get(i).getAssuntoQuestionario())) {
                usuarioModel.setIdNovoQuestionario(cabecalhoModel.get(i).getIdNovoQuestionario());
                break;
            }
        }
        List<RelatorioRespostaModel> relatorioRespostaModels = new ArrayList<>();
        List<RespostaModel> respostaModel = RespostaDao.calculaResposta(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
        List<RespostaModel> auxModel = RespostaDao.calculaResposta(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());

        List<CalculaModel> calculaModel = new ArrayList<>();
        int indiceCalcula = 0;
        if ((!respostaModel.isEmpty())&&(request.getParameter("seleTextOpcao").equalsIgnoreCase("Geral"))) {
            RelatorioRespostaModel relatResposta = new RelatorioRespostaModel();
            relatResposta.setCabecalho(respostaModel.get(0).getAtividadeModel().getQuestionarioModel().getCabecalhoModel().getTituloQuestionario());
            relatResposta.setSubCabecalho(respostaModel.get(0).getAtividadeModel().getQuestionarioModel().getCabecalhoModel().getAssuntoQuestionario());
            relatResposta.setNomeAdministrador(usuarioModel.getNome());
            relatorioRespostaModels.add(relatResposta);
            for (int i = 0; i < respostaModel.size(); i++) {
                for (int j = 0; j < respostaModel.size(); j++) {
                    if ((int) respostaModel.get(i).getAtividadeModel().getId() == (int) auxModel.get(j).getAtividadeModel().getId()) {
                        auxModel.get(j).getAtividadeModel().setId(-1);
                        indiceCalcula++;
                    }
                }
                if (indiceCalcula != 0) {
                    CalculaModel calcula = new CalculaModel();
                    calcula.setAlternativaId(respostaModel.get(i).getAtividadeModel().getId());
                    calcula.setQuestionarioId(respostaModel.get(i).getAtividadeModel().getQuestionarioModel().getId());
                    calcula.setQuantidadeRespostaAlternativa(indiceCalcula);
                    calculaModel.add(calcula);
                    RelatorioRespostaModel relatorioResposta = new RelatorioRespostaModel();
                    relatorioResposta.setAlternativa(respostaModel.get(i).getAtividadeModel().getAlternativa());
                    relatorioResposta.setTipoPergunta(respostaModel.get(i).getAtividadeModel().getQuestionarioModel().getTipoQuestionarioModel().getTipoQuestionario());
                    relatorioResposta.setRespostas(String.valueOf(indiceCalcula));
                    relatorioResposta.setNomePergunta(respostaModel.get(i).getAtividadeModel().getQuestionarioModel().getPergunta());
                    relatorioRespostaModels.add(relatorioResposta);
                    indiceCalcula = 0;
                }
            }
            if (!relatorioRespostaModels.isEmpty()) {
                try {
                    String acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");
                    System.out.println("Ação " + acao);
                    acao = "pdf";

                    String caminhoJasper = getServletContext().getRealPath("/WEB-INF/classes/br/com/estagioiii/relatorio") + "/";
                    String caminho = getServletContext().getRealPath("/");

                    JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(relatorioRespostaModels);
                    Map parametros = new HashMap();
                    parametros.put("titulo", "Relatórios de Respostas");
                    parametros.put(relatorioRespostaModels, jrDT);
                    parametros.put("total", "Total de Avaliadores: " + relatorioRespostaModels.size());
                    JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "clientes.jasper", parametros, jrDT);

                    if ("visualizar".equals(acao)) {
                        JasperViewer.viewReport(jasperPrint, false);
                    } else if ("pdf".equals(acao)) {
                        try (FileOutputStream fos = new FileOutputStream(caminho + "/relatoriodiversos/RelatorioAvaliador.pdf")) {
                            JasperExportManager.exportReportToPdfStream(jasperPrint, fos);
                            fos.flush();
                        } catch (FileNotFoundException e) {
                            System.err.println("erro");
                        } catch (IOException ex) {
                            Logger.getLogger(RelatorioResposta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        response.sendRedirect("relatoriodiversos/RelatorioAvaliador.pdf");
                    } else {
                        response.sendRedirect("home.jsp");
                    }
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }
        }
        List<AlternativaModel> alternativaModel = AlternativaDao.buscaTodasAlternativaUsuario(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
        List<AlternativaModel> alternativaAuxiliar = AlternativaDao.buscaTodasAlternativaUsuario(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
        List<RelatorioEspecificoModel> relatorioEspecifico = new ArrayList<>();
        List<QuestionarioModel> questionarioModels = PerguntasDao.autQuestionario(usuarioModel.getId(), usuarioModel.getIdNovoQuestionario());
        if ((!respostaModel.isEmpty())&&(request.getParameter("seleTextOpcao").equalsIgnoreCase("Específico"))) {
            RelatorioEspecificoModel relatEspecificoResposta = new RelatorioEspecificoModel();
            relatEspecificoResposta.setCabecalho(respostaModel.get(0).getAtividadeModel().getQuestionarioModel().getCabecalhoModel().getTituloQuestionario());
            relatEspecificoResposta.setSubCabecalho(respostaModel.get(0).getAtividadeModel().getQuestionarioModel().getCabecalhoModel().getAssuntoQuestionario());
            relatEspecificoResposta.setNomeAdministrador(usuarioModel.getNome());
            relatorioEspecifico.add(relatEspecificoResposta);

            for (int k = 0; k < questionarioModels.size(); k++) {
                List<RelatorioEspecificoInternoModel> relatorioEspecificoInternoModel = new ArrayList<>();
                for (int i = 0; i < alternativaModel.size(); i++) {
                    for (int j = 0; j < respostaModel.size(); j++) {
                        if ((((int)respostaModel.get(j).getAtividadeModel().getId()) == ((int)alternativaModel.get(i).getId())) && ((int)respostaModel.get(j).getAtividadeModel().getQuestionarioModel().getId() == (int)(questionarioModels.get(k).getId()))) {
                            respostaModel.get(j).setId(-1);
                            indiceCalcula++;
                        }
                    }
                    if (indiceCalcula != 0) {
                        RelatorioEspecificoInternoModel relatorioEspeciInternoResposta = new RelatorioEspecificoInternoModel();
                        relatorioEspeciInternoResposta.setAlternativa(alternativaAuxiliar.get(i).getAlternativa());
                        relatorioEspeciInternoResposta.setQuantidadeRespondido(String.valueOf(indiceCalcula));
                        relatorioEspecificoInternoModel.add(relatorioEspeciInternoResposta);
                        alternativaModel.get(i).setId(-1);
                        indiceCalcula = 0;
                    }
                }
                for (int i = 0; i < alternativaModel.size(); i++) {
                    for (int j = 0; j < alternativaAuxiliar.size(); j++) {
                        if (((int)alternativaAuxiliar.get(j).getId() == ((int)alternativaModel.get(i).getId())) && ((int)alternativaAuxiliar.get(j).getQuestionarioModel().getId() == ((int)questionarioModels.get(k).getId()))) {
                            RelatorioEspecificoInternoModel relatorioEspeciInternoResposta = new RelatorioEspecificoInternoModel();
                            relatorioEspeciInternoResposta.setAlternativa(alternativaAuxiliar.get(i).getAlternativa());
                            relatorioEspeciInternoResposta.setQuantidadeRespondido("0");
                            relatorioEspecificoInternoModel.add(relatorioEspeciInternoResposta);
                            alternativaModel.get(i).setId(-1);
                        }
                    }                    
                }
                RelatorioEspecificoModel relatorioEspeciModel = new RelatorioEspecificoModel();
                relatorioEspeciModel.setTipoPergunta(questionarioModels.get(k).getTipoQuestionarioModel().getTipoQuestionario());
                relatorioEspeciModel.setNomePergunta(questionarioModels.get(k).getPergunta());
                relatorioEspeciModel.setAlternativa(relatorioEspecificoInternoModel);
                relatorioEspecifico.add(k + 1, relatorioEspeciModel);
            }
            if (!relatorioEspecifico.isEmpty()) {
                try {
                    String acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");
                    System.out.println("Ação " + acao);
                    acao = "pdf";

                    String caminhoJasper = getServletContext().getRealPath("/WEB-INF/classes/br/com/estagioiii/relatorio") + "/";
                    String caminho = getServletContext().getRealPath("/");

                    JRBeanCollectionDataSource jrDT = new JRBeanCollectionDataSource(relatorioEspecifico);
                    Map parametros = new HashMap();
                    parametros.put("titulo", "Relatórios Específicos");
                    parametros.put(relatorioEspecifico, jrDT);
                    parametros.put("total", "Total de Avaliadores: " + relatorioEspecifico.size());
                    JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoJasper + "clientesespecifico.jasper", parametros, jrDT);

                    if ("visualizar".equals(acao)) {
                        JasperViewer.viewReport(jasperPrint, false);
                    } else if ("pdf".equals(acao)) {
                        try (FileOutputStream fos = new FileOutputStream(caminho + "/relatoriodiversos/RelatorioEspecifico.pdf")) {
                            JasperExportManager.exportReportToPdfStream(jasperPrint, fos);
                            fos.flush();
                        } catch (FileNotFoundException e) {
                            System.err.println("erro");
                        } catch (IOException ex) {
                            Logger.getLogger(RelatorioResposta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        response.sendRedirect("relatoriodiversos/RelatorioEspecifico.pdf");
                    } else {
                        response.sendRedirect("home.jsp");
                    }
                } catch (JRException e) {
                    e.printStackTrace();
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
