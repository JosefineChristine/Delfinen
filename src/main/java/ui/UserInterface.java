package ui;

import domain_model.*;
import domain_model.Record;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

//DELVIST REFAKTORERET (SE TODOS)

public class UserInterface {

    //***ATTRIBUTES& OBJECTS***-----------------------------------------------------------------------------------------
    Scanner input = new Scanner(System.in);
    Controller controller = new Controller();
    int userChoice;

    //***START PROGRAM***-----------------------------------------------------------------------------------------------
    public void startProgram() {

        startMenu();

        while (userChoice != 7) {
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

        while (userChoice != 0) {
            System.out.println("**********************ADMINSTRATOR**********************");
            System.out.println("Delfinen har " + controller.activeMembersCount() + " aktive medlemmer på nuværende tidspunkt.");
            System.out.println("Delfinen har " + controller.inActiveMembersCount() + " passive medlemmer på nuværende tidspunkt.");
            System.out.println("________________________________________________________");
            System.out.println("Valgmuligheder: ");
            System.out.println("1. Tilføj nye medlemmer\n" +
                    "2. Søg efter medlem\n" +
                    "3. Slet medlem\n" +
                    "4. Rediger stamoplysning for medlem\n" +
                    "5. Se alle medlemmer i klubben \n" +
                    "0. Tilbage til startmenu");

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
                    switch (memberTypeChoice) {
                        case 1 -> {
                            addMember("Konkurrencesvømmer");
                        }
                        case 2 -> {
                            addMember("Motionssvømmer");
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

        while (userChoice != 0) {
            System.out.println("*********************KASSERER*********************");
            System.out.println("Delfinens årlige indtægt: " +
                                controller.calculateAnnualIncome());
            System.out.println("Klubbens medlemmer har i alt " +
                                controller.calculateTotalDebt() + " i restance.");
            System.out.println("__________________________________________________");
            System.out.println("Valgmuligheder: ");
            System.out.println("1. Søg efter medlem\n" +
                                "2. Se liste af medlemmer med restance\n" +
                                "0. Tilbage til startmenu");

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

        while (userChoice != 0) {
            System.out.println("**********************TRÆNER**********************");
            System.out.println("Valgmuligheder: ");
            System.out.println("1. Se liste af medlemmer efter træner  \n" +
                                "2. Se top fem træningstider efter svømmedisciplin \n" +
                                "3. Tilføj konkurrenceresultat                     \n" +
                                "4. Tilføj træningsresultat                        \n" +
                                "5. Søg efter medlem                               \n" +
                                "0. Tilbage til startmenu                          \n");

            userChoice = Integer.parseInt(input.next());

            switch (userChoice) {
                case 0 -> {
                    startMenu();
                }
                case 1 -> {
                    //TODO se holdliste efter træner
                    System.out.println("Søg efter træner som du gerne vil se en medlemsliste over");
                    System.out.println(controller.getCoachList());
                    searchCoach();

                    // Coach coach = controller.findSpecificCoach(trænerSøgning);
                    // System.out.println("For træner " + coach.getCoachFirstName() + " " + coach.getCoachLastName());
                    //System.out.println("liste af konkurrencemedlemmer");
                    // coach.getCompetitionMemberListForCoach();

                }
                case 2 -> {
                    showTopFive();
                }
                case 3 -> {
                    System.out.println("Du har valgt at tilføje et konkurrenceresultat");
                    System.out.println("Søg svømmer som skal have et konkurrenceresultat");

                    String searchMember = input.nextLine();
                    Member member = controller.findSpecificMember(searchMember);

                    if (member == null) {
                        System.out.println("Medlem ikke fundet.");
                        return;
                    }

                    if (!(member instanceof CompetitionMember)) {
                        System.out.println("Medlemmet er ikke en konkurrencemedlem.");
                        return;
                    }

                    CompetitionMember competitionMember = (CompetitionMember) member;

                    System.out.println("Tilføj eventnavn");
                    String eventName = input.next();

                    System.out.println("Tilføj disciplin");
                    String discipline = input.next();

                    System.out.println("Tilføj resultat (fx. 5.08)");
                    double result = input.nextDouble();

                    System.out.println("Tilføj dato for konkurrenceresultat");
                    int dayOfCompetition = -1;

                    while (dayOfCompetition < 1 || dayOfCompetition > 31) {
                        System.out.println("Tilføj dag (DD)");
                        String userInput = input.next();

                        if (userInput.matches("0[1-9]|[1-2][0-9]|3[0-1]")) {
                            dayOfCompetition = Integer.parseInt(userInput);
                            if (dayOfCompetition >= 1 && dayOfCompetition <= 31) {
                                break;
                            }
                        }
                        System.out.println("Input er ikke accepteret, tast venligst en godkendt dag mellem 01-31.");
                    }

                    int monthOfCompetition = -1;

                    while (monthOfCompetition < 1 || monthOfCompetition > 12) {
                        System.out.println("Tilføj måned (MM)");
                        String userInput = input.next();

                        if (userInput.matches("0[1-9]|1[0-2]")) {
                            monthOfCompetition = Integer.parseInt(userInput);
                            if (monthOfCompetition >= 1 && monthOfCompetition <= 12) {
                                break;
                            }
                        }
                        System.out.println("Input er ikke accepteret, tast venligst en godkendt måned mellem 01-12.");
                    }

                    int yearOfCompetition = -1;

                    int currentYear = Year.now().getValue();
                    int minYear = currentYear - 10;

                    while (yearOfCompetition < minYear || yearOfCompetition > currentYear) {
                        System.out.println("Tilføj årstal (YYYY)");
                        String userInput = input.next();

                        if (userInput.matches("\\d{4}")) {
                            yearOfCompetition = Integer.parseInt(userInput);
                            if (yearOfCompetition >= minYear && yearOfCompetition <= currentYear) {
                                break;
                            }
                        }
                        System.out.println("Input er ikke accepteret, tast venligst et godkendt årstal.");
                    }
                    LocalDate competitionDate = LocalDate.of(yearOfCompetition, monthOfCompetition, dayOfCompetition);

                    System.out.println("Tilføj sted");
                    String place = input.next();

                   CompetitionRecord competitionRecord = new CompetitionRecord(eventName, discipline, result, competitionDate, place);
                   competitionRecord.addRecord(competitionRecord);

                   System.out.println("Rekorden er tilføjet til medlemmet.");

                }

                case 4 -> {
                    //tilføj træningsresultat
                    System.out.println("Du har valgt at tilføje et træningsresultat");
                    System.out.println("Skriv navnet på det medlem du vil tilføje resultatet til:"); //TODO skrive fornavn/efternavn/begge dele?

                    String searchMember = input.nextLine();
                    Member member = controller.findSpecificMember(searchMember);

                    if (member == null) {
                        System.out.println("Medlem ikke fundet.");
                        return;
                    }

                    if (!(member instanceof CompetitionMember)) {
                        System.out.println("Medlemmet er ikke en konkurrencemedlem.");
                        return;
                    }

                    CompetitionMember competitionMember = (CompetitionMember) member;

                    String title = input.next();

                    System.out.println("Tilføj disciplin");
                    String discipline = input.next();

                    System.out.println("Tilføj resultat (fx. 5.08)");
                    double result = input.nextDouble();

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
                            monthOfTraining = Integer.parseInt(userInput);
                            if (monthOfTraining >= 1 && monthOfTraining <= 12) {
                                break;
                            }
                        }
                        System.out.println("Input er ikke accepteret, tast venligst en godkendt måned mellem 01-12.");
                    }

                    int yearOfTraining = -1;

                    int currentYear = Year.now().getValue();
                    int minYear = currentYear - 10;

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

                    LocalDate trainingDate = LocalDate.of(yearOfTraining, monthOfTraining, dayOfTraining);
                    input.nextLine();

                    TrainingRecord trainingRecord = new TrainingRecord(title, discipline, result, trainingDate);
                    trainingRecord.addRecord(trainingRecord);

                    System.out.println("Rekorden er tilføjet til medlemmet.");
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

        int dayOfBirth = -1;

        while (dayOfBirth < 1 || dayOfBirth > 31) {
            System.out.println("Tilføj fødselsdag (DD)");
            String userInput = input.next();

            if (userInput.matches("0[1-9]|[1-2][0-9]|3[0-1]")) {
                dayOfBirth = Integer.parseInt(userInput);
                if (dayOfBirth >= 1 && dayOfBirth <= 31) {
                    break;
                }
            }
            System.out.println("Input er ikke accepteret, tast venligst en godkendt fødselsdag mellem 01-31.");
        }

        int monthOfBirth = -1;

        while (monthOfBirth < 1 || monthOfBirth > 12) {
            System.out.println("Tilføj fødselsmåned (MM)");
            String userInput = input.next();

            if (userInput.matches("0[1-9]|1[0-2]")) {
                monthOfBirth = Integer.parseInt(userInput);
                if (monthOfBirth >= 1 && monthOfBirth <= 12) {
                    break;
                }
            }
            System.out.println("Input er ikke accepteret, tast venligst en godkendt fødselsmåned mellem 01-12.");
        }

        int yearOfBirth = -1;

        int currentYear = Year.now().getValue();
        int minYear = currentYear - 120;

        while (yearOfBirth < minYear || yearOfBirth > currentYear) {
            System.out.println("Tilføj fødselsår (YYYY)");
            String userInput = input.next();

            if (userInput.matches("\\d{4}")) {
                yearOfBirth = Integer.parseInt(userInput);
                if (yearOfBirth >= minYear && yearOfBirth <= currentYear) {
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
        } else if (memberType.equals("Konkurrencesvømmer")) {
            controller.addCompetitionMember(new CompetitionMember(memberFirstName, memberLastName, userBirthday, debt, isActive));
        }

        System.out.println("Medlemmet er nu blevet tilføjet til databasen.");
        System.out.println("Stamoplysninger om medlem:");
        System.out.println("Navn: " + memberFirstName + " " + memberLastName);
        System.out.println("Fødselsdag: " + userBirthday);
        System.out.println("Restance: " + debt);
        System.out.println("Er brugeren aktiv: " + memberStatus);
        System.out.println("...................................");
    }

    public void searchMember() {
        System.out.println("Indtast fornavn eller efternavn på det medlem du vil søge efter: ");
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
        input.nextLine();
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
            boolean output = controller.deleteMember(matchingMembers.
                                        get(memberIndex).
                                        getMemberFirstName());
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
        System.out.println("Skriv navnet på det medlem du vil redigere stamoplysningerne for: ");
        input.nextLine();
        String memberName = input.nextLine().trim();

        ArrayList<Member> matchingMembers = controller.searchMember(memberName);

        if (matchingMembers.isEmpty()) {
            System.out.println("Der blev ikke fundet noget medlem med det navn.");
            return;
        }

        System.out.println("Fundne medlemmer:");
        for (int i = 0; i < matchingMembers.size(); i++) {
            System.out.println((i + 1) + ": " + matchingMembers.get(i).toString());
        }

        System.out.println("Vælg nummeret på det medlem, du vil redigere:");
        int memberIndex;
        try {
            memberIndex = Integer.parseInt(input.nextLine().trim()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt valg.");
            return;
        }

        if (memberIndex >= 0 && memberIndex < matchingMembers.size()) {
            Member targetMember = matchingMembers.get(memberIndex);
            int menuOption = -1;
            while (menuOption != 0) {
                System.out.println("Skriv 1 for at ændre fornavnet" + "\n" +
                                    "Skriv 2 for at ændre efternavnet" + "\n" +
                                    "Skriv 3 for at ændre fødselsdatoen" + "\n" +
                                    "Skriv 4 for at ændre medlemmets gæld" + "\n" +
                                    "Skriv 5 for at ændre medlemmet aktivitetsstatus. Skriv 'aktiv' eller 'passiv'" + "\n" +
                                    "Skriv 0 for at forlade redigeringen:" + "\n");

                try {
                    menuOption = Integer.parseInt(input.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Ugyldig input. Prøv igen.");
                }

                if (menuOption == 0)
                    break;

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
            String memberName = member.getMemberFirstName() + " " + member.getMemberLastName();
            System.out.println(member.toString());

            if (member instanceof CompetitionMember){
                ArrayList<Record> memberRecords = ((CompetitionMember) member).getMemberRecords();
                for (Record memberRecord : memberRecords){
                    System.out.println(memberName);
                    System.out.println(memberRecord.toString());
                }
            }
        }
//
    }

//    public void printCoachList () { //TODO ret så den passer på coach
//        //3. Overblik over hele filmsamlingen
//        System.out.println("Overview of your Movie Collection");
//        for (Movie movie : controller.getMovieCollection()) {
//            System.out.println(movie.toString());
//        }
//    }

    public void searchCoach() {
        System.out.println("Søg efter træner:");
        input.nextLine();
        String search = input.nextLine();
        ArrayList<Coach> coachList = controller.searchCoach(search);
        for (Coach coach : coachList) {
            System.out.println(coach.getMemberListForCoach());
        }
    }

    public void selectCoach() {
        System.out.println("Skriv navnet på den træner, du ønsker at se medlemmer for:");
        input.nextLine();
        String userInput = input.nextLine().trim();

        ArrayList<Coach> matchingCoaches = controller.searchCoach(userInput);

        if (matchingCoaches.isEmpty()) {
            System.out.println("Der blev ikke fundet nogen træner med det navn.\n");
            return;
        }

        System.out.println("Fundne trænere:");
        for (int i = 0; i < matchingCoaches.size(); i++) {
            System.out.println((i + 1) + ": " + matchingCoaches.get(i).toString());
        }

        System.out.println("Vælg nummeret på den træner, du vil se medlemmer for:");
        int memberIndex = Integer.parseInt(input.nextLine()) - 1;

        if (memberIndex >= 0 && memberIndex < matchingCoaches.size()) {
            System.out.println("Print holdliste for træner");
//            boolean output = controller.(matchingCoaches.get(memberIndex).getCoachFirstName());
//            if (!output) {
//                System.out.println("Der blev ikke fundet en træner med det navn.\n");
//            } else {
//                System.out.println("Print medlemsliste"); //TODO print holdliste for træner
//            }
//        } else {
//            System.out.println("Ugyldigt valg.");
        }

    }
    public void showTopFive(){
        CompetitionMember[] topFiveMembers = new CompetitionMember[5];

        System.out.println("*******TOP 5*********" + "\n");
        System.out.println("Vælg disciplin for at se de 5 hurtigeste svømmere:");
        input.nextLine();
        String chosenDiscipline = input.nextLine().trim();
        System.out.println("Vælg aldersgruppe: ");
        String ageGroup = input.nextLine().trim();
        topFiveMembers = controller.getTeamTopFive(chosenDiscipline, ageGroup);

        for (Member member : topFiveMembers) {
            if (member != null){
                System.out.println(member.toString());
            }
        }
    }
}

