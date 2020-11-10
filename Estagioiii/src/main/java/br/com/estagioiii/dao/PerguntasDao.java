/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.dao;

import br.com.estagioiii.conexao.Conexao;
import br.com.estagioiii.model.QuestionarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerguntasDao extends Conexao {

    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String sql;

    public static boolean insereQuestionario(QuestionarioModel questionarioModel) {
        sql = "INSERT INTO questionario (pergunta,tipoalternativa_id,usuario_id,cabecalho_id,idnovoquestionario) VALUES (?,?,?,?,?)";
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                statement.setString(1, questionarioModel.getPergunta());
                statement.setInt(2, questionarioModel.getTipoQuestionarioModel().getId());
                statement.setInt(3, questionarioModel.getUsuarioModel().getId());
                statement.setInt(4, questionarioModel.getCabecalhoModel().getId());
                statement.setInt(5, questionarioModel.getCabecalhoModel().getIdNovoQuestionario());
                statement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(PerguntasDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                try {
                    statement.close();
                    desconecta();
                    getCon().close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
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
                sql = "Select max(id) FROM questionario";
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
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return maiorid;
    }

    public static QuestionarioModel buscaQuestionario(Integer questionario) {
        QuestionarioModel questionarioModel = new QuestionarioModel();
        getConexao();
        if (getCon() != null) {
            sql = "SELECT * FROM QUESTIONARIO WHERE id = " + questionario + " ORDER BY id ASC";
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    resultSet.first();
                    questionarioModel.setId(resultSet.getInt(1));
                    questionarioModel.setPergunta(resultSet.getString(2));
                    questionarioModel.setTipoQuestionarioModel(TipoQuestionarioDao.tipoQuestionario(resultSet.getInt(3)));
                    questionarioModel.setUsuarioModel(UsuarioDao.buscaUsuario(resultSet.getInt(4)));
                    questionarioModel.setCabecalhoModel(CabecalhoDao.cabecalhoConfere(null, resultSet.getInt(5), resultSet.getInt(6)));
                    return questionarioModel;
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    statement.close();
                    desconecta();
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return questionarioModel;
    }

    public static void deletaPergunta(Integer id, Integer idNovoQuestionario) {
        getConexao();
        if (getCon() != null) {
            sql = "DELETE FROM questionario WHERE id > 0 and usuario_id =" + id + " and idnovoquestionario =" + idNovoQuestionario;
            try {
                statement = getCon().prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException e) {
            } finally {
                try {
                    statement.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(AlternativaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
        public static List<QuestionarioModel> autQuestionario(Integer id, Integer idNovoQuestionario) {
        sql = "SELECT * FROM questionario WHERE usuario_id =" + id + " and idnovoquestionario =" + idNovoQuestionario;
        List<QuestionarioModel> questionarioModels = new ArrayList<>();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    QuestionarioModel questionarioModel = new QuestionarioModel();
                    questionarioModel.setId(resultSet.getInt(1));
                    questionarioModel.setPergunta(resultSet.getString(2));
                    questionarioModel.setTipoQuestionarioModel(TipoQuestionarioDao.tipoQuestionario(resultSet.getInt(3)));
                    questionarioModel.setUsuarioModel(UsuarioDao.buscaUsuario(resultSet.getInt(4)));
                    questionarioModel.setCabecalhoModel(CabecalhoDao.cabecalhoConfere(null, resultSet.getInt(5), resultSet.getInt(6)));
                    questionarioModels.add(questionarioModel);
                }
                return questionarioModels;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                return questionarioModels;
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
        return questionarioModels;
    }
}
