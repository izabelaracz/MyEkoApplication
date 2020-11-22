package com.example.myekoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Question extends android.app.Activity{
    private String question;
    private String option1;
    private String option2;
    private String text;
    private int answerNr;

    public Question() {
    }

    public Question(String question, String option1, String option2, String text, int answerNr) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.text = text;
        this.answerNr = answerNr;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}
