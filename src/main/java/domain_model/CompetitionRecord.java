package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class CompetitionRecord extends Record {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String placeAchieved;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public CompetitionRecord(String title, String discipline , double result, LocalDate date, String place ) {
        super(title,discipline,result,date);
        this.placeAchieved = place;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getPlaceAchieved() {
        return placeAchieved;
    }

    //***SETTER METHODS***----------------------------------------------------------------------------------------------

    public void setPlaceAchieved(String placeAchieved) {
        this.placeAchieved = placeAchieved;
    }

    //*****************************************METHODS******************************************************************

    //*****************************************TO-STRING****************************************************************
    @Override
    public String toString(){
        return
                "Discipline: "        + getDiscipline()    + '\n' +
                "Time result (min): " + getResult()        + '\n' +
                "Date: "              + getDate()          + '\n' +
                "Rank : "             + getPlaceAchieved() + '\n' +
                "Event: "             + getEventName()     + '\n';
    }
}