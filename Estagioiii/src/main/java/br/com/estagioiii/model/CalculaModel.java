/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.model;

public class CalculaModel {
    private Integer questionarioId;
    private Integer quantidadeRespostaAlternativa;
    private Integer alternativaId;
    private Double  porcentagemResposta;
    private Integer numeroDaPergunta;

    public Integer getNumeroDaPergunta() {
        return numeroDaPergunta;
    }

    public void setNumeroDaPergunta(Integer numeroDaPergunta) {
        this.numeroDaPergunta = numeroDaPergunta;
    }
        
    public Integer getQuestionarioId() {
        return questionarioId;
    }

    public void setQuestionarioId(Integer questionarioId) {
        this.questionarioId = questionarioId;
    }

    public Integer getQuantidadeRespostaAlternativa() {
        return quantidadeRespostaAlternativa;
    }

    public void setQuantidadeRespostaAlternativa(Integer quantidadeRespostaAlternativa) {
        this.quantidadeRespostaAlternativa = quantidadeRespostaAlternativa;
    }

    public Integer getAlternativaId() {
        return alternativaId;
    }

    public void setAlternativaId(Integer alternativaId) {
        this.alternativaId = alternativaId;
    }

    public Double getPorcentagemResposta() {
        return porcentagemResposta;
    }

    public void setPorcentagemResposta(Double porcentagemResposta) {
        this.porcentagemResposta = porcentagemResposta;
    }
        
}
