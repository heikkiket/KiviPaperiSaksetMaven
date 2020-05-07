/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heikki.kivipaperisakset;

import heikki.kivipaperisakset.Valinta.Vaihtoehto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author heikki
 */
public class ValintaTest {
    
    public ValintaTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of compareTo method, of class Valinta.
     */
    @ParameterizedTest
    @CsvSource({"KIVI, 0", "PAPERI, 1", "SAKSET, -1"})
    public void testCompareTo(Vaihtoehto input, int expected) {
        System.out.println("compareTo");

        Valinta v = new Valinta();
        v.setValinta(Vaihtoehto.KIVI);

        Valinta instance = new Valinta();
        instance.setValinta(input);

        int result = instance.compareTo(v);
        assertEquals(expected, result);
    }

    /**
     * Test of toString method, of class Valinta.
     */
    @ParameterizedTest
    @CsvSource({"KIVI, 'kivi'", "PAPERI, 'paperi'", "SAKSET, 'sakset'"})
    public void testToString(Vaihtoehto input, String expected) {
        System.out.println("toString");

        Valinta instance = new Valinta();
        instance.setValinta(input);
        String result = instance.toString();
        assertEquals(expected, result);
    }
    
}
