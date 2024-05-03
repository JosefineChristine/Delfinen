package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;

public class CompetitionMember extends Member {

    CompetitionRecord competitionRecord;
    TrainingRecord trainingRecord;

    private ArrayList<TrainingRecord> trainingRecords = new ArrayList<>();
    private ArrayList<CompetitionRecord> competitionRecords = new ArrayList<>();

    public CompetitionMember(String firstName, String lastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        super(firstName, lastName, dateOfBirth, debt, isActive);

    }

}