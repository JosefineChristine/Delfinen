package domain_model;

import java.time.LocalDate;


public abstract class Record {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    protected String eventName;
    protected String discipline;
    protected double result;
    protected LocalDate date;


    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Record(String eventName, String discipline, double result, LocalDate date) {
        this.eventName = eventName;
        this.discipline = discipline.toLowerCase();
        this.result = result;
        this.date = date;


    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getEventName() {
        return eventName;
    }

    public String getDiscipline() {
        return discipline;
    }

    public double getResult() {
        return result;
    }

    public LocalDate getDate() {
        return date;
    }


}
