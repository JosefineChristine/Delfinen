import data_handler.FileLoader;
import data_handler.SaveToFile;
import domain_model.*;
import domain_model.Record;
import ui.UserInterface;

import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //Setting the default locale to Locale.US, to ensure that the decimal separator will always be a dot,
        // regardless of the system's default locale.
        Locale.setDefault(Locale.US);

//        // these lines are just for test and must be removed from the main class
//        FileLoader fileLoader = new FileLoader();
//        SaveToFile saveToFile = new SaveToFile();

        UserInterface ui = new UserInterface();
        ui.startProgram();

//        TeamCollection teamCollection = new TeamCollection();
//        MemberCollection memberCollection = new MemberCollection();
//        for (Member member : memberCollection.getMemberList()){
//            if(member instanceof CompetitionMember){
//                System.out.println(((CompetitionMember) member).getMemberRecords());
//            }
//        }
      //  teamCollection.printTopFives();


//        for (Member member : memberCollection.getMemberList()) {
//            System.out.println(member.getMemberFirstName());
//            System.out.println(member.getDateOfBirth());
//            System.out.println(member.calculateMembershipFee());
//            System.out.println(member.getDebt());
//            System.out.println(member.getMemberShipType());
//            if (member.getMemberShipType().equalsIgnoreCase("competition")){
//                CompetitionMember member1 = (CompetitionMember) member;
//                ArrayList<Record> memberRecords = member1.getMemberRecords();
//                for (Record memberRecord : memberRecords) {
//                    System.out.println(memberRecord.getEventName());
//                    System.out.println(memberRecord.getDiscipline());
//                    System.out.println(memberRecord.getResult());
//                    System.out.println();
//                }
//            }
//            System.out.println();
//
//        }
//
   }
}

        /* TEST TEST TEST TEST TEST
        //TODO Ryd op i main
//        String birthDate = "1991-09-11";
//        LocalDate memberBirthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//
        ArrayList<Member> members;
//
        members = fileLoader.getMembers();


        for (Member member : members) {
            System.out.println(member.getMemberFirstName());
            System.out.println(member.getDateOfBirth());
            System.out.println(member.calculateMembershipFee());
            System.out.println(member.getDebt());
            System.out.println(member.getMemberShipType());
            if (member.getMemberShipType().equalsIgnoreCase("competition")){
                CompetitionMember member1 = (CompetitionMember) member;
                ArrayList<Record> memberRecords = member1.getMemberRecords();
                for (Record memberRecord : memberRecords) {
                    System.out.println(memberRecord.getEventName());
                    System.out.println(memberRecord.getDiscipline());
                    System.out.println(memberRecord.getResult());
                    System.out.println();
                }
            }
            System.out.println();

        }

       saveToFile.saveToFile(members);


//        for (Member member : members) {
//            if (member instanceof CompetitionMember){
//                ((CompetitionMember) member).findBestCompetetionRecord();
//                System.out.println("Best competition record: ");
//                System.out.println(member.getMemberFirstName() + " " + member.getMemberLastName());
//                System.out.println(((CompetitionMember) member).findBestCompetetionRecord());
//            }
//        }

//        for (Member member : members) {
//            if (member instanceof CompetitionMember){
//                ((CompetitionMember) member).findBestTrainingRecord();
//                System.out.println("Best training record: ");
//                System.out.println(member.getMemberFirstName() + " " + member.getMemberLastName());
//                System.out.println(((CompetitionMember) member).findBestTrainingRecord());
//            }
//        }

    }

         */