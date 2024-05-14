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
    private Team team;
    private ArrayList<String> activeDisciplines =new ArrayList<>();
    private SaveToFile fileHandler = new SaveToFile();

    //***CONSTRUCTOR****------------------------------------------------------------------------------------------------
    public CompetitionMember(String memberFirstName, String memberLastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        super(memberFirstName, memberLastName, dateOfBirth, debt, isActive);
        super.setMemberShipType("Competition");
        this.teams= new ArrayList<>();

    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public ArrayList<Record> getMemberRecords() {
        return memberRecords;
    }

    public ArrayList<String> getActiveDisciplines() {
        return activeDisciplines;
    }

    public String getTeamsForSpecificMember() {
        ArrayList<String> memberTeams = new ArrayList<>();
        for (Team team : teams) {
            if (team.getTeamMemberList().contains(this)) {
                memberTeams.add(team.getTeamDiscipline());
            }
        }
        return "Teams for " + getMemberFirstName() + " " + getMemberLastName() + ":\n" + memberTeams;
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

//    public ArrayList<Record> searchMemberRecord(String membersSearchedRecord) {
//        var bestMembersRecord = new ArrayList<Record>(); //var kalder variablen, som er defineret efter new
//        for (Record items : memberRecords) {
//            if //sort metode {
//                //itererer
//            } return bestMembersRecord;
//        }


    public void findDisciplines(ArrayList<Record> records){
        for(Record record : records){
            if(!activeDisciplines.contains(record.getDiscipline())){
                activeDisciplines.add(record.getDiscipline());
            }
        }
    }

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
        return  "***MEMBER'S INFORMATION***\n" +
                "Name: "                       + getMemberFirstName() + " "  + getMemberLastName() + '\n' +
                "Date of birth: "              + getDateOfBirth()            + '\n'     +
                "Active member: "              + isActive()                  + '\n'     +
                "Member type: "                + getMemberShipType()         + '\n'     +
                "Yearly membership fee: "      + getMembershipFee()          + " DKK\n" +
                "Debt: "                       + getDebt()                   + " DKK\n" +
                "Team: "                       + getTeamsForSpecificMember() + '\n' ;
//                "Competition records: "        + competitionRecord           + '\n' +
//                "Training records: "           + trainingRecord              + '\n' ;
    }

    //------------------------------------------------------------------------------------------------------------------
}