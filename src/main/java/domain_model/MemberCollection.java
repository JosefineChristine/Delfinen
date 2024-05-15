package domain_model;

import data_handler.FileLoader;
import data_handler.SaveToFile;

import java.time.LocalDate;
import java.util.ArrayList;
public class MemberCollection {

    //***TO DO***-------------------------------------------------------------------------------------------------------
    //TODO tjek om calculateTotalDebt er lavet korrekt

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    private ArrayList<Member> memberList;
    private SaveToFile fileHandler = new SaveToFile();
    private FileLoader loadToFole = new FileLoader();

    //CONSTRUCTOR
    public MemberCollection(){
        this.memberList = loadToFole.getMembers();

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


    public ArrayList<Member> searchMember(String membersSearched) {
        ArrayList<Member> foundMembers = new ArrayList<>(); //var kalder variablen, som er defineret efter new
        for (Member items : memberList) {
            if (items.getMemberFirstName().toLowerCase().contains(membersSearched.toLowerCase()) ||
                    items.getMemberLastName().toLowerCase().contains(membersSearched.toLowerCase())) {
                foundMembers.add(items);
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
                memberToEdit.setActive(Boolean.parseBoolean(newValue));
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
            if (memberToEdit.getMemberFirstName().equalsIgnoreCase(specificMemberSearched)) {
                targetMember = memberToEdit;
                return targetMember;
            }
        }
        return targetMember;
    }

    public boolean deleteMember(String memberToDelete){
        Member targetMember = findSpecificMember(memberToDelete);
        if (targetMember != null){
            memberList.remove(targetMember);
            fileHandler.saveToFile(memberList);
            return true;
        } else {
            return false;
        }
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



    //*** Getter/Setter***-------------------------------------------------------------------------------------------------------

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }


}