/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.model;


public class UsuarioModel {
    private Integer id;
    private String nome;
    private String loginName;
    private String email;
    private String senha;
    private boolean validacao;
    private UsuarioLogadoModel usuarioLogadoModel;
    private Integer idNovoQuestionario;

    public Integer getIdNovoQuestionario() {
        return idNovoQuestionario;
    }

    public void setIdNovoQuestionario(Integer idNovoQuestionario) {
        this.idNovoQuestionario = idNovoQuestionario;
    }
    
    
    public UsuarioLogadoModel getUsuarioLogadoModel() {
        return usuarioLogadoModel;
    }

    public void setUsuarioLogadoModel(UsuarioLogadoModel usuarioLogadoModel) {
        this.usuarioLogadoModel = usuarioLogadoModel;
    }
    
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
        
    public boolean isValidacao() {
        return validacao;
    }

    public void setValidacao(boolean validacao) {
        this.validacao = validacao;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
