/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.dao;

import br.com.estagioiii.conexao.Conexao;
import br.com.estagioiii.model.RespostaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RespostaDao extends Conexao {

    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String sql;

    public static boolean insereResposta(RespostaModel respostaModel) {
        sql = "INSERT INTO respostas (id,alternativa_id,alternativa_questionario_usuario_id,usuariologado_id,alternativa_questionario_idnovoquestionario) VALUES (?,?,?,?,?)";
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                statement.setInt(1, respostaModel.getId());
                statement.setInt(2, respostaModel.getAtividadeModel().getId());
                statement.setInt(3, respostaModel.getAtividadeModel().getQuestionarioModel().getUsuarioModel().getId());
                statement.setInt(4, respostaModel.getUsuarioLogado().getId());
                statement.setInt(5, respostaModel.getAtividadeModel().getQuestionarioModel().getCabecalhoModel().getIdNovoQuestionario());
                statement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(RespostaDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                try {
                    statement.close();
                    desconecta();
                    getCon().close();
                } catch (SQLException ex) {
                    Logger.getLogger(RespostaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static int maiorId() {
        int maiorid = 0;
        getConexao();
        if (getCon() != null) {
            try {
                sql = "Select max(id) FROM respostas";
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    resultSet.first();
                    maiorid = resultSet.getInt(1);
                    return maiorid;
                }
            } catch (Exception e) {
                return maiorid;
            } finally {
                try {
                    statement.close();
                    desconecta();
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RespostaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return maiorid;
    }

    public static RespostaModel buscaResposta(Integer id) {
        sql = "SELECT * FROM respostas WHERE id =" + id;
        RespostaModel respostaModel = new RespostaModel();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    resultSet.first();
                    respostaModel.setId(resultSet.getInt(1));
                    respostaModel.setAtividadeModel(AlternativaDao.buscaTodasAlternativa(resultSet.getInt(2)));
                    respostaModel.setRespondido(true);
                    return respostaModel;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
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

    public static RespostaModel autenticacaoResposta(Integer id, Integer idLogado) {
        sql = "SELECT * FROM respostas WHERE alternativa_questionario_usuario_id =" + id + " and usuariologado_id =" + idLogado;
        RespostaModel respostaModel = new RespostaModel();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    respostaModel.setId(resultSet.getInt(1));
                    respostaModel.setAtividadeModel(AlternativaDao.buscaTodasAlternativa(resultSet.getInt(2)));
                    respostaModel.setRespondido(true);
                    return respostaModel;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                respostaModel.setRespondido(false);
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
        respostaModel.setRespondido(false);
        return respostaModel;
    }

    public static List<RespostaModel> autResposta(Integer id, Integer idLogado) {
        sql = "SELECT * FROM respostas WHERE alternativa_questionario_usuario_id =" + id + " and usuariologado_id =" + idLogado;
        List<RespostaModel> respostaModel = new ArrayList<>();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    RespostaModel model = new RespostaModel();
                    model.setId(resultSet.getInt(1));
                    model.setAtividadeModel(AlternativaDao.buscaTodasAlternativa(resultSet.getInt(2)));
                    model.setUsuarioLogado(null);
                    model.setRespondido(true);
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

    public static List<RespostaModel> calculaResposta(Integer id, Integer idNovoQuestionario) {
        sql = "SELECT * FROM respostas WHERE  alternativa_questionario_usuario_id =" + id + " and alternativa_questionario_idnovoquestionario =" + idNovoQuestionario;
        List<RespostaModel> respostaModel = new ArrayList<>();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    RespostaModel model = new RespostaModel();
                    model.setId(resultSet.getInt(1));
                    model.setAtividadeModel(AlternativaDao.buscaTodasAlternativa(resultSet.getInt(2)));
                    model.setUsuarioLogado(null);
                    model.setRespondido(true);
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

    public static boolean alteraResposta(RespostaModel model) {
        getConexao();
        if (getCon() != null) {
            sql = "UPDATE respostas SET alternativa_id = ?, alternativa_questionario_usuario_id = ?, usuariologado_id = ? WHERE id = " + model.getId();
            try {
                statement = getCon().prepareStatement(sql);
                statement.setInt(1, model.getAtividadeModel().getId());
                statement.setInt(2, model.getAtividadeModel().getQuestionarioModel().getUsuarioModel().getId());
                statement.setInt(3, model.getUsuarioLogado().getId());
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

    public static void deletaRespostas(Integer id, Integer idLogado, Integer idNovoQuestionario) {
        getConexao();
        if (getCon() != null) {
            sql = "DELETE FROM respostas WHERE id > 0 and  alternativa_questionario_usuario_id =" + id + " and  usuariologado_id =" + idLogado + " and alternativa_questionario_idnovoquestionario =" + idNovoQuestionario;
            try {
                statement = getCon().prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException e) {
            } finally {
                try {
                    statement.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(RespostaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
     public static void excluiRespostas(Integer id,Integer idNovoQuestionario) {
        getConexao();
        if (getCon() != null) {
            sql = "DELETE FROM respostas WHERE id > 0 and  alternativa_questionario_usuario_id =" + id + " and alternativa_questionario_idnovoquestionario =" + idNovoQuestionario;
            try {
                statement = getCon().prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException e) {
            } finally {
                try {
                    statement.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(RespostaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
