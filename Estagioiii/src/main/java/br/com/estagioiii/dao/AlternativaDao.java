/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.dao;

import br.com.estagioiii.conexao.Conexao;
import br.com.estagioiii.model.AlternativaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlternativaDao extends Conexao {

    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String sql;

    public static boolean insereAlternativas(AlternativaModel alternativaModel) {
        sql = "INSERT INTO alternativa (alternativa,questionario_id,questionario_usuario_id,questionario_idnovoquestionario) VALUES (?,?,?,?)";
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                statement.setString(1, alternativaModel.getAlternativa());
                statement.setInt(2, alternativaModel.getQuestionarioModel().getId());
                statement.setInt(3, alternativaModel.getQuestionarioModel().getUsuarioModel().getId());
                statement.setInt(4, alternativaModel.getQuestionarioModel().getCabecalhoModel().getIdNovoQuestionario());
                statement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(PerguntasDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                try {
                    statement.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static List<AlternativaModel> buscaTodasAlternativaUsuario(Integer codigoUsuario, Integer idNovoQuestionario) {
        List<AlternativaModel> alternativa = new ArrayList<>();
        getConexao();
        if (getCon() != null) {
            sql = "SELECT * FROM alternativa WHERE questionario_usuario_id = " + codigoUsuario + " and questionario_idnovoquestionario = " + idNovoQuestionario + " ORDER BY id ASC";
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    AlternativaModel model = new AlternativaModel();
                    model.setId(resultSet.getInt(1));
                    model.setAlternativa(resultSet.getString(2));
                    model.setQuestionarioModel(PerguntasDao.buscaQuestionario(resultSet.getInt(3)));
                    alternativa.add(model);
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(AlternativaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return alternativa;
    }

    public static AlternativaModel buscaTodasAlternativa(Integer alternativaId) {
        AlternativaModel alternativa = new AlternativaModel();
        getConexao();
        if (getCon() != null) {
            sql = "SELECT * FROM alternativa WHERE id = " + alternativaId + " ORDER BY id ASC";
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    resultSet.first();
                    alternativa.setId(resultSet.getInt(1));
                    alternativa.setAlternativa(resultSet.getString(2));
                    alternativa.setQuestionarioModel(PerguntasDao.buscaQuestionario(resultSet.getInt(3)));
                    return alternativa;
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(AlternativaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return alternativa;
    }

    public static void deletaAlternativa(Integer id, Integer idNovoQuestionario) {
        getConexao();
        if (getCon() != null) {
            sql = "DELETE FROM alternativa WHERE id > 0 and questionario_usuario_id =" + id + " and questionario_idnovoquestionario =" + idNovoQuestionario;
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
}
