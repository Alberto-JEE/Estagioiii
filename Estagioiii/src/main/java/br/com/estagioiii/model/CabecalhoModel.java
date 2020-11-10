/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.model;


public class CabecalhoModel {
    private Integer id;
    private String tituloQuestionario;
    private String assuntoQuestionario;
    private UsuarioModel usuarioModel;
    private Integer idNovoQuestionario;
    private boolean auxiliar;

    public Integer getIdNovoQuestionario() {
        return idNovoQuestionario;
    }

    public void setIdNovoQuestionario(Integer idNovoQuestionario) {
        this.idNovoQuestionario = idNovoQuestionario;
    }

    
    public boolean isAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(boolean auxiliar) {
        this.auxiliar = auxiliar;
    }
    
    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTituloQuestionario() {
        return tituloQuestionario;
    }

    public void setTituloQuestionario(String tituloQuestionario) {
        this.tituloQuestionario = tituloQuestionario;
    }

    public String getAssuntoQuestionario() {
        return assuntoQuestionario;
    }

    public void setAssuntoQuestionario(String assuntoQuestionario) {
        this.assuntoQuestionario = assuntoQuestionario;
    }  
    
}
