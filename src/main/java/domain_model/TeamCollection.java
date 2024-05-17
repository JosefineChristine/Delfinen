package domain_model;

import java.util.ArrayList;

public class TeamCollection {

    //************ATTRIBUTES************--------------------------------------------------------------------------------
    private ArrayList<Coach> coachList;

    //************CONSTRUCTOR************-------------------------------------------------------------------------------
    public TeamCollection(){
    this.coachList = new ArrayList<>();

    initializeCoaches();
    }

    //************METHODS************---------------------------------------------------------------------------------------

//    private void initializeCoaches() {
////        addCoachToCoachList(new Coach("Vahab", "Lotfyyekta"));
////        addCoachToCoachList(new Coach("Edith", "Terte"));
////        addCoachToCoachList(new Coach("Bjarne", "Larsen"));
////        addCoachToCoachList(new Coach("Sommer", "Dahl"));
////        addCoachToCoachList(new Coach("Arne", "Falk"));
//    }

    public ArrayList<Coach> searchCoach(String input) {
        ArrayList<Coach> foundCoaches = new ArrayList<>();
        for (Coach coach : coachList) {
            if (coach.getCoachFirstName().equalsIgnoreCase(input) ||
                    coach.getCoachLastName().equalsIgnoreCase(input)) {
                foundCoaches.add(coach);
            }
        }
        return foundCoaches;
    }

    public void addCoachToCoachList(Coach coach){
        coachList.add(coach);
    }

    public ArrayList<Coach> getCoachList() {
        return coachList;
    }
//
//    public void initializeCompetitionMemberToCoach(){
//
//    }

    //************COACHES************-----------------------------------------------------------------------------------
    Coach coach1 = new Coach("Vahab", "Lotfyyekta");
    Coach coach2 = new Coach("Edith", "Terte");
    Coach coach3 = new Coach("Bjarne", "Larsen");
    Coach coach4 = new Coach("Sommer", "Dahl");
    Coach coach5 = new Coach("Arne", "Falk");


    private void initializeCoaches() {
        Coach coach1 = new Coach("Vahab", "Lotfyyekta");
        Coach coach2 = new Coach("Edith", "Terte");
        Coach coach3 = new Coach("Bjarne", "Larsen");
        Coach coach4 = new Coach("Sommer", "Dahl");
        Coach coach5 = new Coach("Arne", "Falk");

        addCoachToCoachList(coach1);
        addCoachToCoachList(coach2);
        addCoachToCoachList(coach3);
        addCoachToCoachList(coach4);
        addCoachToCoachList(coach5);
    }

    //************TEAMS************-------------------------------------------------------------------------------------
    Team team1 = new Team("crawl", coach1, true);
    Team team2 = new Team("butterfly", coach2, true);
    Team team3 = new Team("backstroke", coach3, true);
    Team team4 = new Team("breaststroke", coach4, true);
    Team team5 = new Team("crawl", coach1, false);
    Team team6 = new Team("butterfly", coach2, false);
    Team team7 = new Team("backstroke", coach3, false);
    Team team8 = new Team("breaststroke",coach4, false);
    Team team9 = new Team("exercise senior", coach5, true);
    Team team10 = new Team("exercise junior", coach5, false );

    //------------------------------------------------------------------------------------------------------------------
}
