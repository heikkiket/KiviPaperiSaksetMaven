
package heikki.kivipaperisakset;

import java.util.Random;

/**
 * Tämä luokka kuvastaa pelin pelaajaa
 * 
 * Luokan sisään tallennetaan pelaajan tekemä valinta sekä voittojen lukumäärä.
 * @author Ira Dook
 */
public class Pelaaja {

    int voitot;      // Voittojen lukumäärä
    private Valinta valinta;
    private String nimi;

    /**
     * Mikäli pelaajalle ei anneta nimeä, se arvotaan
     */
    public Pelaaja() {
        this(keksiNimi());
    }

    public Pelaaja(String nimi) {
        this.voitot = 0;
        this.valinta = null;
        this.nimi = nimi;
    }

    

    /**
     * Valitse randomilla kivi, paperi tai sakset
     * @return Valinta tehty valinta
     */
    public Valinta teeValinta() {
        this.valinta = new Valinta();
        return this.valinta;
    }


    /**
     * Vertaa pelaajia keskenään
     * @param pelaaja2
     * @return -1, 0 tai 1 riippuen kummalla pelaajista on voittava käsi
     */
    int vertaa(Pelaaja pelaaja2) {
        return this.valinta.compareTo(pelaaja2.getValinta());
    }

    /**
     * Kasvattaa pelaajan voittomäärää yhdellä.
     * @return int voittojen määrä
     */
    public int kasvataVoitot() {
        this.voitot++;
        return this.voitot;
    }

    public Valinta getValinta() {
        return valinta;
    }

    public void setValinta(Valinta valinta) {
        this.valinta = valinta;
    }

    
    public int getVoitot() {
        return voitot;
    }

    @Override
    public String toString() {
        return this.nimi;
    }

    /**
     * Yksinkertainen funktio pelaajan nimen arpomiseksi.
     * @return String nimi
     */
    public static String keksiNimi() {
        String[] nimet = {
            "Piippolan vaari", 
            "Vaappolan piiri",
            "Mättäjä",
            "KPS Mestari",
            "Yön kostaja",
            "Zorro",
            "Nykerö"
        };

        Random r = new Random();
        return nimet[r.nextInt(nimet.length)];
    }
    
}
