import java.util.ArrayList;
public class MemberCollection {
    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    private ArrayList<Member> memberList = new ArrayList<>();

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMember(Member member) {
        memberList.add(member);
        //fileHandler.saveMemberToFile(memberList);
    }


    public ArrayList<Member> searchMember(String membersSearched) {
        var foundMembers = new ArrayList<Member>(); //var kalder variablen, som er defineret efter new
        for (Member items : memberList) {
            if (items.)
            //if (items.getTitle().toLowerCase().contains(movieName.toLowerCase())) {
                foundMembers.add(items);
            }
        }
        return foundMovies;
    }


}