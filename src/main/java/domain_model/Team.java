package domain_model;

import comparator.NameComparator;
import comparator.RecordComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Team {

    //**TO DO***--------------------------------------------------------------------------------------------------------


    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String teamDiscipline;
    private ArrayList<Member> teamMemberList;
    private boolean isTeamSenior;
    Coach coach;


    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Team(String teamDiscipline, Coach coach, boolean isTeamSenior){
        this.teamDiscipline = teamDiscipline; // ex. " Crawl"
        this.coach = coach;
        this.isTeamSenior = isTeamSenior;
        this.teamMemberList = new ArrayList<>();
        initialiseCompetitionMemberToCoach();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getTeamDiscipline(){
        return teamDiscipline;
    }

    public String getIsTeamSenior(){
        return (true) ? "Senior" : "Junior";
    }

    public String getCoach() {
        return coach.getCoachFirstName() + ' ' + coach.getCoachLastName();
    }

    public ArrayList<Member> getTeamMemberList(){
        return teamMemberList;
    }

    
    private String getTeamListAsString() {
        String teamMembers = "";
        for (Member member : teamMemberList) {
            teamMembers += member.getMemberFirstName() + ' ' + member.getMemberLastName() + '\n';
        }
        return teamMembers;
    }

    //***METHODS***----------------------------------------------------------------------------------------
    public void initialiseCompetitionMemberToCoach(){
        coach.setMemberListForCoach(getTeamMemberList());
    }


    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------

//    public Member addMemberToTeam(Member member){
//        if (member instanceof CompetitionMember &&
//                ((CompetitionMember) member).getActiveDisciplines().contains(getTeamDiscipline())){
//            if (member.getMemberShipType().equalsIgnoreCase(getIsTeamSenior())){
//                teamMemberList.add(member);
//                return member;
//            }
//        } else if (member instanceof ExerciseMember ){
//
//            if (member.getMemberShipType().equalsIgnoreCase(getIsTeamSenior())){
//                teamMemberList.add(member);
//                return member;
//            }
//
//        }
//        return null;
//    }

//    public CompetitionMember[] getTopFive(){
//        CompetitionMember[] topFive = new CompetitionMember[5];
//
//        return null;
//
//    }

    public void removeMemberofTeam(Member member){
        this.teamMemberList.remove(member);
    }

    //***TO STRING METHOD***-----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Team:\n" +
                "Team name: " + teamDiscipline + '\n' +
                "Team coach: " + getCoach() + '\n' +

                "Team type "  + getIsTeamSenior() + '\n' +
                "Team members: \n"         +
                getTeamListAsString();
    }


    //------------------------------------------------------------------------------------------------------------------
}
