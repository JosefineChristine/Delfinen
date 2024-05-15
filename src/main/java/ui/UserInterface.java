package ui;

import domain_model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    //***ATTRIBUTES& OBJECTS***-----------------------------------------------------------------------------------------
    Scanner input = new Scanner(System.in);
    Controller controller = new Controller();

    int userChoice;

    //***START PROGRAM***-----------------------------------------------------------------------------------------------
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

    //***MENU METHODS***------------------------------------------------------------------------------------------------
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
        System.out.println("Delfinen har " + controller.activeMembersCount() + " aktive medlemmer på nuværende tidspunkt.");
        System.out.println("Delfinen har " + controller.inActiveMembersCount() + " passive medlemmer på nuværende tidspunkt.");
        System.out.println("Valgmuligheder: ");
        System.out.println("1. Tilføj nye medlemmer\n" +
                           "2. Søg efter medlem\n" +
                           "3. Slet medlem\n" +
                           "4. Rediger stamoplysning for medlem\n" +
                           "5. Se alle medlemmer i klubben \n" +
                           "0. Tilbage til startmenu");

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
                            //TODO tilføj add motionssvømmermetode (copy paste når det virker)
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
        System.out.println("Delfinens årlige indtægt: " + controller.calculateAnnualIncome());
        System.out.println("Klubbens medlemmer har i alt " + controller.calculateTotalDebt() + " i restance.");
        System.out.println("Valgmuligheder: ");
        System.out.println("1. Søg efter medlem\n" +
                           "2. Se liste af medlemmer med restance\n" +
                           "0. Tilbage til startmenu");
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
                    allMembersWithDebtList();
                }
                default -> System.out.println("Forkert input");
            }
        }
    }

    public void trænerMenu() {
        //trænerMenu skal indeholde:
        //Se holdliste efter træner
        //Se TOP5 træningsrekorder for alle discipliner
        //Tilføje konkurrenceresultater
        //Søge efter medlem -> som skal vise hvad?

        System.out.println("Valgmuligheder: ");
        System.out.println("1. Se holdlister efter træner                     \n" +
                           "2. Se top fem træningstider efter svømmedisciplin \n" +
                           "3. Tilføj konkurrenceresultat                     \n" +
                           "4. Tilføj træningsresultat                        \n" +
                           "5. Søg efter medlem                               \n" +
                           "0. Tilbage til startmenu                          \n");

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
                    //top 5  -> venter på Vahab
                }
                case 3 -> {
                        System.out.println("Du har valgt at tilføje et konkurrenceresultat");
                        System.out.println("Søg svømmer som skal have et konkurrenceresultat");
                        String searchMember = input.nextLine();
                        controller.findSpecificMember(searchMember);

                        System.out.println("Tilføj konkurrence titel");
                        String titel = input.next(); // hvad er titel?

                        System.out.println("Tilføj disciplin");
                        String disciplin = input.next();

                        System.out.println("Tilføj resultat (tiden skal have et komma)");
                        double resultat = input.nextDouble();

                        System.out.println("Tilføj dato for konkurrenceresultat");
                        System.out.println("Tilføj dag (DD)");
                        int dayOfBirth = input.nextInt();               // max to cifre
                        System.out.println("Tilføj måned (MM)");
                        int monthOfBirth = input.nextInt();             // max to cifre
                        System.out.println("Tilføj årstal (YYYY)");
                        int yearOfBirth = input.nextInt();              // max fire cifre
                        LocalDate konkurrenceDato = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);

                        System.out.println("Tilføj begivenhed");
                        String begivenhed = input.next();

                        controller.addRecord(new CompetitionRecord(titel, disciplin,resultat, konkurrenceDato, begivenhed));
                        // TODO add CompetitionRecord til CompetitionMember - but how?
                }

                case 4 -> {
                    //tilføj træn resultat
                    System.out.println("Du har valgt at tilføje et træningsresultat");
                    System.out.println("Tilføj titel"); // hvad er titel? //TODO slet titel?
                    String titel = input.next();

                    System.out.println("Tilføj disciplin");
                    String disciplin = input.next();

                    System.out.println("Tilføj resultat (tiden skal have et komma)");
                    double resultat = input.nextDouble();

                    System.out.println("Tilføj dato for træningsresultat");
                    System.out.println("Tilføj dato (DD)");
                    int dayOfBirth = input.nextInt();            // max to cifre
                    System.out.println("Tilføj måned (MM)");
                    int monthOfBirth = input.nextInt();          // max to cifre
                    System.out.println("Tilføj årstal (YYYY)");
                    int yearOfBirth = input.nextInt();           // max fire cifre
                    LocalDate træningsDato = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);

                    controller.addRecord(new TrainingRecord(titel, disciplin, resultat, træningsDato)); //tilføj Trænings resultat
                    //controller.AddRecordToMember(searchMember) -> eller hvordan tilføjer vi til member?
                    // TODO add TrainingRecord til CompetitionMember - but how?
                }
                case 5 -> {
                    //søg og se resultater
                }
                default -> System.out.println("Forkert input");
            }
        }

    }

    //***OTHER METHODS***-----------------------------------------------------------------------------------------------

    public String getUserString() {
        String userInput;
        do {
            userInput = input.nextLine();
            input.nextLine();
            if (userInput.trim().isEmpty()) {
                System.out.println("Forkert input. Prøv igen.");
            }

        } while (userInput.trim().isEmpty());

        return userInput;
    }

    public void addCompetitionMember() {
        //TODO Virker ikke, 1=forkert input, 2=formentlig nextline bug
        //1. Bruger input - Medlemmets detaljer
        System.out.println("Tilføj medlemmets fornavn");
        String memberFirstName = getUserString();
        System.out.println(memberFirstName);

        System.out.println("Tilføj medlemmets efternavn");
        String memberLastName = getUserString();
        System.out.println(memberLastName);

        System.out.println("Tilføj medlemmets fødselsdag ");
        System.out.println("Tilføj fødselsdag (DD)");
        int dayOfBirth = Integer.parseInt(input.next()); // Her er opdateret // max to cifre
        System.out.println("Tilføj fødselsmåned (MM)");
        int monthOfBirth = Integer.parseInt(input.next()); // Her er opdateret // max to cifre
        System.out.println("Tilføj fødselsår (YYYY)");
        int yearOfBirth = Integer.parseInt(input.next()); // Her er opdateret // max fire cifre
        LocalDate userBirthday = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        System.out.println(userBirthday);
        //TODO tjek om localdate virker

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
        //TODO siger 'forkert input' når man søger på Vahab
        System.out.println("Søg efter medlem");
        String search = getUserString();
        ArrayList<Member> printMemberList = controller.searchMember(search);
        for (Member member : printMemberList) {
            System.out.println(member.toString());
        }
    }

    public void allMembersWithDebtList() {
        ArrayList<Member> membersWithDebt = controller.searchMemberDebt();

        if (membersWithDebt.isEmpty()) {
            System.out.println("Ingen medlemmer med restance fundet");
        } else {
            System.out.println("Medlemmer med restance: ");
            for (Member member : membersWithDebt) {
                System.out.println(member.toString());
            }
        }
    }

    public void deleteMember() {
        //TODO Printer følgende to linjer når man vælge den mulighed:
        // Hvilket medlem vil du slette?
        // Der blev ikke fundet et medlem med det navn.

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
        //TODO virker ikke, siger forkert input når man skrive vahab
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
        //TODO listen bliver ikke printet
        System.out.println("Liste over alle medlemmer:");
        for (Member member : controller.getMemberCollection()) {
            System.out.println(member.toString());
        }
    }


}

