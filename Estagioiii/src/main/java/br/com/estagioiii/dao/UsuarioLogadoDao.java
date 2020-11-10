/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.dao;

import br.com.estagioiii.conexao.Conexao;
import br.com.estagioiii.model.UsuarioLogadoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioLogadoDao extends Conexao {

    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String sql;

    public static boolean insereUsuarioLogado(UsuarioLogadoModel usuarioLodadoModel) {
        sql = "INSERT INTO usuariologado (nome,email,senha,usuario_id) VALUES (?,?,?,?)";
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                statement.setInt(1, usuarioLodadoModel.getNome());
                statement.setString(2, usuarioLodadoModel.getEmailLogar());
                statement.setString(3, usuarioLodadoModel.getSenha());
                statement.setInt(4, usuarioLodadoModel.getUsuarioMode().getId());
                statement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioLogadoDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                try {
                    statement.close();
                    desconecta();
                    getCon().close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioLogadoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public static UsuarioLogadoModel autenticacaoUsuario(String nome, String senha, Integer idUsuario) {
        sql = "SELECT * FROM usuariologado WHERE usuario_id =" + idUsuario;
        UsuarioLogadoModel usuarioLogadoModel = new UsuarioLogadoModel();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    if ((resultSet.getString(3).equalsIgnoreCase(nome)) && (resultSet.getString(4).equalsIgnoreCase(senha))) {
                        usuarioLogadoModel.setId(resultSet.getInt(1));
                        usuarioLogadoModel.setNome(resultSet.getInt(2));
                        usuarioLogadoModel.setEmailLogar(resultSet.getString(4));
//                        usuarioModel.setSenha(resultSet.getString(5));
                        usuarioLogadoModel.setUsuarioMode(UsuarioDao.buscaUsuario(resultSet.getInt(5)));
                        usuarioLogadoModel.setValidar(true);
                        return usuarioLogadoModel;
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioLogadoDao.class.getName()).log(Level.SEVERE, null, ex);
                usuarioLogadoModel.setValidar(false);
                return usuarioLogadoModel;
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioLogadoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        usuarioLogadoModel.setValidar(false);
        return usuarioLogadoModel;
    }

    public static UsuarioLogadoModel autenticacaoUsuarioALogar(String nome, String senha) {
        sql = "SELECT * FROM usuariologado";
        UsuarioLogadoModel usuarioLogadoModel = new UsuarioLogadoModel();
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    if ((resultSet.getString(3).equalsIgnoreCase(nome)) && (resultSet.getString(4).equalsIgnoreCase(senha))) {
                        usuarioLogadoModel.setId(resultSet.getInt(1));
                        usuarioLogadoModel.setNome(resultSet.getInt(2));
                        usuarioLogadoModel.setEmailLogar(resultSet.getString(4));
//                        usuarioModel.setSenha(resultSet.getString(5));
                        usuarioLogadoModel.setUsuarioMode(UsuarioDao.buscaUsuario(resultSet.getInt(5)));
                        usuarioLogadoModel.setValidar(true);
                        return usuarioLogadoModel;
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioLogadoDao.class.getName()).log(Level.SEVERE, null, ex);
                usuarioLogadoModel.setValidar(false);
                return usuarioLogadoModel;
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioLogadoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        usuarioLogadoModel.setValidar(false);
        return usuarioLogadoModel;
    }

    public static UsuarioLogadoModel buscaUsuario(Integer id) {
        sql = "SELECT * FROM usuariologado WHERE id=" + id;
        UsuarioLogadoModel usuarioModel = new UsuarioLogadoModel();
        getConexao();
        if (getCon() != null) {

            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    resultSet.first();
                    usuarioModel.setId(resultSet.getInt(1));
                    usuarioModel.setNome(resultSet.getInt(2));
                    usuarioModel.setEmailLogar(resultSet.getString(3));
//                usuarioModel.setSenha(resultSet.getString(4));
                    usuarioModel.setUsuarioMode(UsuarioDao.buscaUsuario(resultSet.getInt(5)));
                    usuarioModel.setValidar(true);
                    return usuarioModel;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioLogadoDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                    desconecta();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioLogadoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public static boolean autenticacaoNomeLogin(String nome) {
        sql = "SELECT * FROM usuariologado";
        getConexao();
        if (getCon() != null) {

            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    if ((resultSet.getString(3).equalsIgnoreCase(nome)) && (resultSet.getString(5).equalsIgnoreCase(nome))) {//Comparar Email também
                        return false;
                    }
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
        return true;
    }
}
