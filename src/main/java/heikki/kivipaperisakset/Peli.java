/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heikki.kivipaperisakset;

/**
 *
 * @author heikki
 */
public class Peli {
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;

    private int kierrokset;
    private int tasapelit;

    private final int MAX_VOITOT = 3;

    public enum State {ALUSSA, KAYNNISSA, PAATTYNYT}
    private State state;

    public Peli() {
        pelaaja1 = new Pelaaja();
        // Annetaan pelaajille eri nimet
        do {
            pelaaja2 = new Pelaaja();
        } while(!pelaaja2.toString().equals(pelaaja2.toString()));

        kierrokset = 0;
        state = State.ALUSSA;
    }

    /**
     * Aloita uusi kierros pelissä.
     * Tämä metodi myös muuttaa pelin tilan "käynnissä" -tilaan, ellei jo ole
     * asetettu.
     */
    public void uusiKierros() {
        state = State.KAYNNISSA;
        kierrokset++;
        pelaaja1.teeValinta();
        pelaaja2.teeValinta();
    }

    /**
     * Tarkista kierroksen voittaja ja palauta tämä.
     * Kasvata samalla voittaneen pelaajan voittojen määrää.
     * @return Pelaaja voittaja
     */
    public Pelaaja kierroksenVoittaja() {
        int voittaja = pelaaja1.vertaa(pelaaja2);
            if(voittaja == 1) {
                pelaaja1.kasvataVoitot();
                return pelaaja1;
            } else if(voittaja == -1) {
                pelaaja2.kasvataVoitot();
                return pelaaja2;
            } else {
                tasapelit++;
                return null;
            }
    }

    /**
     * Mikäli peli on tilassa PÄÄTTYNYT, tarkista voittaja ja palauta tämä.
     * @return Pelaaja voittaja
     */
    public Pelaaja pelinVoittaja() {
        if(state == State.PAATTYNYT) {
            return (pelaaja1.getVoitot() > pelaaja2.getVoitot()) 
                    ? pelaaja1 : pelaaja2;
        }

        return null;
    }

    /**
     * Yksinkertainen funktio, joka kertoo, onko peli päättynyt.
     * @return boolean onko peli loppunut
     */
    public boolean peliLoppui() {
        if ((pelaaja1.getVoitot() >= MAX_VOITOT) || (pelaaja2.getVoitot() >= MAX_VOITOT)) {
            state = State.PAATTYNYT;
            return true;
        }
        return false;
    }

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    public int getKierrokset() {
        return kierrokset;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        state = state;
    }

    int getTasapelit() {
        return tasapelit;
    }

}
