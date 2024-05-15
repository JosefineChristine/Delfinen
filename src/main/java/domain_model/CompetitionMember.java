package domain_model;

import comparator.RecordComparator;
import data_handler.SaveToFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class CompetitionMember extends Member {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<Record> memberRecords = new ArrayList<>();
    private ArrayList<Team> teams;
    private ArrayList<String> activeDisciplines = new ArrayList<>();

    //***CONSTRUCTOR****------------------------------------------------------------------------------------------------
    public CompetitionMember(String memberFirstName, String memberLastName, LocalDate dateOfBirth,
                             double debt, boolean isActive) {
        super(memberFirstName, memberLastName, dateOfBirth, debt, isActive);
        super.setMemberShipType("Competition");
        teams = new ArrayList<>();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public ArrayList<Record> getMemberRecords() {
        return memberRecords;
    }

    public String getTeamsForSpecificMember() {
        ArrayList<String> memberTeams = new ArrayList<>();
        for (Team team : teams) {
            if (team.getTeamMemberList().contains(this)) {
                memberTeams.add(team.getTeamDiscipline());
            }
        }
        //TODO Navn getter måske slettes hvis vi ikke bruger metoden udover i de fulde stamoplysningsprint
        return "Hold for " + getMemberFirstName() + " " + getMemberLastName() + ":\n" + memberTeams;
    }

    //***SETTER METHODS***----------------------------------------------------------------------------------------------
    public void setMemberRecords(ArrayList<Record> memberRecords) {
        this.memberRecords = memberRecords;
    }

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
    public void addTeamForSpecificMember(Team team) {
        this.teams.add(team);
    }

    public void removeTeamForSpecificMember(Team team) {
        this.teams.remove(team);
    }

    public void addRecord(Record record) {
        memberRecords.add(record);
    }

    //***OTHER METHODS***-----------------------------------------------------------------------------------------------

    public Record findBestTrainingRecord(){
        ArrayList<Record> trainingRecordList = new ArrayList<>();
        for (Record record : memberRecords) {
            if (record instanceof TrainingRecord) {
                trainingRecordList.add(record);
            }
        } Collections.sort(trainingRecordList, new RecordComparator()); //sorterer
        return (trainingRecordList.get(0)); //henter index 0 og retunerer den
    }

    public Record findBestCompetetionRecord(){
        ArrayList<Record> competetionRecordList = new ArrayList<>();
        for (Record record : memberRecords) {
            if (record instanceof CompetitionRecord) {
                competetionRecordList.add(record);
            }
        } Collections.sort(competetionRecordList, new RecordComparator()); //sorterer
        return (competetionRecordList.get(0)); //henter index 0 og retunerer den
    }



    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    public String toString() {
        String medlemsStatus = isActive() ?  "Aktiv" : "Passiv";

        return  "***Medlemsinformation***\n" +
                "Navn: "                       + getMemberFirstName() + " "  + getMemberLastName() + '\n' +
                "Fødselsdag: "              + getDateOfBirth()            + '\n'     +
                "Medlemsstatus: "              + medlemsStatus                  + '\n'     +
                "Medlemstype: "                + getMemberShipType()         + '\n'     +
                "Årligt kontigent: "      + getMembershipFee()          + " DKK\n" +
                "Restance: "                       + getDebt()                   + " DKK\n" +
                                        getTeamsForSpecificMember() + '\n' ;
                //"Discipliner: "                       + findDisciplines() + '\n' ;
//                "Competition records: "        + competitionRecord           + '\n' +
//                "Training records: "           + trainingRecord              + '\n' ;
    }

    //------------------------------------------------------------------------------------------------------------------
}