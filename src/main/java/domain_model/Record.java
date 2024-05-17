package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Record {
    // Title is either training or event name.
    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String eventName;
    private String discipline;
    private double result;
    private LocalDate date;

    private ArrayList<Record> recordList = new ArrayList<>();

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

    //***SETTER METHODS***----------------------------------------------------------------------------------------------

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------

    public void addRecord(Record record){
    recordList.add(record);
    }


}
