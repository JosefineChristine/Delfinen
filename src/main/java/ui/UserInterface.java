package ui;

import domain_model.Controller;

import java.util.Scanner;

public class UserInterface {

    Scanner input = new Scanner(System.in);
    Controller controller = new Controller();

    int userChoice;

    public void startProgram() {

        while (userChoice != 7) {
            startMenu();
            userChoice = Integer.parseInt(input.next());

            switch (userChoice) {
                //Exit
                case 0 -> {
                    System.exit(0);
                }
                //Admin
                case 1 -> {
                    adminMenu();
                }
                //Kasserer
                case 2 -> {
                    kassererMenu();
                }
                //Træner
                case 3 -> {
                    trænerMenu();
                }
                default -> System.out.println("Forkert input");
            }
        }
    }

    public static void startMenu() {
        System.out.println("________________________________________");
        System.out.println("|         DELFINEN SVØMMEKLUB          |");
        System.out.println("|______________________________________|");
        System.out.println("| Tast 1. : Log ind som administrator. |");
        System.out.println("| Tast 2. : Log ind som kasserer.      |");
        System.out.println("| Tast 3. : Log ind som træner.        |");
        System.out.println("| Tast 0. : Afslut programmet.         |");
        System.out.println("|______________________________________|");
    }

    public void adminMenu() {
        //System.out.println("Delfinen har XX antal medlemmer på nuværende tidspunkt aktive/passive");
        System.out.println("Valgmuligheder: ");
        System.out.println("1. Tilføj nye medlemmer \n2. Søg efter medlem\n3. Slet medlem" +
                "\n4. Rediger stamoplysning for medlem\n5.Se alle medlemmer i klubben \n0. Tilbage til startmenu");

        while (userChoice != 0) {
            userChoice = Integer.parseInt(input.next());
            switch (userChoice) {
                case 0 -> {
                    startMenu();
                }
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                default -> System.out.println("Forkert input");
            }
        }
    }


    public void kassererMenu() {
        System.out.println("Delfinens årlige indtægt: "); //+ calculate annual fee ); og evt. også Medlemmernes samlede gæld
        System.out.println("Valgmuligheder: ");
        System.out.println("1. Søg efter medlem\n2. Se liste af medlemmer med restance\n0. Tilbage til startmenu");
        while (userChoice != 0) {
            userChoice = Integer.parseInt(input.next());
            switch (userChoice) {
                case 0 -> {
                    startMenu();
                }
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                default -> System.out.println("Forkert input");
            }
        }

    }

    public void trænerMenu() {
        System.out.println("Valgmuligheder: ");
        System.out.println("1. Se holdlister efter træner\n2. Se top fem træningstider efter svømmediscplin" +
                "\n3. Tilføj konkurrenceresultat\n4. Tilføj træningsresultat\n5.Søg efter medlem\n0. Tilbage til startmenu");

        while (userChoice != 0) {
            userChoice = Integer.parseInt(input.next());
            switch (userChoice) {
                case 0 -> {
                    startMenu();
                }
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                default -> System.out.println("Forkert input");
            }
        }

    }

}

