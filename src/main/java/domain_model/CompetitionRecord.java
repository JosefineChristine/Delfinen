package domain_model;

import java.time.LocalDate;

public class CompetitionRecord extends Record {

    private String placeAchieved;


    public CompetitionRecord(String title, String discipline ,double result, LocalDate date ,String place ) {
        super(title,discipline,result,date);
        this.placeAchieved = place;
    }
}