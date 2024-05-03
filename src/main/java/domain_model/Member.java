package domain_model;

import java.time.LocalDate;
import java.time.Period;

public abstract class Member {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private double debt;
    private boolean isActive;
    //TODO: beslutte om medlemmer skal have et medlemsnummer

    public Member(String firstName, String lastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.debt = debt;
        this.isActive = isActive;

    }
//************Getters********-------------------------------------------------------------------------------------------
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

//************Setters********-------------------------------------------------------------------------------------------
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double calculateMembershipFee() {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();
        double yearlyMembershipFee = 500;
        //TODO: måske oprette junior/senior som en boolean

        if (age < 18) {
            yearlyMembershipFee = 1000;
        } else if (age > 18) {
            yearlyMembershipFee = 1600;
        } else if (age > 60) {
            yearlyMembershipFee = (1600*0.75);
        }
        return yearlyMembershipFee;

    }
    //TODO: tilføj pris for passiv

}
