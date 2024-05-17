package domain_model;

import data_handler.FileLoader;
import data_handler.SaveToFile;

import java.time.LocalDate;
import java.util.ArrayList;
public class MemberCollection {

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    private ArrayList<Member> memberList;
    private SaveToFile fileHandler = new SaveToFile();
    private FileLoader fileLoader = new FileLoader();
    private ArrayList<Coach> coachList;

    //CONSTRUCTOR
    public MemberCollection(){
        this.memberList = fileLoader.getMembers();
        this.coachList = new ArrayList<>();

    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addCompetitionMember(CompetitionMember competitionMember) {
        memberList.add(competitionMember);
        fileHandler.saveToFile(memberList);
    }

    public void addExerciseMember(ExerciseMember exerciseMember) {
        memberList.add(exerciseMember);
        fileHandler.saveToFile(memberList);
    }

    public ArrayList<Member> searchMember(String input) {
        ArrayList<Member> foundMembers = new ArrayList<>();
        for (Member member : memberList) {
            if (member.getMemberFirstName().equalsIgnoreCase(input) ||
                    member.getMemberLastName().equalsIgnoreCase(input)) {
                foundMembers.add(member);
            }
        }
        return foundMembers;
    }

    public Member editMember(Member memberToEdit, int partToEdit, String newValue) {

        switch (partToEdit) {
            case 1: //first name
                memberToEdit.setFirstName(newValue);
                break;

            case 2: //last name
                memberToEdit.setLastName(newValue);
                break;

            case 3: //date of birth
                memberToEdit.setDateOfBirth(LocalDate.parse(newValue));
                break;

            case 4: //debt
                memberToEdit.setDebt(Double.parseDouble(newValue));
                break;

            case 5: //isActive
                boolean activity = newValue.equalsIgnoreCase("aktiv");
                memberToEdit.setActive(activity);
                break;

            case 0: //exit
                break;
        }
        fileHandler.saveToFile(memberList);
        return memberToEdit;
    }
    public Member findSpecificMember(String specificMemberSearched) {
        Member targetMember = null;
        for (Member memberToEdit : memberList) {
            if (memberToEdit.getMemberFirstName().equalsIgnoreCase(specificMemberSearched) ||
                    memberToEdit.getMemberLastName().equalsIgnoreCase(specificMemberSearched)) {
                targetMember = memberToEdit;
                return targetMember;
            }
        }
        return targetMember;
    }

    public boolean deleteMember(String memberName) {
        for (Member member : memberList) {
            if (member.getMemberFirstName().equalsIgnoreCase(memberName) ||
                    member.getMemberLastName().equalsIgnoreCase(memberName)) {
                memberList.remove(member);
                fileHandler.saveToFile(memberList);
                return true;
            }
        }
        return false;
    }

    public double calculateAnnualIncome(){
        double annualIncome = 0;
        for(Member members : memberList){
            annualIncome += members.calculateMembershipFee();
        }
        return annualIncome;
    }

    public double calculateTotalDebt() {
        double totalDebt = 0;
        for (Member member : memberList) {
            totalDebt += member.getDebt();
        }
        return totalDebt;
    }

    public ArrayList<Member> searchMemberDebt() {
        ArrayList<Member> foundMembersDebt = new ArrayList<>();
        for (Member member : memberList) {
            if (member.getDebt() > 0) {
                foundMembersDebt.add(member);
            }
        }
        return foundMembersDebt;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public int activeMembersCount() {
        int activeMembers = 0;
        for (Member member : memberList) {
            if (member.isActive()) {
                activeMembers++;
            }
        }
        return activeMembers;
    }

    public int inactiveMembersCount() {
        int inActiveMembers = 0;
        for (Member member : memberList) {
            if (!member.isActive()) {
                inActiveMembers++;
            }
        }
        return inActiveMembers;
    }

    //***COACH METHODS***-----------------------------------------------------------------------------------------------



}