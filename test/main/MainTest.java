package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

// En lançant ici on exécute tous les tests de la classe
public class MainTest{

    // en lançant ici on exécute uniquementce test
    @Test
    public void mainTest (){

        List<String> liste = new ArrayList<>();
        // ici la liste est vide
        assertTrue("Normalement la liste est vide", liste.isEmpty());
        liste.add("un"); // index = 0
        liste.add("deux"); // index = 1
        liste.add("trois"); // index = 2
        liste.add("quatre"); // index = 3
        liste.add("cinq"); // index = 4
        // ici la taille de la liste est de 5 éléments
        assertEquals("la taille de la liste devrait être de 5", 5, liste.size());

        // je fais tourner mille fois la génération de nombre aléatoire
        for (int i = 0; i < 1000; i++) {
            Double aleatoire = Math.random();
            // chaque fois je vérifie que sa valeur est bien entre 0 et 1
            // si ce n'est pas le cas, le test s'arrête et affiche le message
            assertTrue("La valeur aléatoire doit être comprise entre 0.00 et 1.00, or aleatoire vaut : " + aleatoire, aleatoire >= 0 && aleatoire <= 1);
        }

        // puis je fais tourner mille fois la transformation de ce nombre aléatoire en index valide pour un de nos 5 éléments
        for (int i = 0; i < 1000; i++){
            // Je le génère (indication : à comparer avec le code de Main.java)
            Integer index = Math.toIntExact(Math.round(Math.random() * (liste.size())));
            // Je l'affiche'
            System.out.println(index);
            // je le teste ...
            assertTrue("La valeur aléatoire doit valoir entre 0 et 4 or l'index ici vaut : " + index, index >= 0 && index <= 4);
        }


    }
}