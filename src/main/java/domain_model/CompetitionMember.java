package domain_model;

import comparator.RecordComparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

// DELVIST REFAKTORERET (SE TODOS)

public class CompetitionMember extends Member {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<Record> memberRecords;
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

        memberRecords = new ArrayList<>();
        activeDisciplines = new ArrayList<>();
        teams = new ArrayList<>();
        trainingRecords = new ArrayList<>();
        competitionRecords = new ArrayList<>();

        setActiveDisciplines();
        recordInitializer();

    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public ArrayList<Record> getMemberRecords() {
        return memberRecords;
    }

    //TODO this methode does not work. must fixe
    public ArrayList<String> getActiveDisciplines() {
        return activeDisciplines;
    }

    public double getBestTrainingRecord() {
        findBestTrainingRecord();
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
        //TODO Navn getter måske slettes hvis vi ikke bruger metoden udover i de fulde stamoplysningsprint (Og "hold for" tilføjes i toString)
        return " for " + memberFirstName + " " + memberLastName + ":\n" + memberTeams;
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

    //TODO: Tjek om disse metoder skal bruges
    public void addTeamForSpecificMember(Team team) {
        this.teams.add(team);
    }

    public void removeTeamForSpecificMember(Team team) {
        this.teams.remove(team);
    }

    public void addTrainingRecordToMember(TrainingRecord record) {
        trainingRecords.add(record);
    }

    public void addCompetitionRecordToMember(CompetitionRecord record) {
        competitionRecords.add(record);
    }


    //***OTHER METHODS***-----------------------------------------------------------------------------------------------
    public void recordInitializer() { //TODO: Hvorfor har vi denne metode når de to foregående kan præcis det samme?
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

    public Record findBestTrainingRecord() {
        ArrayList<Record> trainingRecordList = new ArrayList<>();
        for (Record record : getMemberRecords()) {
            if (record instanceof TrainingRecord) {
                trainingRecordList.add(record);
            }
        }
        Collections.sort(trainingRecordList, new RecordComparator()); //sorterer
        setBestTrainingRecord(trainingRecordList.get(0).getResult());
        return (trainingRecordList.get(0)); //henter index 0 og retunerer den
    }

    public Record findBestCompetetionRecord() {
        ArrayList<Record> competetionRecordList = new ArrayList<>();
        for (Record record : memberRecords) {
            if (record instanceof CompetitionRecord) {
                competetionRecordList.add(record);
            }
        }
        Collections.sort(competetionRecordList, new RecordComparator()); //sorterer
        return (competetionRecordList.get(0)); //henter index 0 og retunerer den
    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    public String toString() {
        String medlemsStatus = isActive() ? "Aktiv" : "Passiv";

        return "***Medlemsinformation konkurrencesvømmer***\n" +
                "Navn: " + getMemberFirstName() + " " + getMemberLastName() + '\n' +
                "Fødselsdag: " + getDateOfBirth() + '\n' +
                "Medlemsstatus: " + medlemsStatus + '\n' +
                "Medlemstype: " + getMemberShipType() + '\n' +
                "Årligt kontigent: " + getMembershipFee() + " DKK\n" +
                "Restance: " + getDebt() + " DKK\n" +
                "Hold " + getTeamsForSpecificMember() + '\n';

    }

    //------------------------------------------------------------------------------------------------------------------
}