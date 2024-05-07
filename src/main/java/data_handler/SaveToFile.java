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
                String csvLine = "";
                if (member.getMemberShipType().equalsIgnoreCase("EXERCISER")) {
                    csvLine = String.format("%s,%s,%s,%.2f,%b,%s",
                            member.getFirstName(),
                            member.getLastName(),
                            member.getDateOfBirth(),
                            member.getDebt(),
                            member.isActive(),
                            member.getMemberShipType());

                } else  {
                    csvLine = String.format("%s,%s,%s,%.2f,%b,%s",
                            member.getFirstName(),
                            member.getLastName(),
                            member.getDateOfBirth(),
                            member.getDebt(),
                            member.isActive(),
                            member.getMemberShipType());
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
            if (memberRecord instanceof TrainingRecord) {
                recordLine = String.format("%s,%s,%.2f,%s",
                        memberRecord.getTitle(),
                        memberRecord.getDiscipline(),
                        memberRecord.getResult(),
                        memberRecord.getDate());

            } else if (memberRecord instanceof CompetitionRecord) {
                recordLine = String.format("%s,%s,%.2f,%s,%s",
                        memberRecord.getTitle(),
                        memberRecord.getDiscipline(),
                        memberRecord.getResult(),
                        memberRecord.getDate(),
                        ((CompetitionRecord) memberRecord).getPlaceAchieved());
            }
            recordValues.add(recordLine);
        }
        return recordValues.toArray(new String[0]);
    }

}



