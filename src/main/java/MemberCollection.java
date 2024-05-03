import java.util.ArrayList;
public class MemberCollection {
    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    private ArrayList<Member> memberList = new ArrayList<>();

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMember(Member member) {
        memberList.add(member);
        //fileHandler.saveMemberToFile(memberList);
    }

/*
    public ArrayList<Member> searchMember(String embers) {
        var foundMovies = new ArrayList<Movie>(); //var kalder variablen, som er defineret efter new
        for (Movie items : movieList) {
            if (items.getTitle().toLowerCase().contains(movieName.toLowerCase())) {
                foundMovies.add(items);
            }
        }
        return foundMovies;
    }
*/

}