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


}