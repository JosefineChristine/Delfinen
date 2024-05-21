package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;

// DELVIST REFAKTORERET (SE TODOS)

public abstract class Record {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    protected String eventName;
    protected String discipline;
    protected double result;
    protected LocalDate date;

    //todo oprydning remove not needed codes:
    // not oprydning needed
//    protected ArrayList<Record> recordList;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Record(String eventName, String discipline, double result, LocalDate date) {
        this.eventName = eventName;
        this.discipline = discipline.toLowerCase();
        this.result = result;
        this.date = date;

        //not needed
        //recordList = new ArrayList<>();
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

//    // TODO: oprydning måske laver edit method, Skal disse bruges?
//    public void setEventName(String eventName) {
//        this.eventName = eventName;
//    }
//
//    public void setDiscipline(String discipline) {
//        this.discipline = discipline;
//    }
//
//    public void setResult(double result) {
//        this.result = result;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------

    // not needed
//    public void addRecord(Record record) {
//        recordList.add(record);
//    }


}
