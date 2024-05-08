package data_handler;

import domain_model.*;
import domain_model.Record;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;


public class SaveToFile {
    public void saveToFile(ArrayList<Member> memberList) {
        try (PrintStream saveFile = new PrintStream("Delfin-members.csv")) {
            for (Member member : memberList) {
                String csvLine;
                    csvLine = String.format("%s,%s,%s,%.2f,%b,%s",
                            member.getMemberFirstName(),
                            member.getMemberLastName(),
                            member.getDateOfBirth(),
                            member.getDebt(),
                            member.isActive(),
                            member.getMemberShipType());
                if (!member.getMemberShipType().equalsIgnoreCase("EXERCISER"))  {
                    String[] memberRecords = competitionMemberHandler((CompetitionMember) member);
                    for (String record : memberRecords) {
                        csvLine = csvLine + "," + record;
                    }
                }
                saveFile.println(csvLine);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] competitionMemberHandler(CompetitionMember member) {
        ArrayList<String> recordValues = new ArrayList<>();
        ArrayList<Record> memberRecords = member.getMemberRecords();
        for (Record memberRecord : memberRecords) {
            String recordLine = "";
                recordLine = String.format("%s,%s,%.2f,%s",
                        memberRecord.getEventName(),
                        memberRecord.getDiscipline(),
                        memberRecord.getResult(),
                        memberRecord.getDate());

          if (memberRecord instanceof CompetitionRecord) {
               String rank= String.format("%s",
                        ((CompetitionRecord) memberRecord).getPlaceAchieved());
              recordLine = recordLine + "," + rank;
          }
            recordValues.add(recordLine);
        }
        return recordValues.toArray(new String[0]);
    }

}






