/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.model;

public class RespostaModel {
private Integer id;
private AlternativaModel atividadeModel;
private UsuarioLogadoModel usuarioLogado;
private boolean respondido;

    public boolean isRespondido() {
        return respondido;
    }

    public void setRespondido(boolean respondido) {
        this.respondido = respondido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlternativaModel getAtividadeModel() {
        return atividadeModel;
    }

    public void setAtividadeModel(AlternativaModel atividadeModel) {
        this.atividadeModel = atividadeModel;
    }

    public UsuarioLogadoModel getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(UsuarioLogadoModel usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }


}