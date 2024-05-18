package domain_model;

import java.time.LocalDate;


public class CompetitionRecord extends Record {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String placeAchieved;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public CompetitionRecord(String title, String discipline, double result, LocalDate date, String place) {
        super(title, discipline, result, date);
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
    public String toString() {
        return
                "Konkurrenceresultat: \n" +
                        "Disciplin: " + getDiscipline() + '\n' +
                        "Tidsresultat: " + getResult() + " minutter" + '\n' +
                        "Dato: " + getDate() + '\n' +
                        "Placering : " + getPlaceAchieved() + '\n' +
                        "Begivenhed: " + getEventName() + '\n';
    }
}