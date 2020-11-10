/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.model;

import java.util.List;


public class RelatorioEspecificoModel {
    private String nomeAdministrador;
    private String cabecalho;
    private String subCabecalho;
    private String nomePergunta;
    private String tipoPergunta;
    private Integer quantidadeAvaliador;
    private List<RelatorioEspecificoInternoModel> alternativa;

    public String getNomeAdministrador() {
        return nomeAdministrador;
    }

    public void setNomeAdministrador(String nomeAdministrador) {
        this.nomeAdministrador = nomeAdministrador;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getSubCabecalho() {
        return subCabecalho;
    }

    public void setSubCabecalho(String subCabecalho) {
        this.subCabecalho = subCabecalho;
    }

    public String getNomePergunta() {
        return nomePergunta;
    }

    public void setNomePergunta(String nomePergunta) {
        this.nomePergunta = nomePergunta;
    }

    public String getTipoPergunta() {
        return tipoPergunta;
    }

    public void setTipoPergunta(String tipoPergunta) {
        this.tipoPergunta = tipoPergunta;
    }

    public Integer getQuantidadeAvaliador() {
        return quantidadeAvaliador;
    }

    public void setQuantidadeAvaliador(Integer quantidadeAvaliador) {
        this.quantidadeAvaliador = quantidadeAvaliador;
    }

    public List<RelatorioEspecificoInternoModel> getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(List<RelatorioEspecificoInternoModel> alternativa) {
        this.alternativa = alternativa;
    }
        
}
