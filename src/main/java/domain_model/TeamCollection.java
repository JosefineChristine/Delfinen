package domain_model;

import java.util.ArrayList;

public class TeamCollection {
    ArrayList<Team> allTheTeams = new ArrayList<>();

    //************COACHES********---------------------------------------------------------------------------------------
    Coach coach1 = new Coach("Vahab", "Lotfyyekta");
    Coach coach2 = new Coach("Edith", "Terte");
    Coach coach3 = new Coach("Bjarne", "Larsen");
    Coach coach4 = new Coach("Sommer", "Dahl");
    Coach coach5 = new Coach("Arne", "Lmao");


    //************TEAMS********---------------------------------------------------------------------------------------
    Team team1 = new Team("crawl", coach1, true);
    Team team2 = new Team("butterfly", coach2, true);
    Team team3 = new Team("backstroke", coach3, true);
    Team team4 = new Team("breaststroke", coach4, true);
    Team team5 = new Team("crawl", coach1, false);
    Team team6 = new Team("butterfly", coach2, false);
    Team team7 = new Team("backstroke", coach3, false);
    Team team8 = new Team("breaststroke",coach4, false);
    Team team9 = new Team("exercise junior", coach5, false );
    Team team10 = new Team("exercise senior", coach5, true);

    //************TEAMS********-----------------------------------------------------------------------------------------


    public void generateTeams(){
        MemberCollection memberCollection = new MemberCollection();
        ArrayList<Member> members;
        members = memberCollection.getMemberList();
        for (Member member : members) {
            if( member instanceof ExerciseMember){
                addExerciseMember((ExerciseMember) member);
            } else {
                addCompetitionMember((CompetitionMember) member);
            }

        }


    }



    // make a methode for competition member
    public void addCompetitionMember(CompetitionMember memberToAdd){
        ArrayList<String> memberDisciplines = memberToAdd.getActiveDisciplines();
        if (memberToAdd.getAgeGroup().equalsIgnoreCase("junior")) {
            for (String memberDiscipline : memberDisciplines) {
                switch (memberDiscipline) {
                    case "crawl" -> team5.addMemberToTeam(memberToAdd);
                    case "butterfly" -> team6.addMemberToTeam(memberToAdd);
                    case "backstroke" -> team7.addMemberToTeam(memberToAdd);
                    case "breaststroke" -> team8.addMemberToTeam(memberToAdd);
                }
            }
        } else if (memberToAdd.getAgeGroup().equalsIgnoreCase("senior")) {

            for (String memberDiscipline : memberDisciplines) {
                switch (memberDiscipline) {
                case "crawl" -> team1.addMemberToTeam(memberToAdd);
                case "butterfly"-> team2.addMemberToTeam(memberToAdd);
                case "backstroke"-> team3.addMemberToTeam(memberToAdd);
                case "breaststroke"->team4.addMemberToTeam(memberToAdd);
            }
        }
    }
    }

    // make a method for exercise member
    public void addExerciseMember(ExerciseMember memberToAdd){
        if (memberToAdd.getAgeGroup().equalsIgnoreCase("junior")){
            team9.addMemberToTeam(memberToAdd);
        } else if (memberToAdd.getAgeGroup().equalsIgnoreCase("senior")) {
            team10.addMemberToTeam(memberToAdd);
        }
    }

    public void printTeams(){

        allTheTeams.add(team1);
        allTheTeams.add(team2);
        allTheTeams.add(team3);
        allTheTeams.add(team4);
        allTheTeams.add(team5);
        allTheTeams.add(team6);
        allTheTeams.add(team7);
        allTheTeams.add(team8);
        allTheTeams.add(team9);
        allTheTeams.add(team10);

    }


    public void showTeams(){

        for (Team team : allTheTeams) {
            System.out.println(team.getTeamListAsString());
            System.out.println(team.getTeamMemberList().size());

        }
    }

    }

    //------------------------------------------------------------------------------------------------------------------



// code grave yard


/*



    public void addMembersToTeams(Member member, int number){
        //TODO: refactor this methode
        if (member instanceof ExerciseMember &&  member.getMemberShipType().equalsIgnoreCase("junior")){
            team9.addMemberToTeam(member);
        } else if (member instanceof ExerciseMember &&  member.getMemberShipType().equalsIgnoreCase("senior")) {
            team10.addMemberToTeam(member);
        } else if (member instanceof CompetitionMember && member.getMemberShipType().equalsIgnoreCase("junior")) {
            String memberDiscipline =((CompetitionMember) member).getActiveDisciplines().get(number);
            switch (memberDiscipline){
                case "crawl" -> team5.addMemberToTeam(member);
                case "butterfly"-> team6.addMemberToTeam(member);
                case "backstroke"-> team7.addMemberToTeam(member);
                case "breaststroke"->team8.addMemberToTeam(member);
            }
        } else if (member instanceof CompetitionMember && member.getMemberShipType().equalsIgnoreCase("senior")) {
            String memberDiscipline =((CompetitionMember) member).getActiveDisciplines().get(number);
            switch (memberDiscipline){
                case "crawl" -> team1.addMemberToTeam(member);
                case "butterfly"-> team2.addMemberToTeam(member);
                case "backstroke"-> team3.addMemberToTeam(member);
                case "breaststroke"->team4.addMemberToTeam(member);
            }
        }

    }












//    public void addMemberToTeam(Member member, Team team){
//        if (member instanceof CompetitionMember &&
//                ((CompetitionMember) member).getActiveDisciplines().contains(getTeamDiscipline())){
//            if (member.getMemberShipType().equalsIgnoreCase(getIsTeamSenior())){
//                teamMemberList.add(member);
//            }
//        } else if (member instanceof ExerciseMember ){
//
//            if (member.getMemberShipType().equalsIgnoreCase(getIsTeamSenior())){
//                teamMemberList.add(member);
//            }
//
//        }
//    }

//
//    public void addMembersToTeams(Member member){
//        //TODO: refactor this methode
//     if (member instanceof CompetitionMember && member.getMemberShipType().equalsIgnoreCase("junior")) {
//            String memberDiscipline =((CompetitionMember) member).getActiveDisciplines().get(number);
//            switch (memberDiscipline){
//                case "crawl" -> team5.addMemberToTeam(member);
//                case "butterfly"-> team6.addMemberToTeam(member);
//                case "backstroke"-> team7.addMemberToTeam(member);
//                case "breaststroke"->team8.addMemberToTeam(member);
//            }
//        } else if (member instanceof CompetitionMember && member.getMemberShipType().equalsIgnoreCase("senior")) {
//            String memberDiscipline =((CompetitionMember) member).getActiveDisciplines().get(number);
//            switch (memberDiscipline){
//                case "crawl" -> team1.addMemberToTeam(member);
//                case "butterfly"-> team2.addMemberToTeam(member);
//                case "backstroke"-> team3.addMemberToTeam(member);
//                case "breaststroke"->team4.addMemberToTeam(member);
//            }
//        }
//
//    }


 */