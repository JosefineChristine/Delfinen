package domain_model;

import java.time.LocalDate;

public abstract class Record {
    // Title is either training or event name.
    private String title;
    private String discipline;
    private double result;
    private LocalDate date;


    public Record(String title, String discipline, double result, LocalDate date) {
        this.title = title;
        this.discipline = discipline;
        this.result = result;
        this.date = date;
    }
}
