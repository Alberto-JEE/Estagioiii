/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexao {

    private static final String dns = "localhost";
    private static final String bd = "josuequestionario";
    private static final String usuario = "root";
    private static final String senha = "terraonline";
    private static final int porta = 3309;
    private static Connection con;

    public static void getConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + dns + ":" + porta + "/" + bd, usuario, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar: " + e);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar: " + ex);
        }
    }
    
    public static void desconecta(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getDns() {
        return dns;
    }

    public static String getBd() {
        return bd;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getSenha() {
        return senha;
    }

    public static int getPorta() {
        return porta;
    }

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        Conexao.con = con;
    }        
//    public static void main(String[] args) {
//        Conexao.getConexao();
//    }
}
