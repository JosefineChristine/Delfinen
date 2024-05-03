import java.time.LocalDate;

public class TrainingRecord {

    private String discipline;
    private double result;
    private LocalDate date;

    public TrainingRecord(String discipline, double result, LocalDate date) {
        this.discipline = discipline;
        this.result = result;
        this.date = date;

    }

}