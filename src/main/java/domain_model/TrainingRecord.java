package domain_model;

import java.time.LocalDate;


public class TrainingRecord extends Record {


    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public TrainingRecord(String title, String discipline,
                          double result, LocalDate date) {
        super(title, discipline, result, date);

    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return
                "Træningsresultat: \n" +
                        "Disciplin: " + discipline + '\n' +
                        "Tid: " + result + " minutter" + '\n' +
                        "Dato: " + date + '\n';
    }

    //------------------------------------------------------------------------------------------------------------------
}