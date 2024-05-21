package domain_model;

import comparator.RecordComparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

// DELVIST REFAKTORERET (SE TODOS)

public class CompetitionMember extends Member {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<Record> memberRecords = new ArrayList<>();
    private ArrayList<TrainingRecord> trainingRecords;
    private ArrayList<CompetitionRecord> competitionRecords;
    private ArrayList<Team> teams;
    private ArrayList<String> activeDisciplines;
    private double bestTrainingRecord;

    //***CONSTRUCTOR****------------------------------------------------------------------------------------------------
    public CompetitionMember(String memberFirstName, String memberLastName,
                             LocalDate dateOfBirth, double debt, boolean isActive) {
        super(memberFirstName, memberLastName,
                dateOfBirth, debt, isActive);
        super.setMemberShipType("Competition");

        setActiveDisciplines();

        recordInitializer();

        activeDisciplines = new ArrayList<>();
        teams = new ArrayList<>();
        trainingRecords = new ArrayList<>();
        competitionRecords = new ArrayList<>();


    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public ArrayList<Record> getMemberRecords() {
        return memberRecords;
    }


    public ArrayList<String> getActiveDisciplines() {
        return activeDisciplines;
    }

    public double getBestTrainingRecord() {
        return bestTrainingRecord;
    }

    public ArrayList<TrainingRecord> getTrainingRecords() {
        return trainingRecords;
    }

    public ArrayList<CompetitionRecord> getCompetitionRecords() {
        return competitionRecords;
    }

    public String getTeamsForSpecificMember() {
        ArrayList<String> memberTeams = new ArrayList<>();
        for (Team team : teams) {
            if (team.getTeamMemberList().contains(this)) {
                memberTeams.add(team.getTeamDiscipline());
            }
        }
        String teamsString = String.join(", ", memberTeams);
        return " for " + memberFirstName + " " + memberLastName + ":\n" + teamsString;
    }

    //***SETTER METHODS***----------------------------------------------------------------------------------------------
    public void setMemberRecords(ArrayList<Record> memberRecords) {
        this.memberRecords = memberRecords;
    }

    public void setBestTrainingRecord(double bestTrainingRecord) {
        this.bestTrainingRecord = bestTrainingRecord;
    }

    public void setActiveDisciplines() {
        findDisciplines();
    }

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
    public void addTeamForSpecificMember(Team team) {
        this.teams.add(team);
    }

    public void removeTeamForSpecificMember(Team team) {
        this.teams.remove(team);
    }
    public void addRecordToMember(Record record) {
        memberRecords.add(record);
    }


    //***OTHER METHODS***-----------------------------------------------------------------------------------------------
    public void recordInitializer() {
        for (Record record : getMemberRecords()) {
            if (record instanceof CompetitionRecord) {
                competitionRecords.add((CompetitionRecord) record);
            } else {
                trainingRecords.add((TrainingRecord) record);
            }

        }
    }

    public ArrayList<String> findDisciplines() {
        for (Record record : memberRecords) {
            if (!activeDisciplines.contains(record.getDiscipline())) {
                activeDisciplines.add(record.getDiscipline());
            }
        }
        return activeDisciplines;
    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        String membershipStatus = isActive() ? "Aktiv" : "Passiv";

        return "***Medlemsinformation konkurrencesvømmer***\n" +
                "Navn: " + getMemberFirstName() + " " + getMemberLastName() + '\n' +
                "Fødselsdag: " + getDateOfBirth() + '\n' +
                "Medlemsstatus: " + membershipStatus + '\n' +
                "Medlemstype: " + getMemberShipType() + '\n' +
                "Årligt kontigent: " + getMembershipFee() + " DKK\n" +
                "Restance: " + getDebt() + " DKK\n" +
                "Hold " + getTeamsForSpecificMember() + '\n';

    }



    //------------------------------------------------------------------------------------------------------------------
}


