package domain_model;

import java.util.ArrayList;

public class Controller {

    //TODO: Giv klassen et mere passende navn //hvorfor? ;(

    //OBJEKTER
    private MemberCollection memberCollection;
    private Member member;
    private Coach coach;
    private Record record;

    public Controller() {
        memberCollection = new MemberCollection();
    }


    //***KASSERERMENU***------------------------------------------------------------------------------------------------

    //***COACH MENU***--------------------------------------------------------------------------------------------------
    public void addRecord(Record record){
        record.addRecord(record);
    }

    //***ADMIN MENU***--------------------------------------------------------------------------------------------------
    public void addCompetitionMember(CompetitionMember competitionMember){
        memberCollection.addCompetitionMember(competitionMember);
    }

    public void addExerciseMember(ExerciseMember exerciseMember){
        memberCollection.addExerciseMember(exerciseMember);
    }

    public ArrayList<Member> searchMember(String input) {
        return memberCollection.searchMember(input);
    }

    public Member findSpecificMember(String specificMemberSearched) {
        return memberCollection.findSpecificMember(specificMemberSearched);
    }
    public ArrayList<Member> searchMemberDebt() {
        return memberCollection.searchMemberDebt();
    }

    public boolean deleteMember(String memberName) {
        return memberCollection.deleteMember(memberName);
    }

    public Member editMember(Member memberToEdit, int partToEdit, String newValue) {
        return memberCollection.editMember(memberToEdit, partToEdit, newValue);
    }

    public ArrayList<Member> getMemberCollection() {
        return memberCollection.getMemberList();
    }

    public double calculateAnnualIncome(){
        return memberCollection.calculateAnnualIncome();
    }

    public double calculateTotalDebt(){
        return memberCollection.calculateTotalDebt();
    }

    public int activeMembersCount() {
        return memberCollection.activeMembersCount();
    }

    public int inActiveMembersCount() {
        return memberCollection.inactiveMembersCount();
    }


}