/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.model;

import java.util.List;

public class UsuarioLogadoModel {
    private Integer id = -1;
    private Integer nome;
    private List email;
    private String emailLogar;
    private String senha;
    private UsuarioModel usuarioMode;
    private boolean validar;

    public boolean isValidar() {
        return validar;
    }

    public void setValidar(boolean validar) {
        this.validar = validar;
    }
        
    public String getEmailLogar() {
        return emailLogar;
    }

    public void setEmailLogar(String emailLogar) {
        this.emailLogar = emailLogar;
    }

    public Integer getNome() {
        return nome;
    }

    public void setNome(Integer nome) {
        this.nome = nome;
    }
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List getEmail() {
        return email;
    }

    public void setEmail(List email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioModel getUsuarioMode() {
        return usuarioMode;
    }

    public void setUsuarioMode(UsuarioModel usuarioMode) {
        this.usuarioMode = usuarioMode;
    }
    
}
