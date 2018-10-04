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

import java.util.List;

// Dans d'autres cas ils sont fournis par le langage java (ou par d'autres éditeurs)

// Puis vient la définition de la classe.
// En java elle est obligatoire. Un fichier sans classe déclarée n'existe pas.
// On verra qu'il existe cependant plusieurs 'sortes' de classes.

// 'public' ici est obligatoire.
// 'class' scpécifie que notre fichier contiendra des fonctions et des propriétés
// La classe doit avoir le même nom que le fichier qui la contient (ici Main_doc.java donne la classe Main_doc)
// Traditionnellement, une classe commence par une majuscule.
// Le caractère '{' indique que l'on rentre dans la définition proprement dite de la classe.
public class Main_doc {

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

        // 'if' permet d'introduire une condition.
        // ce qui est présent après l'accolade ne sera exécuter que si ce qui est écrit entre les parenthèses est vrai.
        // questions.isEmpty() va tester si la liste des questions est vide.
        // isEmpty() est une fonction, comme l'indique la présence des deux parenthèses
        // Cette fonction est présente dans la classe List (pour faire simple). On peut l'utiliser sans travail supplémentaire.
        if (questions.isEmpty()){
            // Donc si la liste est vide, on entre dans cette partie du code.
            // Sinon on va directement après l'accolade fermante (ligne 85).

            // 'System.out.println' est un appel à une autre fonction.
            // On ne l'a ni écrit ni importé. Sa présence est garantie 'de base'
            // Mais il faut préciser où le trouver : dans le package System.out
            // Entre les parenthèses, on passe un argument.
            // A chaque appel on peut imprimer quelque chose de différent : la chaîne de caractères passée à la fonction
            // Ici : "Saisir une première question : "
            // Les doubles quotes définissent une chaîne de caractères.
            System.out.println("Saisir une première question : ");

            // Après cet affichage, on délèque la suite du traitement à une autre fonction de Fichier
            // cette fonction attends 2 arguments :
            // - isQuestion, on lui passe true
            // - question, on lui passe null (je reparlerai de null)
            Fichier.ecrire(true, null);
        }

        // 'while' permet de répéter un comporement (le bloc d'instructions après l'accolade)
        // la répétition se fera tant que l'élémént entre parenthèse sera vrai
        // si 'encore' vaut false, on saute à l'accolade fermante de la ligne 129
        while (encore) {

            // On déclare une nouvelle propriété
            // - son type est Integer, c'est un nombre entier (on peut aussi écrire 'int' à quelques restrictions près
            // - son nom est 'index'. On val'utiliser pour récupérer un certain élémentdans une liste
            // La suite est un appel et une manipulation mathématique :
            // - 'Math' est un package qui donne des outils mathématiques prêts à être utilisés
            // - toIntExact() va changer le type de notre résultat en valeur entière de type Integer
            // - De la même façon, Math.round() va changer le type du résultat de Double à Long.
            // (pour résumer on peut parfois passer d'un type à l'autre sans risquer de perdre de l'information,
            // c'est le cas de Integer vers Long ou Long vers double. Dans l'autre sens java seul ne peut accepter ce choix.
            // On lui demande donc explicitement de le faire, et comment. D'où ces méthodes)
            // - Math.random() permet d'obtenir une valeur aléatoire (comprise entre 0 et 1 : 0.3876908 par exemple)
            // - on va multiplier cette valeur par le nombre de questions présentes dans la liste 'questions'
            // - questions.size() nous permet d'obtenir ce nombre de questions présentes dans la liste.
            // - Attention, le premier index dans une liste vaut 0
            //   - 1er élément = index 0
            //   - 2ème élément = index 1
            //   - 3ème élément = index 2
            // - Ca veut dire que si on a trois éléments dans la liste, les index vont de 0 à 2
            // et que si on multiplie 3 (la taille par une valeur aléatoire entre 0.000 et 1.000,
            // on peut obtenir un index entre 0 (fois 3) et 3 (fois 1). Or l'index 3 n'existe pas.
            // - On l'index peut être entre 0 (fois 2) et 2 (fois 1), soit les 3 valeurs qui nous intéressent ( 0, 1 et 2)
            Integer index = Math.toIntExact(Math.round(Math.random() * (questions.size() -1)));
            // Immédiatement, on utilise cet index pour obtenir une des questions de la liste avec questions.get()
            // index, on l'a vu a une valeur aléatoire parmis tous les indes valides
            // Le résultat est du type Question :  CF List<Question>
            // qui permet de définir ce que l'on doit mettre dans la liste
            // mais aussi ce qu'on va récupérer quand on récupère un élement (et ça c'est cool, tu verras)
            // Pour rappel, un objet de type Question sait s'afficher tout seul : il va appeler sa fonction toString()
            // Le résultat est le même que si on avait écrit : System.out.println(questions.get(index.toString()));
            System.out.println(questions.get(index));
            // Si une saisie est faite, on la traite avec une autre fonction de la classe Fichier : ecrire()
            // - on appelait djà cette fonction plus haut, ligne 87
            // - le deuxième argument est différent cette fois, il s'agit de la question en cours de traitement
            encore = Fichier.ecrire(true, questions.get(index));
        }
    }
}
