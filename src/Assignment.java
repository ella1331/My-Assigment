
import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);
      
        // Kysytään käyttäjältä etunimi, sukunimi ja yrityksen verkkotunnus
        System.out.print("Anna etunimi: ");
        String etunimi = scanner.nextLine();

        System.out.print("Anna sukunimi: ");
        String sukunimi = scanner.nextLine();

        System.out.print("Anna yrityksen verkkotunnus: ");
        String verkkotunnus = scanner.nextLine();

        // Tarkistetaan, että kaikki tiedot ovat annettu
        if (etunimi.isEmpty() || sukunimi.isEmpty() || verkkotunnus.isEmpty()) {
            System.out.println("Virhe! Jokin tiedoista puuttui.");
            scanner.close();
            return; 
            // Jos ei ole annettu kaikkia tietoja, ohjelma loppuu
        }

        // Kutsutaan GenerateEmail-metodia
        String sahkoposti = GenerateEmail(etunimi, sukunimi, verkkotunnus);
        System.out.println("Sähköpostiosoite: " + sahkoposti);

        // Kutsutaan GenerateUsername-metodia
        String kayttajatunnus = GenerateUsername(etunimi, sukunimi);
        System.out.println("Käyttäjätunnus: " + kayttajatunnus);

        scanner.close();
    }

     // Luodaan sähköpostiosoite etunimen, sukunimen ja verkkotunnuksen perusteella
    public static String GenerateEmail(String etunimi, String sukunimi, String verkkotunnus) {
        String sahkoposti = etunimi.toLowerCase() + "." + sukunimi.toLowerCase() + "@" + verkkotunnus;
        return sahkoposti;
    }

     // Luodaan käyttäjätunnus etunimen 4 ensimmäisestä merkistä ja sukunimen 4 viimeisestä merkistä
    public static String GenerateUsername(String etunimi, String sukunimi) {
        String kayttajatunnus = etunimi.substring(0, Math.min(etunimi.length(), 4)).toLowerCase() +
            sukunimi.substring(Math.max(0, sukunimi.length() - 4)).toLowerCase();
        return kayttajatunnus;
    }
}