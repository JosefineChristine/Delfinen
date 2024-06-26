package domain_model;

import java.util.ArrayList;


public class Controller {

    private MemberCollection memberCollection;
    private TeamCollection teamCollection;

    public Controller() {
        memberCollection = new MemberCollection();
        teamCollection = new TeamCollection();
    }


    //***COACH MENU***--------------------------------------------------------------------------------------------------

    public CompetitionMember[] getTeamTopFive(String discipline, String age) {
        return teamCollection.findTopFives(discipline, age);

    }

    public void addTrainingRecordToMember(CompetitionMember competitionMember, TrainingRecord record) {
        memberCollection.addRecordToCompetitionMember(competitionMember, record);
    }

    public void addCompetitionRecordToMember(CompetitionMember competitionMember, CompetitionRecord record) {
        memberCollection.addRecordToCompetitionMember(competitionMember, record);
    }

    public ArrayList<Member> getMemberListForCoach(Coach coach) {
        return coach.getMemberListForCoach(coach);
    }

    public ArrayList<Coach> searchCoach(String input) {
        return teamCollection.searchCoach(input);
    }

    public ArrayList<Coach> getCoachList() {
        return teamCollection.getCoachList();
    }


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


    public ArrayList<Member> searchMemberDebt() {
        return memberCollection.searchMemberDebt();
    }

    public boolean deleteMember(String memberName) {
        return memberCollection.deleteMember(memberName);
    }

    public Member editMember(Member memberToEdit, int partToEdit, String newValue) {
        return memberCollection.editMember(memberToEdit, partToEdit, newValue);
    }

    public Member editDebt(Member memberToEdit, int partToEdit, String newValue) {
        return memberCollection.editDebt(memberToEdit, partToEdit, newValue);
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

    //------------------------------------------------------------------------------------------------------------------
}