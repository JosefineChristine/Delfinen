package domain_model;

import java.util.ArrayList;

public class TeamCollection {
    //private ArrayList<Coach> coachList = new ArrayList<>();
//    ArrayList<Coach> allCoaches = new ArrayList<>();

    //************CONSTRUCTOR********-----------------------------------------------------------------------------------
//    public TeamCollection(){
//        addCoachToCoachList();
//    }

    MemberCollection memberCollection;

    //************COACHES********---------------------------------------------------------------------------------------

    Coach coach1 = new Coach("Vahab", "Lotfyyekta");
    Coach coach2 = new Coach("Edith", "Terte");
    Coach coach3 = new Coach("Bjarne", "Larsen");
    Coach coach4 = new Coach("Sommer", "Dahl");
    Coach coach5 = new Coach("Arne", "Falk");



    //************TEAMS********---------------------------------------------------------------------------------------
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

    //************METHODS********-----------------------------------------------------------------------------------------

//    public void addCoachToCoachList(){
//        allCoaches.add(coach1);
//        allCoaches.add(coach2);
//        allCoaches.add(coach3);
//        allCoaches.add(coach4);
//        allCoaches.add(coach5);
//    }
//
//    public ArrayList<Coach> getAllCoaches() {
//        return allCoaches;
//    }

    //------------------------------------------------------------------------------------------------------------------
}
