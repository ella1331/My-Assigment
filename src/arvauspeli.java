//Tässä on yksinkertainen Java-arvauspeli, jossa käyttäjän on arvattava sana. 
//Jos vastaus on väärin, peli antaa vihjeen paljastamalla oikean vastauksen kirjaimia yksi 
//kerrallaan. Peli päättyy, kun käyttäjä arvaa oikein tai antaa komennon "loppu".
//sana ei vaihdu itsestään, vaan se on määritetty valmiiksi "java"
import java.util.Scanner;

public class arvauspeli {

    public static void main(String[] args) {
        String oikeaSana = "java"; // Tässä tehdään määritys sanasta,vaihda arvattava sana tarvittaessa
        int arvaustenMaara = 0;
        boolean arvattuOikein = false;

        Scanner lukija = new Scanner(System.in);

        System.out.println("Tervetuloa arvauspeliin! Voit lopettaa pelin sanalla: lopeta");
        System.out.println("Yritä arvata sana. Saat vihjeitä väärien vastausten jälkeen.");

        while (!arvattuOikein) {
            String arvaus = lukija.nextLine().toLowerCase();

            if (arvaus.equals("loppu")) {
                break; // Peli päättyy, jos käyttäjä syöttää "loppu"
            }

            //lasketaan arvausten määrä, ja tulostetaan se konsoliin
            arvaustenMaara++;

            if (arvaus.equals(oikeaSana)) {
                arvattuOikein = true;
                System.out.println("Onneksi olkoon, arvasit oikein!");
                System.out.println("Arvasit sanan " + arvaustenMaara + " yrityksellä.");
            } else {
                int pituus = Math.min(arvaus.length(), oikeaSana.length());
                StringBuilder vihje = new StringBuilder();

                for (int i = 0; i < pituus; i++) {
                    char arvausKirjain = arvaus.charAt(i);
                    char oikeaKirjain = oikeaSana.charAt(i);

                    if (arvausKirjain == oikeaKirjain) {
                        vihje.append(arvausKirjain);
                    } else {
                        vihje.append("_"); //vihje annetaan montako kirjainta sanassa on.
                    }
                }

                System.out.println("Väärin! Vihje: " + vihje.toString());
            }
        }

        if (!arvattuOikein) {
            System.out.println("Oikea sana oli: " + oikeaSana);
        }

        lukija.close();
    }
}
