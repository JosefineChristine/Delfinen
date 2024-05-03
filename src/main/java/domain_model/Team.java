package domain_model;

import java.util.ArrayList;

public class Team {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String teamName;
    private String teamInfo;
    private ArrayList<Member> teamMembers;
    Coach coach;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Team(String teamName, String teamInfo, Coach coach){
        this.teamName = teamName;
        this.teamInfo = teamInfo;
        this.coach = coach;

    //------------------------------------------------------------------------------------------------------------------
    }



}
