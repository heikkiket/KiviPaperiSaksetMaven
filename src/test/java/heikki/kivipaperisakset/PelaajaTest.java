/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heikki.kivipaperisakset;

import java.util.ArrayList;
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
public class PelaajaTest {
    
    public PelaajaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of pelaajanValinta method, of class Pelaaja.
     */
    @Test
    public void testTeeValinta() {
        System.out.println("pelaajanValinta");
        Pelaaja instance = new Pelaaja("Teppo Testaaja");
        Valinta expResult = null;
        Valinta result = instance.teeValinta();
        assertTrue(result != null);
    }

    /**
     * Test of kasvataVoitot method, of class Pelaaja.
     */
    @Test
    public void testKasvataVoitot() {
        System.out.println("kasvataVoitot");
        Pelaaja instance = new Pelaaja("Teppo Testaaja");
        int expResult = 2;
        instance.kasvataVoitot();
        int result = instance.kasvataVoitot();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValinta method, of class Pelaaja.
     */
    @Test
    public void testGetValinta() {
        System.out.println("getValinta");
        Pelaaja instance = new Pelaaja("Teppo Testaaja");
        Valinta result = instance.getValinta();
        assertTrue(result == null);

        // These two should give the same result
        Valinta expResult = instance.teeValinta();
        result = instance.getValinta();

        assertEquals(expResult, result);
    }

    /**
     * Test of getVoitot method, of class Pelaaja.
     */
    @Test
    public void testGetVoitot() {
        System.out.println("getVoitot");
        Pelaaja instance = new Pelaaja("Teppo Testaaja");
        int expResult = 1;
        int voitot = instance.kasvataVoitot();
        int result = instance.getVoitot();
        assertEquals(expResult, result);
        assertEquals(voitot, result);
    }

    
    @Test
    public void testKeksiNimi() {
        System.out.println("keksiNimi");
        String nimi = Pelaaja.keksiNimi();

        assertNotEquals("", nimi);
    }
}
