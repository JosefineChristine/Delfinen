package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;

public class CompetitionMember extends Member {


    private ArrayList<Record> memberRecords = new ArrayList<>();


    public CompetitionMember(String firstName, String lastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        super(firstName, lastName, dateOfBirth, debt, isActive);
        super.setMemberShipType("Competition");

    }

    public ArrayList<Record> getMemberRecords() {
        return memberRecords;
    }

    public void setMemberRecords(ArrayList<Record> memberRecords) {
        this.memberRecords = memberRecords;
    }
}