package com.java.quiz.quizservice.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class QuizDto {
    private String categoryName;
    private Integer numQuestions;
    private String quizTitle;

    public QuizDto(String categoryName, Integer numQuestions, String quizTitle) {
        this.categoryName = categoryName;
        this.numQuestions = numQuestions;
        this.quizTitle = quizTitle;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(Integer numQuestions) {
        this.numQuestions = numQuestions;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }
}
