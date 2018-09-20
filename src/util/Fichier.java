package util;

import model.Question;
import model.Reponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Fichier {


    public static List<Question> lireLesQuestions(){
        List<Question> results = new ArrayList<>();
        FileReader fr;
        String readLine;
        Integer index = 0;

        try {
            fr = new FileReader("bla.txt");
            BufferedReader b = new BufferedReader(fr);

            Question q = null;

            while ((readLine = b.readLine()) != null) {

                if (readLine.startsWith("?")){
                    if (q != null){
                        results.add(q);
                    }
                    q = new Question(readLine);
                    index = 1;

                }
                else if (!readLine.trim().isEmpty()){
                    q.getReponses().add(new Reponse(readLine, index++));
                }
            }
            if (q != null){
                results.add(q);
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static Boolean ecrire(Boolean isQuestion, Question question){
        Scanner in = new Scanner(System.in);
        FileWriter fw;
        try {
            fw = new FileWriter("bla.txt", true);

            String s = "_";

            while (s.length() > 0) {
                s = in.nextLine();

                if (s.matches(("\\d"))){
                    System.out.println("-> " + Traitement.traiter(question, Integer.valueOf(s)));
                }
                else if (s.equals("Quitter")){
                    fw.write("\n");
                    fw.flush();
                    fw.close();
                    return false;
                }
                else {
                    fw.write((isQuestion ? "?" : "") + s + "\n");
                    isQuestion = false;
                }

            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;

    }
}
