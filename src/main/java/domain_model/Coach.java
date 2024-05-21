package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;
// DELVIST REFAKTORERET (SE TODOS)

public class Coach {



    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String coachFirstName;
    private String coachLastName;

    private ArrayList<Member> memberListForCoach;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Coach(String coachFirstName, String coachLastName) {
        this.coachFirstName = coachFirstName;
        this.coachLastName = coachLastName;
        memberListForCoach = new ArrayList<>();

    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public String getCoachFirstName() {
        return coachFirstName;
    }

    public String getCoachLastName() {
        return coachLastName;
    }

    public void setMemberListForCoach(ArrayList<Member> memberListForCoach) {
        this.memberListForCoach = memberListForCoach; //TODO: Hvad skal denne metode ift. add/remove metoderne?
    }

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
//    public void addMemberToCoach(Member member) {
//        memberListForCoach.add(member);
//    }
//
//    public void removeMemberToCoach(Member member) {
//        memberListForCoach.remove(member);
//    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public ArrayList<Member> getMemberListForCoach(Coach coach) {
        for (Member member : memberListForCoach)
            member.toString();
        return memberListForCoach;
    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\n" + coachFirstName + " " + coachLastName;
    }

    //------------------------------------------------------------------------------------------------------------------
}
