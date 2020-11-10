/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.dao;

import br.com.estagioiii.conexao.Conexao;
import br.com.estagioiii.model.TipoQuestionarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoQuestionarioDao extends Conexao {

    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String sql;

    public static TipoQuestionarioModel tipoQuestionario(Integer id) {
        sql = "SELECT * FROM tipoalternativa where id =" + id;
        TipoQuestionarioModel tipoQuestionarioModel = new TipoQuestionarioModel();
        getConexao();
        if (getCon() != null) {

            try {
                statement = getCon().prepareStatement(sql);
                resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    resultSet.first();
                    tipoQuestionarioModel.setId(resultSet.getInt(1));
                    tipoQuestionarioModel.setTipoQuestionario(resultSet.getString(2));
                    return tipoQuestionarioModel;
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
        return tipoQuestionarioModel;
    }

}
