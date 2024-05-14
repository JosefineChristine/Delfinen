package ui;

import domain_model.CompetitionMember;
import domain_model.Controller;
import domain_model.Member;

import java.time.LocalDate;
import java.util.ArrayList;
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
        //TODO System.out.println("Delfinen har XX antal medlemmer på nuværende tidspunkt aktive/passive");
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
                    System.out.println("Vil du tilføje en motionssvømmer eller en konkurrencesvømmer?");
                    System.out.println("1. Konkurrencesvømmer");
                    System.out.println("2. Motionssvømmer");
                    switch (userChoice){
                        case 1 ->{
                    addCompetitionMember();
                        }
                        case 2 -> {
                            //TODO tilføj add motionssvømmermetode
                        }
                    }
                }
                case 2 -> {
                    searchMember();
                }
                case 3 -> {
                    deleteMember();
                }
                case 4 -> {
                    editMember();
                }
                case 5 -> {
                    printMemberList();
                }
                default -> System.out.println("Forkert input");
            }
        }
    }


    public void kassererMenu() {
        //KassererMenu skal indeholde:
        //Se holdliste efter træner
        //Se TOP5 træningsrekorder for alle discipliner
        //Tilføje konkurrenceresultater
        //Søge efter medlem -> som skal vise hvad?
        System.out.println("Delfinens årlige indtægt: "); //TODO + calculate annual fee ); og evt. også Medlemmernes samlede gæld
        System.out.println("Valgmuligheder: ");
        System.out.println("1. Søg efter medlem\n2. Se liste af medlemmer med restance\n0. Tilbage til startmenu");
        while (userChoice != 0) {
            userChoice = Integer.parseInt(input.next());
            switch (userChoice) {
                case 0 -> {
                    startMenu();
                }
                case 1 -> {
                    searchMember();
                }
                case 2 -> {
                    //se liste med restance
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
                    //se holdliste efter træner
                }
                case 2 -> {
                    //top 5
                }
                case 3 -> {
                    //tilføj konk resultat
                }
                case 4 -> {
                    //tilføj træn resultat
                }
                case 5 -> {
                    //søg og se resultater
                }
                default -> System.out.println("Forkert input");
            }
        }

    }

    public String getUserString() {
        String userInput;
        do {

            userInput = input.nextLine();
            input.nextLine();
            if (userInput.trim().isEmpty()) {
                System.out.println("Forkert inpput. Prøv igen.");
            }

        } while (userInput.trim().isEmpty());

        return userInput;
    }

    public void addCompetitionMember() {
        //1. Bruger input - Medlemmets detaljer
        System.out.println("Tilføj medlemmets fornavn");
        String memberFirstName = getUserString();
        System.out.println(memberFirstName);

        System.out.println("Tilføj medlemmets efternavn");
        String memberLastName = getUserString();
        System.out.println(memberLastName);

        System.out.println("Tilføj medlemmets fødselsdag ");
        System.out.println("Tilføj fødselsdag (DD)");
        int dayOfBirth = Integer.parseInt(input.next()); // Her er opdateret
        System.out.println("Tilføj fødselsmåned (MM)");
        int monthOfBirth = Integer.parseInt(input.next()); // Her er opdateret
        System.out.println("Tilføj fødselsår (YYYY)");
        int yearOfBirth = Integer.parseInt(input.next()); // Her er opdateret
        LocalDate userBirthday = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        System.out.println(userBirthday);
        //TODO tag localdate ind

        System.out.println("Tilføj medlemmets restance");
        int debt = Integer.parseInt(input.next()); // Her er opdateret

        System.out.println("Er medlemmet aktiv eller passiv? ('Aktiv' eller 'Passiv)");
        String active = getUserString();
        boolean isActive = active.equals("Aktiv");

        //TODO dateOfBirth mangler ordentigt at kunne ændres
        controller.addCompetitionMember(new CompetitionMember(memberFirstName, memberLastName, userBirthday, debt, isActive));

        System.out.println("Medlemmet er nu blevet tilføjet til databasen: ");
        System.out.println("Stamoplysninger om medlem:");
        System.out.println("Navn: " + memberFirstName + memberLastName);
        System.out.println("Fødselsdag: " + userBirthday);
        System.out.println("Restance: " + debt);
        System.out.println("Er brugeren aktiv: " + isActive);
        System.out.println("...................................");
    }

    public void searchMember() {
        //2. Søge efter medlem
        System.out.println("Søg efter medlem");
        String search = getUserString();
        ArrayList<Member> printMemberList = controller.searchMember(search);
        for (Member member : printMemberList) {
            System.out.println(member.toString());
        }

    }

    public void deleteMember() {
        System.out.println("Hvilket medlem vil du slette?"); //TODO forklar hvad man skal søge på
        String userInput = input.nextLine();

        boolean output = controller.deleteMember(userInput);

        if (!output) {
            System.out.println("Der blev ikke fundet et medlem med det navn.\n");
        } else {
            System.out.println("Medlemmet " + userInput + " blev slettet.\n");
        }

    }

    public void editMember() {
        int menuOption = -1;
        System.out.println("Skriv navnet på det medlem du vil redigere stamoplysningerne for: ");

        String memberName = getUserString();
        Member targetMember = controller.findSpecificMember(memberName);

        if (targetMember != null) {
            System.out.println(targetMember.toString());
        } else {
            System.out.println("Medlemmet blev ikke fundet.");
            editMember();
        }

        while (menuOption != 0) {
            System.out.println("Skriv 1 for at ændre fornavnet" + "\n" +
                    "Skriv 2 for at ændre efternavnet" + "\n" +
                    "Skriv 3 for at ændre fødselsdatoen" + "\n" +
                    "Skriv 4 for at ændre medlemmets gæld" + "\n" +
                    "Skriv 5 for at ændre medlemmet aktivitetsstatus" + "\n" +
                    "Skriv 0 for at forlade redigeringen:" + "\n");

            menuOption = Integer.parseInt(input.next()); // Her er opdateret med skal muligvis ændres eller uddybes
            if (menuOption == 0) break;
            System.out.println("Skriv hvad du vil ændre det til: ");
            String newValue = getUserString();
            Member editedMember = controller.editMember(targetMember, menuOption, newValue);
            System.out.println(editedMember.toString());
        }
    }

    public void printMemberList() {
        System.out.println("Liste over alle medlemmer:");
        for (Member member : controller.getMemberList()) {
            System.out.println(member.toString());
        }
    }


}

