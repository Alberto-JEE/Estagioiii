/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagioiii.model;

public class AlternativaModel {
    private Integer id;
    private String alternativa;
    private QuestionarioModel questionarioModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public QuestionarioModel getQuestionarioModel() {
        return questionarioModel;
    }

    public void setQuestionarioModel(QuestionarioModel questionarioModel) {
        this.questionarioModel = questionarioModel;
    }
    
      
}
