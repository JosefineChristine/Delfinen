package data_handler;

import domain_model.*;
import domain_model.Record;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

// REFAKTORERET

public class FileLoader {
    File memberList = new File("Delfin-members.csv");
    ArrayList<Member> members = new ArrayList<>();
    Scanner sc = null;

    public ArrayList<Member> getMembers() {
        try {
            sc = new Scanner(memberList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] data = line.split(",");
            String firstName = data[0];
            String lastName = data[1];
            String birth = data[2];
            LocalDate dateOfBirth = LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            double debt = Double.parseDouble(data[3]);
            boolean isActive = Boolean.parseBoolean(data[4]);
            String memberShipType = data[5];

            if (memberShipType.equalsIgnoreCase("competition")) {
                String[] memberRecords = Arrays.copyOfRange(data, 6, data.length);
                CompetitionMember member = new CompetitionMember(firstName, lastName, dateOfBirth, debt, isActive);
                member.setMemberRecords(competitorHandler(memberRecords));
                members.add(member);
            } else {
                ExerciseMember member = new ExerciseMember(firstName, lastName, dateOfBirth, debt, isActive);
                members.add(member);
            }
        }
        return members;
    }


    public ArrayList<Record> competitorHandler(String[] values) {

        ArrayList<Record> memberRecordList = new ArrayList<>();

        ArrayList<String> memberRecords = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            memberRecords.add(i, values[i]);
        }


        Iterator<String> iterator = memberRecords.iterator();

        while (iterator.hasNext()) {
            String title = iterator.next();
            iterator.remove();
            String discipline = iterator.next();
            iterator.remove();
            double result = Double.parseDouble(iterator.next());
            iterator.remove();
            LocalDate date = LocalDate.parse(iterator.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            iterator.remove();
            if (title.equalsIgnoreCase("training")) {
                TrainingRecord trainingRecord = new TrainingRecord(title, discipline, result, date);
                memberRecordList.add(trainingRecord);
            } else {
                String place = iterator.next();
                CompetitionRecord record = new CompetitionRecord(title, discipline, result, date, place);
                memberRecordList.add(record);
            }
        }

        return memberRecordList;

    }
}




