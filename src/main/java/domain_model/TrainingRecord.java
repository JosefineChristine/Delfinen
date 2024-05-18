package domain_model;

import java.time.LocalDate;

public class TrainingRecord extends Record {


    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public TrainingRecord(String title, String discipline, double result, LocalDate date) {
        super(title, discipline, result, date);

    }

    //***METHODS***-----------------------------------------------------------------------------------------------------

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return
                "Træningsresultet: \n" +
                        "Disciplin: " + getDiscipline() + '\n' +
                        "Tidsresultat: " + getResult() + " minutter" + '\n' +
                        "Dato: " + getDate() + '\n';
    }

    //------------------------------------------------------------------------------------------------------------------
}