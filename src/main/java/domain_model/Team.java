package domain_model;

import comparator.BestRecordComparator;
import comparator.RecordComparator;

import java.util.ArrayList;
import java.util.Collections;

// DELVIST REFAKTORERET (SE TODOS)

public class Team {

    //**TO DO***--------------------------------------------------------------------------------------------------------


    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String teamDiscipline;
    private ArrayList<Member> teamMemberList = new ArrayList<>();
    private boolean isTeamSenior;
    Coach coach;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Team(String teamDiscipline, Coach coach, boolean isTeamSenior) {
        this.teamDiscipline = teamDiscipline.toLowerCase();
        this.coach = coach;
        this.isTeamSenior = isTeamSenior;
        initialiseCompetitionMemberToCoach();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getTeamDiscipline() {
        return teamDiscipline;
    }

    public String getIsTeamSenior() {
        return (isTeamSenior) ? "Senior" : "Junior";
    }

    public String getCoach() {
        return coach.getCoachFirstName() + ' ' + coach.getCoachLastName();
    }

    public ArrayList<Member> getTeamMemberList() {
        return teamMemberList;
    }


    public String getTeamListAsString() {
        String teamMembers = "";
        for (Member member : teamMemberList) {
            teamMembers += member.getMemberFirstName() + ' ' + member.getMemberLastName() + '\n';
        }
        return teamMembers;
    }

    //***METHODS***----------------------------------------------------------------------------------------
    public void initialiseCompetitionMemberToCoach() {
        coach.setMemberListForCoach(getTeamMemberList());
    }


    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------

    public void addMemberToTeam(Member member) {
        teamMemberList.add(member);

    }

    public CompetitionMember[] getTopFive() {
        CompetitionMember[] topFive = new CompetitionMember[5];
        ArrayList<CompetitionMember> membersToSort = new ArrayList<>();

        //loop through members of the team
        for (Member member : teamMemberList) {

            // assign member to a temporary variable
            CompetitionMember teamMember = (CompetitionMember) member;

            // assign member training records to an array list
            ((CompetitionMember) member).recordInitializer();
           ArrayList<TrainingRecord> memberTrainingRecords = teamMember.getTrainingRecords();
           // sort training records by time
            Collections.sort(memberTrainingRecords, new RecordComparator());

            // loop through sorted training records
            for (TrainingRecord memberTrainingRecord : memberTrainingRecords) {

                //Check if training record is in same discipline as the team discipline.
                if(memberTrainingRecord.getDiscipline().equalsIgnoreCase(teamDiscipline)) {
                    // Set record's result as member's best training result.
                    teamMember.setBestTrainingRecord(memberTrainingRecord.getResult());
                    //add member to the list of members to sort.
                    membersToSort.add(teamMember);
                    break;
                }
            }

        }
        // Sort list of members whom best training result's discipline is same as team discipline.
        Collections.sort(membersToSort, new BestRecordComparator());

        if (!membersToSort.isEmpty()) {
            int helperNumber = (membersToSort.size() < 5 ) ? membersToSort.size() : 5;  ;
            for (int i = 0; i < helperNumber ; i++ ){
                topFive[i] = membersToSort.get(i);
            }
            return topFive;
        }
        return null;
    }

    public void removeMemberofTeam(Member member) {
        this.teamMemberList.remove(member);
    }

    //***TO STRING METHOD***-----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Team:\n" +
                "Team name: " + teamDiscipline + '\n' +
                "Team coach: " + getCoach() + '\n' +

                "Team type " + isTeamSenior + '\n' +
                "Team members: \n" + getTeamListAsString();
    }


    //------------------------------------------------------------------------------------------------------------------
}


