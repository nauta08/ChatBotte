package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question {

    private String question;
    private List<Reponse> reponses;

    public Question(String question) {
        this.question = question;
        this.reponses = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    @Override
    public String toString(){
        String result = question.substring(1);
        result += reponses.stream().map(r -> r.toString()).collect(Collectors.joining( "\n", "\n", "\n"));
        return  result;
    }
}
