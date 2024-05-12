package domain_model;

import java.util.ArrayList;

public class Team {

    //**TO DO***--------------------------------------------------------------------------------------------------------
    //TODO check age in addMember()method... --> calculateAge if over 18 --> isSenior == true

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
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getTeamDiscipline(){
        return teamDiscipline;
    }

//    public String getIsSenior(){
//        return (true) ? "Senior" : "Junior";
//    }

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
    //TODO: Fix addMemberToTeam metoden
    public void addMemberToTeam(Member member){
        if (member instanceof CompetitionMember &&
                ((CompetitionMember) member).getActiveDisciplines().contains(getTeamDiscipline())){
            teamMemberList.add(member);
        } else if (member instanceof ExerciseMember){
            teamMemberList.add(member);
        }

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
               // "Team type "  + getIsSenior() + '\n' +
                "Team members: \n"         +
                getTeamListAsString();
    }



    //------------------------------------------------------------------------------------------------------------------
}
