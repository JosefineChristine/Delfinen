import java.time.LocalDate;

public class CompetitionRecord {

    private String discipline;
    private double result;
    private LocalDate date;
    private String event;

    public CompetitionRecord(String discipline, double result,
                             LocalDate date, String event) {

        this.discipline = discipline;
        this.result  = result;
        this.date = date;
        this.event = event;
    }

}