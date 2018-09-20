package util;

import model.Choix;
import model.Question;

public class Traitement {

    static String traiter(Question q, Integer index){

        String choix = q.getReponses().get(index -1).getReponse();
        switch (choix){
            case "Oui" : return Choix.OUI.toString();
            case "Non" : return Choix.NON.toString();
            case "La première" : return Choix.LA_PREMIERE.toString();
        }

        return choix;
    }
}
