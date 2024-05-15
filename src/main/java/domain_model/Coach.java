package domain_model;

import java.util.ArrayList;

public class Coach {

    //***QUESTIONS& MISSING CODE***-------------------------------------------------------------------------------------
    //TODO Coach is trainer for?
    //TODO arrayliste til medlemmer? metode hvorpå man kan se listen af medlemmer for hver træner

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String coachFirstName;
    private String coachLastName;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Coach(String coachFirstName, String coachLastName){
        this.coachFirstName = coachFirstName;
        this.coachLastName = coachLastName;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public String getCoachFirstName(){
        return coachFirstName;
    }

    public String getCoachLastName(){
        return coachLastName;
    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "Coach name: " + getCoachFirstName() + " " + getCoachLastName();
    }


    //------------------------------------------------------------------------------------------------------------------
}
