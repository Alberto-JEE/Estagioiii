/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.dao;

import br.com.estagioiii.conexao.Conexao;
import br.com.estagioiii.model.UsuarioLogadoModel;
import br.com.estagioiii.model.UsuarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao extends Conexao {

    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String sql;

    public static boolean insereUsuario(UsuarioModel usuarioModel) {
        sql = "INSERT INTO usuario (nomeUsuario,nomeLogin,email,senha) VALUES (?,?,?,?)";
        getConexao();
        if (getCon() != null) {
            try {
                statement = getCon().prepareStatement(sql);
                statement.setString(1, usuarioModel.getNome());
                statement.setString(2, usuarioModel.getLoginName());
                statement.setString(3, usuarioModel.getEmail());
                statement.setString(4, usuarioModel.getSenha());
                statement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
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

    public static UsuarioModel autenticacaoUsuario(String nome, String senha) {
        sql = "SELECT * FROM usuario";
        UsuarioModel usuarioModel = new UsuarioModel();
        UsuarioLogadoModel usuarioLogadoModel = new UsuarioLogadoModel();
        getConexao();
        if (getCon() != null) {

            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    if (((resultSet.getString(3).equalsIgnoreCase(nome)) && (resultSet.getString(5).equalsIgnoreCase(senha))) || ((resultSet.getString(4).equalsIgnoreCase(nome)) && (resultSet.getString(5).equalsIgnoreCase(senha)))) {
                        usuarioModel.setId(resultSet.getInt(1));
                        usuarioModel.setNome(resultSet.getString(2));
                        usuarioModel.setLoginName(resultSet.getString(3));
                        usuarioModel.setEmail(resultSet.getString(4));
//                        usuarioModel.setSenha(resultSet.getString(5));
                        usuarioLogadoModel.setValidar(false);
                        usuarioModel.setUsuarioLogadoModel(usuarioLogadoModel);
                        usuarioModel.setValidacao(true);
                        return usuarioModel;
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                usuarioModel.setValidacao(false);
                return usuarioModel;
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
        usuarioModel.setValidacao(false);
        return usuarioModel;
    }

    public static UsuarioModel buscaUsuario(Integer id) {
        sql = "SELECT * FROM usuario WHERE id=" + id;
        UsuarioModel usuarioModel = new UsuarioModel();
        getConexao();
        if (getCon() != null) {

            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    resultSet.first();
                    usuarioModel.setId(resultSet.getInt(1));
                    usuarioModel.setNome(resultSet.getString(2));
                    usuarioModel.setLoginName(resultSet.getString(3));
                    usuarioModel.setEmail(resultSet.getString(4));
                    usuarioModel.setSenha(resultSet.getString(5));
                    usuarioModel.setValidacao(true);
                }
                return usuarioModel;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
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
        return null;
    }

    public static boolean autenticacaoNomeLogin(String nome) {
        sql = "SELECT * FROM usuario";
        getConexao();
        if (getCon() != null) {

            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    if (resultSet.getString(3).equalsIgnoreCase(nome)) {//Comparar Email também
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
//    public static void main(String[] args) throws SQLException {
//        UsuarioDao usuarioDao = new UsuarioDao(); ;
//        System.out.println("Email "+usuarioDao.buscaUsuario("Alberto","12345"));
//    }

}
