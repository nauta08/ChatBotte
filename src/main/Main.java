// la première information écrite dans un fichier source est la définition du package
// Dans un premier temps on ne va pas s'en soucier.
// Disons que c'est un rappel de l'arborescence des dossiers
package main;

// Ensuite vient la liste des imports.
// Celà permet de rendre disponibles des bouts de programmes écrits dans d'autres fichiers
// Ou pour être plus précis dans des fichiers appartenants à d'autres packages.
// Dans certains cas nous avons écrit ces fichiers
import model.Question;
import util.Fichier;
// Dans d'autres cas ils sont fournis par le langage java (ou par d'autres éditeurs)
import java.util.List;

// Puis vient la définition de la classe.
// En java elle est obligatoire. Un fichier sans classe déclarée n'existe pas.
// On verra qu'il existe cependant plusieurs 'sortes' de classes.

// 'public' ici est obligatoire.
// 'class' scpécifie que notre fichier contiendra des fonctions et des propriétés
// La classe doit avoir le même nom que le fichier qui la contient (ici Main.java donne la classe Main)
// Traditionnellement, une classe commence par une majuscule.
// Le caractère '{' indique que l'on rentre dans la définition proprement dite de la classe.
public class Main {

    // Une classe peut contenir des fonctions. En voici une.
    // Celle ci est spéciale ; c'est le point d'entrée dans le programme.
    // Sa forme est très codifiée :
    // - 'public' est obligatoire
    // - 'static' est obligatoire
    // - 'void' est obligatoire
    // - 'main' est "obligatoire". T
    // - '(String[] args)' est "obligatoire". Traditionnellement, une fonction commence par une minuscule.
    // Le caractère '{' indique que l'on rentre dans la définition proprement de la fonction
    public static void main(String[] args) {

        // Une classe peut contenir des propriétés. En voici une.
        // Boolean est le type.
        // On aurait aussi pu l'écrire 'boolean' sans majuscule. La différence est importante. On y reviendra.
        // Boolean signifie bouléen, selon l'algèbre de Boole (comment on combine des vrai et des faux)
        // https://fr.wikipedia.org/wiki/Alg%C3%A8bre_de_Boole_(logique)
        // un bouléen n'a que deux valeurs (true et false en java)
        // 'encore' est le nom donné à notre variable. Ce nom est libre à quelques règles près
        // - doit commencer par une lettre
        // - ne doit pas être un mot réservé (class, public, static, Boolean ... sont exclus)
        // le signe '=' n'exprime pas une égalité mais une affectation : encore vaut true
        // le signe ';' point-virgule termine une ligne d'instruction. Il est obligatoire en java.
        Boolean encore = true;

        // Une nouvelle propriété : elle porte le nom 'questions'
        // On peut noter le pluriel. Des questions.
        // Le type permet de stocker une liste d'objets Question (model.Question présent dans les imports, ligne 10)
        // C'est exactement ce qu'exprime 'List<Question>' (java.util.List présent dans les imports, ligne 13)
        // On n'affecte pas immédiatement une valeur connue à cette propriété.
        // On ne connait pas à l'avance la liste des questions.
        // On va la lire dans un fichier (util.Fichier présent dans les imports, ligne 11)
        // Ou plutôt, on va appeler la fonction lireLesQuestions() de la classe Fichier pour le faire.
        // Cette fonction retournera une liste de questions qui sera affectée à la variable 'questions'
        // Contrôle+Click sur lireLesQuestions est un racoourci pour y aller.
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
