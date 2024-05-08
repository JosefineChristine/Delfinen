package ui;

import domain_model.Controller;

import java.util.Scanner;

public class UserInterface {

    Scanner input = new Scanner(System.in);
    Controller controller = new Controller();

    int userChoice;

    public void startProgram() {

        while (userChoice != 7) {
            menu();
            userChoice = Integer.parseInt(input.next());

            switch (userChoice) {
                case 0 -> {
                    System.exit(0);;
                }
                case 1 -> {
                    System.out.println("Test print 1");
                }
                case 2 -> {
                    System.out.println("Test print 2");
                }
                case 3 -> {
                    System.out.println("Test print 3");
                }
                case 4 -> {
                    System.out.println("Test print 4");
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
    public static void menu() {
        System.out.println("________________________________________");
        System.out.println("|         DELFINEN SVØMMEKLUB          |");
        System.out.println("|______________________________________|");
        System.out.println("| Tast 1. : Log ind som administrator. |");
        System.out.println("| Tast 2. : Log ind som kasserer.      |");
        System.out.println("| Tast 3. : Log ind som træner.        |");
        System.out.println("| Tast 0. : Afslut programmet.         |");
        System.out.println("|______________________________________|");
    }
}

