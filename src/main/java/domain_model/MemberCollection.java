package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;
public class MemberCollection {

    //***TO DO***-------------------------------------------------------------------------------------------------------
    //TODO tjek om calculateTotalDebt er lavet korrekt

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    private ArrayList<Member> memberList;

    //CONSTRUCTOR
    public MemberCollection(){
        this.memberList = new ArrayList<>();
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMember(Member member) {
        memberList.add(member);
        //fileHandler.saveMemberToFile(memberList);
    }


    public ArrayList<Member> searchMember(String membersSearched) {
        var foundMembers = new ArrayList<Member>(); //var kalder variablen, som er defineret efter new
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
            //fileHandler.saveMovieToFile(movieList);
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

    public double calculateTotalDebt(){ //tjek om det er korrekt
        double totalDebt = 0;
        for(Member debt : memberList){
            totalDebt += debt.getDebt();
        }
        return totalDebt;
    }

    public ArrayList<Member> searchMemberDebt(String membersSearchedDebt) {
        var foundMembersDebt = new ArrayList<Member>(); //var kalder variablen, som er defineret efter new
        for (Member items : memberList) {
            if (items.getDebt() > 0) {
                foundMembersDebt.add(items);
            }
        }
        return foundMembersDebt;
    }


}