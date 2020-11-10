/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.model;

public class RespostaTextoModel {
    private Integer id;
    private String resposta;
    private RespostaModel respostaModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public RespostaModel getRespostaModel() {
        return respostaModel;
    }

    public void setRespostaModel(RespostaModel respostaModel) {
        this.respostaModel = respostaModel;
    }
    
}
