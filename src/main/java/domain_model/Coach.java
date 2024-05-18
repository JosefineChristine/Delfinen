package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Coach {

    //***QUESTIONS& MISSING CODE***-------------------------------------------------------------------------------------
    //TODO Arrayliste til medlemmer? metode hvorpå man kan se listen af medlemmer for hver træner

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String coachFirstName;
    private String coachLastName;

    private ArrayList<Member> memberListForCoach;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Coach(String coachFirstName, String coachLastName) {
        this.coachFirstName = coachFirstName;
        this.coachLastName = coachLastName;
        this.memberListForCoach = new ArrayList<>();

    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public String getCoachFirstName() {
        return coachFirstName;
    }

    public String getCoachLastName() {
        return coachLastName;
    }

    public void setMemberListForCoach(ArrayList<Member> memberListForCoach) {
        this.memberListForCoach = memberListForCoach;
    }

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
    public void addMemberToCoach(Member member) {
        memberListForCoach.add(member);
    }

    public void removeMemberToCoach(Member member) {
        memberListForCoach.remove(member);
    }

    Member member = new CompetitionMember("Josefine", "Røes", LocalDate.of(1994, 11, 11), 0, true);


    //***METHODS***-----------------------------------------------------------------------------------------------------
    public ArrayList<Member> getMemberListForCoach() {
        return memberListForCoach;
    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\n" + getCoachFirstName() + " " + getCoachLastName();
    }

    //------------------------------------------------------------------------------------------------------------------
}
