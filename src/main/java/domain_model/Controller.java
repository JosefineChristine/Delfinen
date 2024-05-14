package domain_model;

import java.util.ArrayList;

public class Controller {

    //TODO: Giv klassen et mere passende navn //hvorfor? ;(

    //OBJEKTER
    private MemberCollection memberCollection;
    private Member member;
    private Coach coach;

    public Controller() {
    }

    public void addMember(Member member) {
        memberCollection.addMember(member);
    }

    public ArrayList<Member> searchMember(String input) {
        return memberCollection.searchMember(input);
    }

    public Member findSpecificMember(String specificMemberSearched) {
        return memberCollection.findSpecificMember(specificMemberSearched);
    }

    public boolean deleteMember(String memberName) {
        return memberCollection.deleteMember(memberName);
    }

    public Member editMember(Member memberToEdit, int partToEdit, String newValue) {
        return memberCollection.editMember(memberToEdit, partToEdit, newValue);
    }

    public ArrayList<Member> getMemberList() {
        return memberCollection.getMemberList();
    }


}