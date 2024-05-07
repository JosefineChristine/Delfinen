package domain_model;

import java.util.ArrayList;

public class Team {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String teamName;
    private String teamInfo;
    private ArrayList<Member> teamMemberList;
    Coach coach;
    Member member;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Team(String teamName, String teamInfo, Coach coach){
        this.teamName = teamName;
        this.teamInfo = teamInfo;
        this.coach = coach;
        this.teamMemberList = new ArrayList<>();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getTeamName(){
        return teamName;
    }

    public String getTeamInfo() {
        return teamInfo;
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

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
    public void addMemberToTeam(Member member){
        this.teamMemberList.add(member);
    }

    public void removeMemberofTeam(Member member){
        this.teamMemberList.remove(member);
    }

    //***TO STRING METHOD***-----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Team:\n" +
                "Team name: " + teamName   + '\n' +
                "Team Info: " + teamInfo   + '\n' +
                "Coach: "     + getCoach() + '\n' +
                "Team members: \n"         +
                getTeamListAsString();
    }



    //------------------------------------------------------------------------------------------------------------------
}
