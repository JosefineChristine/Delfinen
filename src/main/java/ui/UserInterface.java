package ui;

import domain_model.*;

import java.time.LocalDate;
import java.time.Year;
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
                default -> System.out.println("Forkert input!");
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

    //TODO sørg for man kan komme tilbage til menuen, i stedet for at skulle stoppe programmet for at gøre noget nyt

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
                    input.nextLine();
                    System.out.println("1. Konkurrencesvømmer");
                    System.out.println("2. Motionssvømmer");
                    int memberTypeChoice = Integer.parseInt(input.next());
                    switch (memberTypeChoice){
                        case 1 ->{
                            String membershipType = "Konkurrencesvømmer";
                    addMember(membershipType);
                        }
                        case 2 -> {
                            String membershipType = "Motionssvømmer";
                    addMember(membershipType);
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
        System.out.println("Valgmuligheder: ");
        System.out.println("1. Se liste af medlemmer efter træner  \n" +
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
                    //TODO se holdliste efter træner
                    System.out.println("Søg efter træner som du gerne vil se en medlemsliste over");
                   // Coach coach = searchCoach();

                   // Coach coach = controller.findSpecificCoach(trænerSøgning);
                   // System.out.println("For træner " + coach.getCoachFirstName() + " " + coach.getCoachLastName());
                    //System.out.println("liste af konkurrencemedlemmer");
                   // coach.getCompetitionMemberListForCoach();

                }
                case 2 -> {
                    //TODO top 5 -> venter på Vahab
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

                    CompetitionRecord competitionRecord = new CompetitionRecord(titel, disciplin, resultat, konkurrenceDato, begivenhed);
                    controller.addRecord(competitionRecord);
                    System.out.println("Søg medlem du vil tilføje rekord til");
                    String medlemsSøgning = input.nextLine();

                    // TODO tilføj findSpecificMember
                    //CompetitionMember targetMember = controller.findSpecificMember(medlemsSøgning)
                    //controller.addCompetitionRecordToMember(targetMember);


                }

                case 4 -> {
                    //tilføj træningsresultat
                    System.out.println("Du har valgt at tilføje et træningsresultat");
                    System.out.println("Tilføj titel"); // hvad er titel? //TODO slet titel?
                    String titel = input.next();

                    System.out.println("Tilføj disciplin");
                    String disciplin = input.next();

                    System.out.println("Tilføj resultat (tiden skal have et komma)");
                    double resultat = input.nextDouble();

                    System.out.println("Tilføj dato for træningsresultat");

                    int dayOfTraining = -1;
                    while (dayOfTraining < 1 || dayOfTraining > 31) {
                        System.out.println("Tilføj dag (DD)");
                        String userInput = input.next();

                        if (userInput.matches("0[1-9]|[1-2][0-9]|3[0-1]")) {
                            dayOfTraining = Integer.parseInt(userInput);
                            if (dayOfTraining >= 1 && dayOfTraining <= 31) {
                                break;
                            }
                        }
                        System.out.println("Input er ikke accepteret, tast venligst en godkendt dag mellem 01-31.");
                    }

                    int monthOfTraining = -1;

                    while (monthOfTraining < 1 || monthOfTraining > 12) {
                        System.out.println("Tilføj måned (MM)");
                        String userInput = input.next();

                        if (userInput.matches("0[1-9]|1[0-2]")) {
                            monthOfTraining= Integer.parseInt(userInput);
                            if (monthOfTraining >= 1 && monthOfTraining <= 12) {
                                break;
                            }
                        }
                        System.out.println("Input er ikke accepteret, tast venligst en godkendt måned mellem 01-12.");
                    }

                    int yearOfTraining= -1;

                    int currentYear = Year.now().getValue();
                    int minYear = currentYear - 10;

                    // Loop until the user enters correct input
                    while (yearOfTraining < minYear || yearOfTraining > currentYear) {
                        System.out.println("Tilføj årstal (YYYY)");
                        String userInput = input.next();

                        if (userInput.matches("\\d{4}")) {
                            yearOfTraining = Integer.parseInt(userInput);
                            if (yearOfTraining >= minYear && yearOfTraining <= currentYear) {
                                break;
                            }
                        }
                        System.out.println("Input er ikke accepteret, tast venligst et godkendt årstal.");
                    }

                    LocalDate træningsDato = LocalDate.of(yearOfTraining, monthOfTraining, dayOfTraining);
                    input.nextLine();

                    controller.addRecord(new TrainingRecord(titel, disciplin, resultat, træningsDato)); //tilføj Trænings resultat
                    //controller.AddRecordToMember(searchMember) -> eller hvordan tilføjer vi til member?
                    // TODO add TrainingRecord til CompetitionMember - but how?
                }
                case 5 -> {
                    //TODO søg og se medlems rekorder
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


    public void addMember(String memberType) {
        input.nextLine();
        System.out.println("Tilføj medlemmets fornavn");
        String memberFirstName = input.nextLine();
        System.out.println(memberFirstName);

        System.out.println("Tilføj medlemmets efternavn");
        String memberLastName = input.nextLine();
        System.out.println(memberLastName);

        int dayOfBirth = -1; // Initialize variable outside valid range

        // Loop until the user enters correct input
        while (dayOfBirth < 1 || dayOfBirth > 31) {
            System.out.println("Tilføj fødselsdag (DD)");
            String userInput = input.next();

            // Check if input consists of two digits
            if (userInput.matches("0[1-9]|[1-2][0-9]|3[0-1]")) {
                dayOfBirth = Integer.parseInt(userInput);
                if (dayOfBirth >= 1 && dayOfBirth <= 31) {
                    // Correct input, exit loop
                    break;
                }
            }
            System.out.println("Input er ikke accepteret, tast venligst en godkendt fødselsdag mellem 01-31.");
        }

        int monthOfBirth = -1; // Initialize variable outside valid range

        // Loop until the user enters correct input
        while (monthOfBirth < 1 || monthOfBirth > 12) {
            System.out.println("Tilføj fødselsmåned (MM)");
            String userInput = input.next();

            // Check if input consists of two digits
            if (userInput.matches("0[1-9]|1[0-2]")) {
                monthOfBirth = Integer.parseInt(userInput);
                if (monthOfBirth >= 1 && monthOfBirth <= 12) {
                    // Correct input, exit loop
                    break;
                }
            }
            System.out.println("Input er ikke accepteret, tast venligst en godkendt fødselsmåned mellem 01-12.");
        }

        int yearOfBirth = -1; // Initialize variable outside valid range

        // Define a realistic range for the year of birth
        int currentYear = Year.now().getValue();
        int minYear = currentYear - 120; // Assuming a person cannot be more than 120 years old

        // Loop until the user enters correct input
        while (yearOfBirth < minYear || yearOfBirth > currentYear) {
            System.out.println("Tilføj fødselsår (YYYY)");
            String userInput = input.next();

            // Check if input consists of four digits
            if (userInput.matches("\\d{4}")) {
                yearOfBirth = Integer.parseInt(userInput);
                if (yearOfBirth >= minYear && yearOfBirth <= currentYear) {
                    // Correct input, exit loop
                    break;
                }
            }
            System.out.println("Input er ikke accepteret, tast venligst et godkendt fødselsår.");
        }

        LocalDate userBirthday = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        System.out.println(userBirthday);

        System.out.println("Tilføj medlemmets restance");
        int debt = Integer.parseInt(input.next());
        input.nextLine();

        System.out.println("Er medlemmet aktiv eller passiv? ('Aktiv' eller 'Passiv')");
        String active = input.nextLine();
        boolean isActive = active.equalsIgnoreCase("Aktiv");
        String memberStatus = isActive ? "Ja" : "Nej";

        if (memberType.equals("Motionssvømmer")) {
            controller.addExerciseMember(new ExerciseMember(memberFirstName, memberLastName, userBirthday, debt, isActive));
        }else if (memberType.equals("Konkurrencesvømmer")) {
            controller.addCompetitionMember(new CompetitionMember(memberFirstName, memberLastName, userBirthday, debt, isActive));
        }

        System.out.println("Medlemmet er nu blevet tilføjet til databasen: ");
        System.out.println("Stamoplysninger om medlem:");
        System.out.println("Navn: " + memberFirstName + " " + memberLastName);
        System.out.println("Fødselsdag: " + userBirthday);
        System.out.println("Restance: " + debt);
        System.out.println("Er brugeren aktiv: " + memberStatus);
        System.out.println("...................................");
    }

    public void searchMember() {
        System.out.println("Indtast fornavn eller efternavn på det medlem du vil søge på: ");
        input.nextLine();
        String search = input.nextLine();
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

        System.out.println("Skriv navnet på det medlem du vil slette");
        input.nextLine(); // Consume leftover newline
        String userInput = input.nextLine().trim();

        ArrayList<Member> matchingMembers = controller.searchMember(userInput);

        if (matchingMembers.isEmpty()) {
            System.out.println("Der blev ikke fundet et medlem med det navn.\n");
            return;
        }

        System.out.println("Fundne medlemmer:");
        for (int i = 0; i < matchingMembers.size(); i++) {
            System.out.println((i + 1) + ": " + matchingMembers.get(i).toString());
        }

        System.out.println("Vælg det nummer på det medlem, du vil slette:");
        int memberIndex = Integer.parseInt(input.nextLine()) - 1;

        if (memberIndex >= 0 && memberIndex < matchingMembers.size()) {
            boolean output = controller.deleteMember(matchingMembers.get(memberIndex).getMemberFirstName());
            if (!output) {
                System.out.println("Der blev ikke fundet et medlem med det navn.\n");
            } else {
                System.out.println("Medlemmet blev slettet.\n");
            }
        } else {
            System.out.println("Ugyldigt valg.");
        }
    }

    public void editMember() {

        int menuOption = -1;
        System.out.println("Skriv navnet på det medlem du vil redigere stamoplysningerne for: ");
        input.nextLine(); // Consume leftover newline
        String memberName = input.nextLine().trim();

        ArrayList<Member> matchingMembers = controller.searchMember(memberName);

        if (matchingMembers.isEmpty()) {
            System.out.println("Der blev ikke fundet et medlem med det navn.");
            return;
        }

        System.out.println("Fundne medlemmer:");
        for (int i = 0; i < matchingMembers.size(); i++) {
            System.out.println((i + 1) + ": " + matchingMembers.get(i).toString());
        }

        System.out.println("Vælg det nummer på det medlem, du vil redigere:");
        int memberIndex = Integer.parseInt(input.nextLine()) - 1;

        if (memberIndex >= 0 && memberIndex < matchingMembers.size()) {
            Member targetMember = matchingMembers.get(memberIndex);

           // int menuOption = -1;
            while (menuOption != 0) {
                System.out.println("Skriv 1 for at ændre fornavnet" + "\n" +
                        "Skriv 2 for at ændre efternavnet" + "\n" +
                        "Skriv 3 for at ændre fødselsdatoen" + "\n" +
                        "Skriv 4 for at ændre medlemmets gæld" + "\n" +
                        "Skriv 5 for at ændre medlemmet aktivitetsstatus. Skriv 'true' eller 'false'" + "\n" + //TODO fix true false til passiv/aktiv
                        "Skriv 0 for at forlade redigeringen:" + "\n");

                menuOption = Integer.parseInt(input.nextLine().trim());

                if (menuOption == 0) break;

                System.out.println("Skriv hvad du vil ændre det til: ");
                String newValue = input.nextLine().trim();

                Member editedMember = controller.editMember(targetMember, menuOption, newValue);
                System.out.println("Opdateret medlem:");
                System.out.println(editedMember.toString());
            }
        } else {
            System.out.println("Ugyldigt valg.");
        }
    }

    public void printMemberList() {
        //TODO printMemberList() har [] fra Arraylisten med teams?
        System.out.println("Liste over alle medlemmer:");
        for (Member member : controller.getMemberCollection()) {
            System.out.println(member.toString());
        }
    }

    /*public Coach searchCoach() {
        //2. Søge efter coach
        System.out.println("Search Coach");
        String search = input.nextLine();
        ArrayList<Coach> printCoachList = controller.searchCoach(search);
        for (Coach coach : printCoachList) {
        }
        //return coach;
    }*/

    public void selectCoach() {

        System.out.println("Skriv navnet på den træner du gerne vil se medlemmer for");
        input.nextLine(); // Consume leftover newline
        String userInput = input.nextLine().trim();

        ArrayList<Coach> matchingCoaches = controller.searchCoach(userInput);

        if (matchingCoaches.isEmpty()) {
            System.out.println("Der blev ikke fundet en træner med det navn.\n");
            return;
        }

        System.out.println("Fundne trænere:");
        for (int i = 0; i < matchingCoaches.size(); i++) {
            System.out.println((i + 1) + ": " + matchingCoaches.get(i).toString());
        }

        /*System.out.println("Vælg det nummer på det af træner, du vil se medlemmer for:");
        int memberIndex = Integer.parseInt(input.nextLine()) - 1;

        if (memberIndex >= 0 && memberIndex < matchingCoaches.size()) {
            boolean output = controller.deleteMember(matchingCoaches.get(memberIndex).getMemberFirstName());
            if (!output) {
                System.out.println("Der blev ikke fundet et medlem med det navn.\n");
            } else {
                System.out.println("Medlemmet blev slettet.\n");
            }
        } else {
            System.out.println("Ugyldigt valg.");
        }
         */
    }

}

