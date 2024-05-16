package domain_model;

import java.time.LocalDate;

public class TrainingRecord extends Record {


    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public TrainingRecord(String title, String discipline ,double result, LocalDate date) {
        super(title,discipline,result,date);

    }

    //***METHODS***-----------------------------------------------------------------------------------------------------

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return
                "Discipline: "        + getDiscipline() + '\n' +
                "Time result (min): " + getResult()     + '\n' +
                "Date: "              + getDate()       + '\n' ;
    }

    //------------------------------------------------------------------------------------------------------------------
}