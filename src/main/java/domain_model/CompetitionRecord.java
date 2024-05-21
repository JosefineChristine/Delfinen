package domain_model;

import java.time.LocalDate;

// DELVIST REFAKTORERET (SE TODOS)

public class CompetitionRecord extends Record {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String placeAchieved;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public CompetitionRecord(String eventName, String discipline, double result,
                             LocalDate date, String place) {
        super(eventName, discipline, result, date);
        placeAchieved = place;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getPlaceAchieved() {
        return placeAchieved;
    }



    //*****************************************TO-STRING****************************************************************
    @Override
    public String toString() {
        return
                "Konkurrenceresultat: \n" +
                        "Disciplin: " + discipline + '\n' +
                        "Tidsresultat: " + result + " minutter" + '\n' +
                        "Dato: " + date + '\n' +
                        "Placering : " + placeAchieved + '\n' +
                        "Begivenhed: " + eventName + '\n';
    }
}