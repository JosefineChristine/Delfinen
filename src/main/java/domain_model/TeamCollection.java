package domain_model;
import java.util.ArrayList;

public class TeamCollection {

    ArrayList<Team> allTheTeams = new ArrayList<>();
    MemberCollection memberCollection = new MemberCollection();
    private ArrayList<Coach> coachList = new ArrayList<>();

    //************COACHES********--------
    Coach coach1 = new Coach("Vahab", "Lotfyyekta");
    Coach coach2 = new Coach("Edith", "Terte");
    Coach coach3 = new Coach("Bjarne", "Larsen");
    Coach coach4 = new Coach("Sommer", "Dahl");
    Coach coach5 = new Coach("Arne", "Falk");

    //************TEAMS********-----
    Team team1 = new Team("crawl", coach1, true);
    Team team2 = new Team("butterfly", coach2, true);
    Team team3 = new Team("backstroke", coach3, true);
    Team team4 = new Team("breaststroke", coach4, true);
    Team team5 = new Team("crawl", coach1, false);
    Team team6 = new Team("butterfly", coach2, false);
    Team team7 = new Team("backstroke", coach3, false);
    Team team8 = new Team("breaststroke", coach4, false);
    Team team9 = new Team("exercise senior", coach5, true);
    Team team10 = new Team("exercise junior", coach5, false);

    public TeamCollection() {
        teamsArrayList();
        populateTeams();
        AddCoachesToList();
        initializeMembersForCoaches();
    }

    //************METHODS********---------
    public ArrayList<Team> getAllTheTeams() {
        return allTheTeams;
    }


    private void AddCoachesToList() {
        addCoachToCoachList(coach1);
        addCoachToCoachList(coach2);
        addCoachToCoachList(coach3);
        addCoachToCoachList(coach4);
        addCoachToCoachList(coach5);
    }


    public void populateTeams() { //Sætter medlemmer ind fra CSV filen til arraylister som enten CompetitionMember eller ExerciseMember
        ArrayList<Member> members;
        members = memberCollection.getMemberList();
        for (Member member : members) {
            if (member instanceof CompetitionMember) {
                addCompetitionMember((CompetitionMember) member);
            } else {
                addExerciseMember((ExerciseMember) member);
            }

        }
    }

    public void addCompetitionMember(CompetitionMember memberToAdd) {
        ArrayList<String> memberDisciplines = memberToAdd.findDisciplines();
        if (memberToAdd.getAgeGroup().equalsIgnoreCase("junior")) {
            for (String memberDiscipline : memberDisciplines) {
                switch (memberDiscipline) {
                    case "crawl" -> team5.addMemberToTeam(memberToAdd);
                    case "butterfly" -> team6.addMemberToTeam(memberToAdd);
                    case "backstroke" -> team7.addMemberToTeam(memberToAdd);
                    case "breaststroke" -> team8.addMemberToTeam(memberToAdd);
                }
            }
        } else {

            for (String memberDiscipline : memberDisciplines) {
                switch (memberDiscipline) {
                    case "crawl" -> team1.addMemberToTeam(memberToAdd);
                    case "butterfly" -> team2.addMemberToTeam(memberToAdd);
                    case "backstroke" -> team3.addMemberToTeam(memberToAdd);
                    case "breaststroke" -> team4.addMemberToTeam(memberToAdd);
                }
            }

        }

    }

    public void addExerciseMember(ExerciseMember memberToAdd) {
        if (memberToAdd.getAgeGroup().equalsIgnoreCase("junior")) {
            team9.addMemberToTeam(memberToAdd);
        } else if (memberToAdd.getAgeGroup().equalsIgnoreCase("senior")) {
            team10.addMemberToTeam(memberToAdd);
        }
    }

    public void teamsArrayList() {

        allTheTeams.add(team1);
        allTheTeams.add(team2);
        allTheTeams.add(team3);
        allTheTeams.add(team4);
        allTheTeams.add(team5);
        allTheTeams.add(team6);
        allTheTeams.add(team7);
        allTheTeams.add(team8);
        allTheTeams.add(team9);
        allTheTeams.add(team10);

    }


    // Top 5 **************

    public CompetitionMember[] findTopFives(String discipline, String age){
        CompetitionMember[] topFive = new CompetitionMember[5];
        ArrayList<Team> teamsToSearch = new ArrayList<>();

        for (Team team : allTheTeams) {
            // Filter out exercise teams and empty teams
            if (!team.getTeamDiscipline().contains("exercise") && !team.getTeamMemberList().isEmpty()){
                teamsToSearch.add(team);
            }
        }
        for (Team team : teamsToSearch) {
            if (team.getTeamDiscipline().equalsIgnoreCase(discipline) && team.getIsTeamSenior().equalsIgnoreCase(age)){
               topFive =  team.getTopFive();
            }
        }
        return topFive;
    }

    public void addCoachToCoachList(Coach coach) {
        coachList.add(coach);
    }
    public ArrayList<Coach> getCoachList() {
        return coachList;
    }

    public ArrayList<Coach> searchCoach(String input) { //TODO Virker ikke endnu
        ArrayList<Coach> foundCoaches = new ArrayList<>();
        for (Coach coach : getCoachList()) {
            if (coach.getCoachFirstName().equalsIgnoreCase(input) ||
                    coach.getCoachLastName().equalsIgnoreCase(input)) {
                foundCoaches.add(coach);
            }
        }
        return foundCoaches;
    }


    public void initializeMembersForCoaches(){

        for (Team team : getAllTheTeams()){
            if(!team.getTeamMemberList().isEmpty()){
                team.initialiseCompetitionMemberToCoach();
            }
        }

    }
}

//------------------------------------------------------------------------------------------------------------------












