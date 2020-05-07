package heikki.kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Main {

    public static void main(String args[]) {

        // Tämä komento alustaa pelin, pelaajat jne.
        Peli peli = new Peli();
        boolean peliKaynnissa = true;
       
        // Alkuhöpinät
        System.out.println("On alkamassa tiukka kivi-paperi-sakset -matsi.");
        System.out.println("Vastakkain ovat tällä kertaa " + peli.getPelaaja1() 
                + " ja " + peli.getPelaaja2() +"!\n\n");
        
        // Pelin päälooppi
        // Tämä sisällä tulostetaan käyttäjälle näytettävät asiat ja arvotaan peli
        // Ajetaan, kunnes peliKaynnissa == false;
        do {

            // Tämä alustaa uuden kierroksen, tekee pelaajien valinnat jne.
            peli.uusiKierros();


            System.out.println("Erä: " + peli.getKierrokset() + 
                    " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + peli.getTasapelit());

            System.out.println("Pelaajalla " + peli.getPelaaja1() + " koossa "
                    + peli.getPelaaja1().getVoitot() + " voittoa.");
            System.out.println("Pelaajalla " + peli.getPelaaja2() + " koossa "
                    + peli.getPelaaja2().getVoitot() + " voittoa.\n");
            
            System.out.println(peli.getPelaaja1() + ": " + peli.getPelaaja1().getValinta());
            System.out.println(peli.getPelaaja2() + ": " + peli.getPelaaja2().getValinta());



            // Selvitä kierroksen voittaja
            Pelaaja voittaja = peli.kierroksenVoittaja();

            if(voittaja == null) {
                System.out.println("\n\t\t\t Tasapeli \n");
            } else {
                System.out.println(voittaja + " voittaa");
            }

            // Kasvatetaan pelattujen pelien määrää, katsotaan joko peli pitää
            // lopettaa
            if (peli.peliLoppui()) {
                peliKaynnissa = false;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
                // HUOM: oheinen metodi voisi palauttaa myös null.
                System.out.println("Voittaja on " + peli.pelinVoittaja() + "!");
            }
            System.out.println();
        } while (peliKaynnissa);


        System.out.println("Kiitos ajastanne ja nähdään taas ensi kerralla.");
    }
}
