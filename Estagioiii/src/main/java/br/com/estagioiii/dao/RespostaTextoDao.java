/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.dao;

import br.com.estagioiii.conexao.Conexao;
import static br.com.estagioiii.conexao.Conexao.desconecta;
import static br.com.estagioiii.conexao.Conexao.getCon;
import static br.com.estagioiii.conexao.Conexao.getConexao;
import br.com.estagioiii.model.RespostaTextoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RespostaTextoDao extends Conexao {

    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String sql;

    public static boolean insereRespostaTexto(RespostaTextoModel respostaTextoModel) {
        sql = "INSERT INTO respostatexto (resposta,respostas_id,respostas_alternativa_questionario_usuario_id,usuariologado_id,respostas_alternativa_questionario_idnovoquestionario) VALUES (?,?,?,?,?)";
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                String resposta = respostaTextoModel.getResposta().replaceAll("^\\s+","");
                resposta = resposta.replaceAll("\\s+$","");
                statement.setString(1, resposta);
                statement.setInt(2, respostaTextoModel.getRespostaModel().getId());
                statement.setInt(3, respostaTextoModel.getRespostaModel().getAtividadeModel().getQuestionarioModel().getUsuarioModel().getId());
                statement.setInt(4, respostaTextoModel.getRespostaModel().getUsuarioLogado().getId());
                statement.setInt(5, respostaTextoModel.getRespostaModel().getAtividadeModel().getQuestionarioModel().getCabecalhoModel().getIdNovoQuestionario());
                statement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(RespostaTextoDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                try {
                    statement.close();
                    desconecta();
                    getCon().close();
                } catch (SQLException ex) {
                    Logger.getLogger(RespostaTextoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static boolean alteraTextoResposta(RespostaTextoModel model) {
        getConexao();
        if (getCon() != null) {
            sql = "UPDATE respostatexto SET resposta = ?, respostas_id = ? WHERE respostas_id = " + model.getRespostaModel().getId();
            try {
                statement = getCon().prepareStatement(sql);
                statement.setString(1, model.getResposta());
                statement.setInt(2, model.getRespostaModel().getId());
                statement.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            } finally {
                try {
                    statement.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(RespostaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static void deletaRespostasTexto(Integer id, Integer idLogado, Integer idNovoQuestionario) {
        getConexao();
        if (getCon() != null) {
            sql = "DELETE FROM respostatexto WHERE id > 0 and respostas_alternativa_questionario_usuario_id =" + id + " and  usuariologado_id =" + idLogado + " and respostas_alternativa_questionario_idnovoquestionario =" + idNovoQuestionario;
            try {
                statement = getCon().prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException e) {
            } finally {
                try {
                    statement.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(RespostaTextoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void excluiRespostasTexto(Integer id,Integer idNovoQuestionario) {
        getConexao();
        if (getCon() != null) {
            sql = "DELETE FROM respostatexto WHERE id > 0 and respostas_alternativa_questionario_usuario_id =" + id + " and respostas_alternativa_questionario_idnovoquestionario =" + idNovoQuestionario;
            try {
                statement = getCon().prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException e) {
            } finally {
                try {
                    statement.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(RespostaTextoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static List<RespostaTextoModel> autRespostaTexto(Integer id, Integer idLogado, Integer idNovoQuestionario) {
        sql = "SELECT * FROM respostatexto WHERE respostas_alternativa_questionario_usuario_id =" + id + " and usuariologado_id =" + idLogado + " and respostas_alternativa_questionario_idnovoquestionario =" + idNovoQuestionario;
        List<RespostaTextoModel> respostaModel = new ArrayList<>();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    RespostaTextoModel model = new RespostaTextoModel();
                    model.setId(resultSet.getInt(1));
                    model.setResposta(resultSet.getString(2));
                    model.setRespostaModel(RespostaDao.buscaResposta(resultSet.getInt(3)));
                    respostaModel.add(model);
                }
                return respostaModel;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                return respostaModel;
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return respostaModel;
    }

    public static List<RespostaTextoModel> calculaRespostaTexto(Integer id, Integer idNovoQuestionario) {
        sql = "SELECT * FROM respostatexto WHERE respostas_alternativa_questionario_usuario_id =" + id + " and respostas_alternativa_questionario_idnovoquestionario =" + idNovoQuestionario;
        List<RespostaTextoModel> respostaModel = new ArrayList<>();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    RespostaTextoModel model = new RespostaTextoModel();
                    model.setId(resultSet.getInt(1));
                    model.setResposta(resultSet.getString(2));
                    model.setRespostaModel(RespostaDao.buscaResposta(resultSet.getInt(3)));
                    respostaModel.add(model);
                }
                return respostaModel;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                return respostaModel;
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return respostaModel;
    }
}
