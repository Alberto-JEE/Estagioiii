/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.dao;

import static br.com.estagioiii.conexao.Conexao.desconecta;
import static br.com.estagioiii.conexao.Conexao.getCon;
import static br.com.estagioiii.conexao.Conexao.getConexao;
import br.com.estagioiii.model.CabecalhoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CabecalhoDao {
    
    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String sql;

    public static boolean insereUsuario(CabecalhoModel cabecalhoModel) {
        sql = "INSERT INTO cabecalho (tituloquestionario,assuntoquestionario,usuario_id,idnovoquestionario) VALUES (?,?,?,?)";
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                statement.setString(1, cabecalhoModel.getTituloQuestionario());
                statement.setString(2, cabecalhoModel.getAssuntoQuestionario());
                statement.setInt(3, cabecalhoModel.getUsuarioModel().getId());
                statement.setInt(4, cabecalhoModel.getIdNovoQuestionario());
                statement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                try {
                    statement.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(CabecalhoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static CabecalhoModel cabecalhoConfere(Integer idUsuario, Integer idCabecalho, Integer idNovoQuestionario) {
        if (idCabecalho != null) {
            sql = "SELECT * FROM cabecalho WHERE id =" + idCabecalho + " and idnovoquestionario =" + idNovoQuestionario;
        }
        if (idUsuario != null) {
            sql = "SELECT * FROM cabecalho WHERE usuario_id =" + idUsuario + " and idnovoquestionario =" + idNovoQuestionario;
        }
        CabecalhoModel cabecalhoModel = new CabecalhoModel();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    resultSet.first();
                    cabecalhoModel.setId(resultSet.getInt(1));
                    cabecalhoModel.setTituloQuestionario(resultSet.getString(2));
                    cabecalhoModel.setAssuntoQuestionario(resultSet.getString(3));
                    cabecalhoModel.setUsuarioModel(UsuarioDao.buscaUsuario(resultSet.getInt(4)));
                    cabecalhoModel.setIdNovoQuestionario(resultSet.getInt(5));
                    return cabecalhoModel;
                }

            } catch (SQLException ex) {
                Logger.getLogger(CabecalhoDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(CabecalhoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public static int maiorId(Integer idUsuario) {
        int maiorid = 0;
        getConexao();
        if (getCon() != null) {
            try {
                sql = "Select max(idnovoquestionario) FROM cabecalho";
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    resultSet.first();
                    maiorid = resultSet.getInt(1);
                }
                return maiorid;
            } catch (Exception e) {
                return maiorid;
            } finally {
                try {
                    statement.close();
                    desconecta();
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CabecalhoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return maiorid;
    }

    public static List<CabecalhoModel> buscaTodoCabecalho(Integer codigoUsuario) {
        List<CabecalhoModel> cabecalhoModel = new ArrayList<>();
        getConexao();
        if (getCon() != null) {
            sql = "SELECT * FROM cabecalho WHERE usuario_id = " + codigoUsuario + " ORDER BY id ASC";
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CabecalhoModel model = new CabecalhoModel();
                    model.setId(resultSet.getInt(1));
                    model.setTituloQuestionario(resultSet.getString(2));
                    model.setAssuntoQuestionario(resultSet.getString(3));
                    model.setUsuarioModel(UsuarioDao.buscaUsuario(resultSet.getInt(4)));
                    model.setIdNovoQuestionario(resultSet.getInt(5));
                    cabecalhoModel.add(model);
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(CabecalhoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cabecalhoModel;
    }

    public static void deletaCabecalho(Integer id, Integer idNovoQuestionario) {
        getConexao();
        if (getCon() != null) {
            sql = "DELETE FROM cabecalho WHERE id > 0 and  usuario_id =" + id + " and idnovoquestionario =" + idNovoQuestionario;
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
