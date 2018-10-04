package main;

import model.Question;
import util.Fichier;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Boolean encore = true;

        List<Question> questions = Fichier.lireLesQuestions();

        if (questions.isEmpty()){

            System.out.println("Saisir une première question : ");

            Fichier.ecrire(true, null);
        }

        while (encore) {
            Integer index = Math.toIntExact(Math.round(Math.random() * (questions.size() -1)));
            System.out.println(questions.get(index));
            encore = Fichier.ecrire(true, questions.get(index));
        }
    }
}
