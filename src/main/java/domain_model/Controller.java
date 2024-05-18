package domain_model;

import java.util.ArrayList;

public class Controller {

    //OBJEKTER
    private MemberCollection memberCollection;
    private Member member;
    private CompetitionMember competitionMember;
    private Coach coach;
    private Record record;
    private TrainingRecord trainingRecord;
    private TeamCollection teamCollection;

    public Controller() {
        memberCollection = new MemberCollection();
        teamCollection = new TeamCollection();
    }


    //***KASSERERMENU***------------------------------------------------------------------------------------------------

    //***COACH MENU***--------------------------------------------------------------------------------------------------


    //***ADMIN MENU***--------------------------------------------------------------------------------------------------
    public void addCompetitionMember(CompetitionMember competitionMember) {
        memberCollection.addCompetitionMember(competitionMember);
    }

    public void addExerciseMember(ExerciseMember exerciseMember) {
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

    public double calculateAnnualIncome() {
        return memberCollection.calculateAnnualIncome();
    }

    public double calculateTotalDebt() {
        return memberCollection.calculateTotalDebt();
    }

    public int activeMembersCount() {
        return memberCollection.activeMembersCount();
    }

    public int inActiveMembersCount() {
        return memberCollection.inactiveMembersCount();
    }

    //***COACH MENU***--------------------------------------------------------------------------------------------------
    public void addTrainingRecordToMember(TrainingRecord record) {
        competitionMember.addTrainingRecordToMember(record);
    }

    public void addCompetitionRecordToMember(CompetitionRecord record) {
        competitionMember.addCompetitionRecordToMember(record);
    }

    public ArrayList<Member> getCompetitionMemberListForCoach() {
        return coach.getMemberListForCoach();
    }

    public ArrayList<Coach> searchCoach(String input) {
        return teamCollection.searchCoach(input);
    }

    public ArrayList<Coach> getCoachList() { //TODO skal virke
        return teamCollection.getCoachList();
    }


    //------------------------------------------------------------------------------------------------------------------
}