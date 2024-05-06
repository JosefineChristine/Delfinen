import data_handler.FileLoader;
import domain_model.CompetitionMember;
import domain_model.Member;
import domain_model.Record;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // these lines are just for test and must be removed from the main class
        FileLoader fileLoader = new FileLoader();
        System.out.println("Test ");
        ArrayList<Member> members = new ArrayList<>();
        members = fileLoader.getMembers();
        for (Member member : members) {
            System.out.println(member.getFirstName());
            System.out.println(member.getDateOfBirth());
            System.out.println(member.calculateMembershipFee());
            System.out.println(member.getDebt());
            System.out.println(member.getMemberShipType());
            if (member.getMemberShipType().equalsIgnoreCase("competition")){
                CompetitionMember member1 = (CompetitionMember) member;
                ArrayList<Record> memberRecords = member1.getMemberRecords();
                for (Record memberRecord : memberRecords) {
                    System.out.println(memberRecord.getTitle());
                    System.out.println(memberRecord.getDiscipline());
                    System.out.println(memberRecord.getResult());
                    System.out.println();
                }
            }
            System.out.println();

        }


    }
}
