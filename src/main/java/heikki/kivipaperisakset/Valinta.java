/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heikki.kivipaperisakset;

import java.util.Random;

/**
 * Tämä luokka edustaa pelaajan tekemää valintaa: kivi, paperi vai sakset?
 * Huolehtii valinnan luomisesta, säilyttämisestä ja vertaamisesta toiseen 
 * valintaan.
 * @author heikki
 */
public class Valinta implements Comparable<Valinta> {

    public enum Vaihtoehto { KIVI, PAPERI, SAKSET };
    private Vaihtoehto valinta;

    public Valinta() {
        arvoValinta();
    }
    
    /**
     * Valitse sattumanvaraisesti kivi, paperi tai sakset
     */
    private void arvoValinta() {
        Random r = new Random();
        int i = r.nextInt(2);
        valinta = Vaihtoehto.values()[i];
    }

    public void setValinta(Vaihtoehto valinta) {
        this.valinta = valinta;
    }
    
    /**
     * Vertaa toisiinsa kahta kivi-sakset-paperi -valintaa
     * @param v Verrattava valinta
     * @return int -1, 0, 1
     */
    @Override
    public int compareTo(Valinta v) {
        if(this.valinta == Vaihtoehto.KIVI && v.getValinta() == Vaihtoehto.SAKSET
                || this.valinta == Vaihtoehto.PAPERI && v.getValinta() == Vaihtoehto.KIVI
                || this.valinta == Vaihtoehto.SAKSET && v.getValinta() == Vaihtoehto.PAPERI) {
            return 1;
        } else if(this.valinta == v.getValinta()) {
            return 0;
        } else {
            return -1;
        }
    }

    public Vaihtoehto getValinta() {
        return valinta;
    }

    @Override
    public String toString() {
        switch (valinta) {
            case KIVI:
                return "kivi";
            case PAPERI:
                return "paperi";
            default:
                return "sakset";
        }
    }

    
}
