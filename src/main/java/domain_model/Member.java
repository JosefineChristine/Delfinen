package domain_model;

import java.time.LocalDate;

public abstract class Member {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private double debt;
    private boolean isActive;
    //TODO: medlemsnummer?

    public Member(String firstName, String lastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.debt = debt;
        this.isActive = isActive;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public double getDebt() {
        return debt;
    }

    public boolean isActive() {
        return isActive;
    }
}
