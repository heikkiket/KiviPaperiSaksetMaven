/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heikki.kivipaperisakset;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author heikki
 */
public class PeliTest {

    Peli instance;
    
    public PeliTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new Peli();
        Valinta v1 = new Valinta();
        v1.setValinta(Valinta.Vaihtoehto.SAKSET);
        Valinta v2 = new Valinta();
        v2.setValinta(Valinta.Vaihtoehto.PAPERI);
        instance.getPelaaja1().setValinta(v1);
        instance.getPelaaja2().setValinta(v2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of uusiKierros method, of class Peli.
     */
    @Test
    public void testUusiKierros() {
        System.out.println("uusiKierros");
        Peli instance = new Peli();
        instance.uusiKierros();
        assertFalse(instance.getPelaaja1() == null);
        assertFalse(instance.getPelaaja2() == null);
        assertEquals(1, instance.getKierrokset());
    }

    /**
     * Test of kierroksenVoittaja method, of class Peli.
     */
    @Test
    public void testKierroksenVoittaja() {
        System.out.println("kierroksenVoittaja");
        Pelaaja result = instance.kierroksenVoittaja();
        assertEquals(instance.getPelaaja1(), result);
    }

    /**
     * Test of pelinVoittaja method, of class Peli.
     */
    @Test
    public void testPelinVoittaja() {
        System.out.println("pelinVoittaja");
        Pelaaja result = instance.kierroksenVoittaja();
        instance.setState(Peli.State.PAATTYNYT);
        assertEquals(instance.getPelaaja1(), result);
    }

    /**
     * Test of peliLoppui method, of class Peli.
     */
    @Test
    public void testPeliLoppui() {
        System.out.println("peliLoppui");
        Pelaaja voittaja = instance.kierroksenVoittaja();
        voittaja = instance.kierroksenVoittaja();
        voittaja = instance.kierroksenVoittaja();
        boolean expResult = true;
        boolean result = instance.peliLoppui();
        assertEquals(expResult, result);
    }
    
}
