package domain_model;

import java.time.LocalDate;

public class ExerciseMember extends Member {
    public ExerciseMember(String firstName, String lastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        super(firstName, lastName, dateOfBirth, debt, isActive);
    }

}