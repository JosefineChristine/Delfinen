package domain_model;

import java.time.LocalDate;

public class TrainingRecord extends Record {


    public TrainingRecord(String title, String discipline ,double result, LocalDate date) {
        super(title,discipline,result,date);

    }

}