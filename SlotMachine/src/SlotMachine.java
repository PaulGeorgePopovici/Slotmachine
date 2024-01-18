import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

    public static void main(String[] args) {

        Scanner cititor = new Scanner(System.in);
        System.out.println("Doriti sa incepem jocul? ( introduceti 'da' sau 'nu')");
        String raspuns = cititor.nextLine();

        if (raspuns.equalsIgnoreCase("da")) {
            startGame();
        } else if (raspuns.equalsIgnoreCase("nu")) {
            System.out.println("Va mai asteptam pe la noi!");
        } else {
            System.out.println("Nu ai introdus un raspuns valabil!");
        }
    }

    public static void startGame() {
        Scanner cittior = new Scanner(System.in);
        double buget = 100;
//        ArrayList<String> posibilitati = new ArrayList<>(Arrays.asList("DIAMANT", "CIREASA", "BAR"));
        ArrayList<String> posibilitati = new ArrayList<>(Arrays.asList("DIAMANT" , "FARAON" , "SABIE" , "X" , "PANA", "CIREASA", "BAR"));

        Random generator = new Random();

        while (true) {
            System.out.println("Introduceti miza: Bugetul vostru este de " + buget);
            double miza = cittior.nextDouble();
            if (miza > buget) {
                System.out.println("Nu ai atatia bani!");
            } else {
                System.out.println("Am tras de maneta!");
                String rezultat1 = posibilitati.get(generator.nextInt(posibilitati.size()));
                String rezultat2 = posibilitati.get(generator.nextInt(posibilitati.size()));
                String rezultat3 = posibilitati.get(generator.nextInt(posibilitati.size()));

                printeazaRezulatele(rezultat1, rezultat2, rezultat3);

                if (rezultat1.equals(rezultat2) && rezultat2.equals(rezultat3)){
                    System.out.println("JACKPOT!");
                    double deAdaugat = (30.0/100.0) * miza;
                    buget += miza + deAdaugat;
                }else if (rezultat1.equals(rezultat2) || rezultat2.equals(rezultat3) || rezultat1.equals(rezultat3)){
                    System.out.println("SEMI-JACKPOT!");
                    double deAdaugat = 90.0/100.0 * miza;
                    buget += deAdaugat;
                }else {
                    System.out.println("AI PIERDUT!");
                    buget -= miza;
                }

                if (buget <= 1){
                    System.out.println("NU MAI AI BANI! DU TE ACASA!");
                    break;
                }else if (buget >= 10000){
                    System.out.println("AI CASTIGAT JOCUL!");
                    break;
                }
            }
        }
    }

    private static void printeazaRezulatele(String rezultat1, String rezultat2, String rezultat3) {
        System.out.println("[ " + rezultat1 + "] [ " + rezultat2 + " ] [ " + rezultat3 + " ]");
    }
}