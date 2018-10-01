package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest{

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

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

        for (int i = 0; i < 1000; i++) {
            assertTrue("La valeur aléatoire est entre 0.00 et 1.00", Math.random() >= 0 && Math.random() <= 1);
        }

        for (int i = 0; i < 1000; i++){
            Integer index = Math.toIntExact(Math.round(Math.random() * (liste.size())));
            System.out.println(index);
            assertTrue("La valeur aléatoire doit valoir entre 0 et 4 or l'index ici vaut : " + index, index >= 0 && index <= 4);
        }


    }
}