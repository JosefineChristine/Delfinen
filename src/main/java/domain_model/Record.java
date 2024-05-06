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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
