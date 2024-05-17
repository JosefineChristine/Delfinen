package domain_model;

import java.util.ArrayList;


public class Coach {

    //***QUESTIONS& MISSING CODE***-------------------------------------------------------------------------------------
    //TODO Arrayliste til medlemmer? metode hvorpå man kan se listen af medlemmer for hver træner

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String coachFirstName;
    private String coachLastName;

    private ArrayList<Member> memberListForCoach;
    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Coach(String coachFirstName, String coachLastName){
        this.coachFirstName = coachFirstName;
        this.coachLastName = coachLastName;
        this.memberListForCoach = new ArrayList<>();

    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public String getCoachFirstName(){
        return coachFirstName;
    }

    public String getCoachLastName(){
        return coachLastName;
    }

    public void setMemberListForCoach(ArrayList<Member> memberListForCoach) {
        this.memberListForCoach = memberListForCoach;
    }

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
    public void addMemberToCoach(Member member){
        memberListForCoach.add(member);
    }

    public void removeMemberToCoach(Member member){
        memberListForCoach.remove(member);
    }



    //***METHODS***-----------------------------------------------------------------------------------------------------
    public ArrayList<Member> getMemberListForCoach() {
        return memberListForCoach;
    }

//    public ArrayList<Coach> printCoachList() { /TODO måske slet
//        ArrayList<Coach> foundCoaches = new ArrayList<>();
//        for (Coach coach : coachList) {
//            if (coach.getDebt() > 0) {
//                foundMembersDebt.add(member);
//            }
//        }
//        return ;
//    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "\n" + getCoachFirstName() + " " + getCoachLastName();
    }

    //------------------------------------------------------------------------------------------------------------------
}
