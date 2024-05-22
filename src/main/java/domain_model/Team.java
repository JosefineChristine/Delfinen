package domain_model;

import comparator.BestRecordComparator;
import comparator.RecordComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Team {
    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String teamDiscipline;
    private ArrayList<Member> teamMemberList = new ArrayList<>();
    private boolean isTeamSenior;
    private Coach coach;

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


        for (Member member : teamMemberList) {


            CompetitionMember teamMember = (CompetitionMember) member;


            ((CompetitionMember) member).recordInitializer();
            ArrayList<TrainingRecord> memberTrainingRecords = teamMember.getTrainingRecords();

            Collections.sort(memberTrainingRecords, new RecordComparator());


            for (TrainingRecord memberTrainingRecord : memberTrainingRecords) {


                if (memberTrainingRecord.getDiscipline().equalsIgnoreCase(teamDiscipline)) {

                    teamMember.setBestTrainingRecord(memberTrainingRecord.getResult());

                    membersToSort.add(teamMember);
                    break;
                }
            }

        }

        Collections.sort(membersToSort, new BestRecordComparator());

        if (!membersToSort.isEmpty()) {
            int helperNumber = (membersToSort.size() < 5) ? membersToSort.size() : 5;
            ;
            for (int i = 0; i < helperNumber; i++) {
                topFive[i] = membersToSort.get(i);
            }
            return topFive;
        }
        return null;
    }


    //***TO STRING METHOD***-----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Hold:\n" +
                "Hold navn: " + teamDiscipline + '\n' +
                "Træner: " + getCoach() + '\n' +
                "Holdtype " + isTeamSenior + '\n' +
                "Holdmedlemmer: \n" + getTeamListAsString();


        //------------------------------------------------------------------------------------------------------------------
    }
}


