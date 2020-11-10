/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.model;


public class QuestionarioModel {

    private Integer id;
    private String pergunta;
    private UsuarioModel usuarioModel;
    private TipoQuestionarioModel tipoQuestionarioModel;
    private CabecalhoModel cabecalhoModel;

    public CabecalhoModel getCabecalhoModel() {
        return cabecalhoModel;
    }

    public void setCabecalhoModel(CabecalhoModel cabecalhoModel) {
        this.cabecalhoModel = cabecalhoModel;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public TipoQuestionarioModel getTipoQuestionarioModel() {
        return tipoQuestionarioModel;
    }

    public void setTipoQuestionarioModel(TipoQuestionarioModel tipoQuestionarioModel) {
        this.tipoQuestionarioModel = tipoQuestionarioModel;
    }

}
