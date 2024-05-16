package domain_model;

import comparator.BestRecordComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Team {

    //**TO DO***--------------------------------------------------------------------------------------------------------


    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String teamDiscipline;
    private ArrayList<Member> teamMemberList = new ArrayList<>();
    private boolean isTeamSenior;
    Coach coach;


    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Team(String teamDiscipline, Coach coach, boolean isTeamSenior){
        this.teamDiscipline = teamDiscipline.toLowerCase(); // ex. " Crawl"
        this.coach = coach;
        this.isTeamSenior = isTeamSenior;
       // this.teamMemberList = new ArrayList<>();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getTeamDiscipline(){
        return teamDiscipline;
    }

//    public String getIsTeamSenior(){
//        return (true) ? "Senior" : "Junior";
//    }

    public String getCoach() {
        return coach.getCoachFirstName() + ' ' + coach.getCoachLastName();
    }

    public ArrayList<Member> getTeamMemberList(){
        return teamMemberList;
    }

    
    public String getTeamListAsString() {
        String teamMembers = "";
        for (Member member : teamMemberList) {
            teamMembers += member.getMemberFirstName() + ' ' + member.getMemberLastName() + '\n';
        }
        return teamMembers;
    }


    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------

    public void addMemberToTeam(Member member){
        teamMemberList.add(member);

    }

    public CompetitionMember[] getTopFive(){
        CompetitionMember[] topFive = new CompetitionMember[5];
        ArrayList<CompetitionMember> membersToSort = new ArrayList<>();
        for (Member member : teamMemberList) {

                membersToSort.add((CompetitionMember) member);
        }
        Collections.sort(membersToSort, new BestRecordComparator());
        topFive[0] = membersToSort.get(0);
        topFive[1] = membersToSort.get(1);
        topFive[2] = membersToSort.get(2);
        topFive[3] = membersToSort.get(3);
        topFive[4] = membersToSort.get(4);
        return topFive;
    }

    public void removeMemberofTeam(Member member){
        this.teamMemberList.remove(member);
    }

    //***TO STRING METHOD***-----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Team:\n" +
                "Team name: " + teamDiscipline + '\n' +
                "Team coach: " + getCoach() + '\n' +

//                "Team type "  + getIsTeamSenior() + '\n' +
                "Team members: \n"         +
                getTeamListAsString();
    }


    //------------------------------------------------------------------------------------------------------------------
}
