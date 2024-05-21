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
                    startProgram();
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
                                "3. Rediger restance for medlem\n" +
                                "0. Tilbage til startmenu");

            userChoice = Integer.parseInt(input.next());
            switch (userChoice) {
                case 0 -> {
                    startProgram();
                }
                case 1 -> {
                    searchMember();
                }
                case 2 -> {
                    allMembersWithDebtList();
                }
                case 3 -> {
                    editDebt();
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
                                "3. Tilføj resultat                                \n" +
                                "4. Søg efter medlem                               \n" +
                                "0. Tilbage til startmenu                          \n");

            userChoice = Integer.parseInt(input.next());

            switch (userChoice) {
                case 0 -> {
                    startProgram();
                }
                case 1 -> {
                    //TODO fix toString, navn, rekorder, hold, discipliner
                    selectCoach();
                }
                case 2 -> showTopFive(); //TODO: ændr toString, så den printer træningsresultat ud

                case 3 -> addRecord();

                case 4 -> searchMember();

                default -> System.out.println("Forkert input");
            }
        }
    }

    //***OTHER METHODS***-----------------------------------------------------------------------------------------------

    private void addMember(String memberType) {
        input.nextLine();
        System.out.println("Tilføj medlemmets fornavn");
        String memberFirstName = input.nextLine();
        System.out.println(memberFirstName);

        System.out.println("Tilføj medlemmets efternavn");
        String memberLastName = input.nextLine();
        System.out.println(memberLastName);

        LocalDate userBirthday = inputDate("fødselsdag");
        System.out.println(userBirthday);

        System.out.println("Tilføj medlemmets restance");
        int debt = Integer.parseInt(input.next());
        input.nextLine();

        System.out.println("Er medlemmet aktiv? ('Ja' eller 'Nej')");
        String active = input.nextLine();
        boolean isActive = active.equalsIgnoreCase("ja");
        String memberStatus = isActive ? "Ja" : "Nej";

        Member memberToAdd = null;
        if (memberType.equals("Motionssvømmer")) {
            memberToAdd  = (new ExerciseMember(memberFirstName, memberLastName, userBirthday, debt, isActive));
            controller.addExerciseMember((ExerciseMember) memberToAdd);
        } else if (memberType.equals("Konkurrencesvømmer")) {
             memberToAdd = (new CompetitionMember(memberFirstName, memberLastName, userBirthday, debt, isActive));
            controller.addCompetitionMember((CompetitionMember) memberToAdd);
        }

        System.out.println("Medlemmet er nu blevet tilføjet til databasen.");
        System.out.println("Stamoplysninger om medlem:");
        System.out.println("Navn: " + memberFirstName + " " + memberLastName);
        System.out.println("Fødselsdag: " + userBirthday);
        System.out.println("Restance: " + debt);
        System.out.println("Er brugeren aktiv: " + memberStatus);
        System.out.println("Medlemskontingent: " + memberToAdd.calculateMembershipFee());
        System.out.println("...................................");
    }

    // Todo: we could reuse it if we change return type?
    private void searchMember() {
        System.out.println("Indtast fornavn eller efternavn på det medlem du vil søge efter: ");
        input.nextLine();
        String search = input.nextLine();
        ArrayList<Member> printMemberList = controller.searchMember(search);
        for (Member member : printMemberList) {
            System.out.println(member.toString());
        }
    }

    private void allMembersWithDebtList() {
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

    private void deleteMember() {

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

    private void editMember() {
        System.out.println("Ændring af stamplysninger.");
        Member targetMember = searchMembers();

        if (targetMember == null) {
            return;
        }

        int menuOption = -1;
        while (menuOption != 0) {
            System.out.println("Skriv 1 for at ændre fornavnet" + "\n" +
                    "Skriv 2 for at ændre efternavnet" + "\n" +
                    "Skriv 3 for at ændre fødselsdatoen" + "\n" +
                    "Skriv 4 for at ændre medlemmets gæld" + "\n" +
                    "Skriv 5 for at ændre medlemmets aktivitetsstatus. Skriv 'aktiv' eller 'passiv'" + "\n" +
                    "Skriv 0 for at forlade redigeringen:" + "\n");

            try {
                menuOption = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig input. Prøv igen.");
            }

            if (menuOption == 0)
                break;

            System.out.println("Skriv hvad du vil ændre det til:");
            String newValue = input.nextLine().trim();

            Member editedMember = controller.editMember(targetMember, menuOption, newValue);
            if (editedMember != null) {
                System.out.println("Opdateret medlem:");
                System.out.println(editedMember.toString());
            } else {
                System.out.println("Kunne ikke redigere medlem.");
            }
        }
    }

    private void editDebt() {
        System.out.println("Skriv navnet på det medlem du vil redigere restance for: ");
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
                System.out.println("Skriv 1 for at ændre restancen for det valgte medlem" + "\n" +
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

                Member editedMember = controller.editDebt(targetMember, menuOption, newValue);
                System.out.println("Opdateret medlem:");
                System.out.println(editedMember.toString());
            }
        } else {
            System.out.println("Ugyldigt valg.");
        }
    }

    private void printMemberList() {

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
    }

    private void printCoachList () {
        System.out.println("Liste over alle trænere:");

        for (Coach coach : controller.getCoachList()) {
        System.out.println(coach.toString());

        //TODO: Skal vi printe mere end navn?
        }
    }


    private void searchCoach() {
        System.out.println("Søg efter træner:");
        input.nextLine();
        String search = input.nextLine();
        ArrayList<Coach> coachList = controller.searchCoach(search);
    }

    private void selectCoach() {
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
        int coachIndex;
        try {
            coachIndex = Integer.parseInt(input.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt valg.");
            return;
        }

        if (coachIndex >= 0 && coachIndex < matchingCoaches.size()) {
            Coach selectedCoach = matchingCoaches.get(coachIndex);
            System.out.println("Se holdliste for træner " + selectedCoach.getCoachFirstName() + " " + selectedCoach.getCoachLastName() + ":");

            ArrayList<Member> teamMembers = controller.getMemberListForCoach(selectedCoach);

            if (teamMembers.isEmpty()) {
                System.out.println("Der blev ikke fundet nogle medlemmer for denne træner.\n");
            } else {
                System.out.println("Medlemsliste:");
                for (Member member : teamMembers) {
                    System.out.println(member.toString());
                }
            }
        } else {
            System.out.println("Ugyldigt valg.");
        }
    }
    private void showTopFive(){
        CompetitionMember[] topFiveMembers = new CompetitionMember[5];

        System.out.println("*******TOP 5*********" + "\n");
        System.out.println("Vælg disciplin for at se de 5 hurtigeste svømmere:");
        System.out.println("Crawl, butterfly, breaststroke eller backstroke"); //TODO kan vi lave dem på dansk?
        input.nextLine();
        String chosenDiscipline = input.nextLine().trim();
        System.out.println("Vælg aldersgruppe (junior/senior): ");
        String ageGroup = input.nextLine().trim();
        topFiveMembers = controller.getTeamTopFive(chosenDiscipline, ageGroup);


        for (CompetitionMember member : topFiveMembers) {
            if (member != null){
                System.out.println("Navn: " + member.getMemberFirstName() + " " + member.getMemberLastName());
                System.out.println(member.getBestTrainingRecord());

            }
        }

    }


    private LocalDate inputDate(String dateType) {
        System.out.println("Tilføj dato for " + dateType);

        int day = inputDay(dateType);
        int month = inputMonth(dateType);
        int year = inputYear(dateType);

        return LocalDate.of(year, month, day);
    }

    private int inputDay(String dateType) {
        int day = -1;
        while (day < 1 || day > 31) {
            System.out.println("Tilføj dag (DD) for " + dateType);
            String userInput = input.next();

            if (userInput.matches("0[1-9]|[1-2][0-9]|3[0-1]")) {
                day = Integer.parseInt(userInput);
            }
            if (day < 1 || day > 31) {
                System.out.println("Input er ikke accepteret, tast venligst en godkendt dag mellem 01-31.");
            }
        }
        return day;
    }

    private int inputMonth(String dateType) {
        int month = -1;
        while (month < 1 || month > 12) {
            System.out.println("Tilføj måned (MM) for " + dateType);
            String userInput = input.next();

            if (userInput.matches("0[1-9]|1[0-2]")) {
                month = Integer.parseInt(userInput);
            }
            if (month < 1 || month > 12) {
                System.out.println("Input er ikke accepteret, tast venligst en godkendt måned mellem 01-12.");
            }
        }
        return month;
    }

    private int inputYear(String dateType) {
        int year = -1;
        int currentYear = Year.now().getValue();
        int minYear = currentYear - 120;

        while (year < minYear || year > currentYear) {
            System.out.println("Tilføj årstal (YYYY) for " + dateType);
            String userInput = input.next();

            if (userInput.matches("\\d{4}")) {
                year = Integer.parseInt(userInput);
            }
            if (year < minYear || year > currentYear) {
                System.out.println("Input er ikke accepteret, tast venligst et godkendt årstal.");
            }
        }
        return year;
    }

    private CompetitionMember findAndValidateCompetitionMember() {
        Member selectedMember = searchMembers();

        if (!(selectedMember instanceof CompetitionMember)) {
            System.out.println("Medlemmet er ikke en konkurrencemedlem.");
            //return null;
            System.out.println("Tryk enter for at søge igen"); //TODO fix hvis muligt
            searchMembers();
        }

        return (CompetitionMember) selectedMember;
    }


    private Record addRecord(){
        CompetitionMember competitionMember = findAndValidateCompetitionMember();
        if (competitionMember == null) return null;

        System.out.println("Vil du tilføje et konkurrenceresultat eller træningsresultat?");
        //input.nextLine();
        System.out.println("1. Konkurrenceresultat");
        System.out.println("2. Træningsresultat");
        int recordTypeChoice = Integer.parseInt(input.next());
        String dateType = (recordTypeChoice == 1)? "konkurrenceresultat"  : "træningsresultat";
            input.nextLine();
            System.out.println("Tilføj eventnavn");
            String eventName = input.nextLine();

            System.out.println("Tilføj disciplin");
            String discipline = input.nextLine();

            System.out.println("Tilføj resultat i minutter og sekunder (fx. 5.08)");
            double result = input.nextDouble();

            LocalDate RecordDate = inputDate(dateType);


            if(recordTypeChoice ==1 ){
                System.out.println("Tilføj placering");
                input.nextLine();
                String placement = input.nextLine();
                CompetitionRecord recordToAdd = new CompetitionRecord(eventName, discipline, result, RecordDate, placement);
                controller.addCompetitionRecordToMember(competitionMember,recordToAdd);
                return recordToAdd;
            }


        eventName = "Training";
            TrainingRecord recordToAdd = new TrainingRecord(eventName, discipline, result, RecordDate);
            controller.addTrainingRecordToMember(competitionMember,recordToAdd);

        return recordToAdd;

    }
    //Todo : check with search member and findspecificmember in member collection to avoid duplication.
    private Member searchMembers() {
        input.nextLine();
        System.out.println("Søg efter medlem:");
        String searchMember = input.nextLine().trim();

        ArrayList<Member> matchingMembers = controller.searchMember(searchMember);

        if (matchingMembers.isEmpty()) {
            System.out.println("Der blev ikke fundet noget medlem med det navn.");
            return null;
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
            return null;
        }

        if (memberIndex < 0 || memberIndex >= matchingMembers.size()) {
            System.out.println("Ugyldigt valg.");
            return null;
        }

        return matchingMembers.get(memberIndex);
    }

}

