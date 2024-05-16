package domain_model;

import java.util.ArrayList;


public class Coach {

    //***QUESTIONS& MISSING CODE***-------------------------------------------------------------------------------------
    //TODO Coach is trainer for?
    //TODO Arrayliste til medlemmer? metode hvorpå man kan se listen af medlemmer for hver træner

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String coachFirstName;
    private String coachLastName;

    private ArrayList<CompetitionMember> competitionMemberListForCoach;
    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Coach(String coachFirstName, String coachLastName){
        this.coachFirstName = coachFirstName;
        this.coachLastName = coachLastName;
        this.competitionMemberListForCoach = new ArrayList<>();
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public String getCoachFirstName(){
        return coachFirstName;
    }

    public String getCoachLastName(){
        return coachLastName;
    }

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
    public void addCompetitionMemberToCoach(CompetitionMember competitionMember){
        competitionMemberListForCoach.add(competitionMember);
    }

    public void removeCompetitionMemberToCoach(CompetitionMember competitionMember){
        competitionMemberListForCoach.remove(competitionMember);
    }



    //***METHODS***-----------------------------------------------------------------------------------------------------
    public ArrayList<String> getCompetitionMemberListForCoach() {
        ArrayList<String> memberListForCoach = new ArrayList<>();
        for (CompetitionMember member : competitionMemberListForCoach) {
            memberListForCoach.add(member.getMemberFirstName() + " " + member.getMemberLastName());
        }
        return memberListForCoach;
    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "Coach name: " + getCoachFirstName() + " " + getCoachLastName();
    }

    //------------------------------------------------------------------------------------------------------------------
}
