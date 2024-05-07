package domain_model;

import java.time.LocalDate;
import java.time.Period;

//TODO - Hvordan håndterer vi member type? String metoden vs. enums?
public abstract class Member {
    private String memberFirstName;
    private String memberLastName;
    private LocalDate dateOfBirth;
    private double debt;
    private boolean isActive;
    private String memberShipType; //mangler i konstruktør
    private double membershipFee;

    public Member(String memberFirstName, String memberLastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.dateOfBirth = dateOfBirth;
        this.debt = debt;
        this.isActive = isActive;

    }
    //************GETTERS********---------------------------------------------------------------------------------------
    public String getMemberFirstName() {
        return memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
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
    public String getMemberShipType() {
        return memberShipType;
    }

    public double getMembershipFee(){
        return membershipFee;
    }

//************SETTERS********-------------------------------------------------------------------------------------------
    public void setFirstName(String firstName) {
        this.memberFirstName = firstName;
    }

    public void setLastName(String lastName) {
        this.memberLastName = lastName;
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
    public void setMemberShipType(String memberShipType) {
        this.memberShipType = memberShipType;
    }

    //************METHODS********---------------------------------------------------------------------------------------

    public double calculateMembershipFee() {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();
        double yearlyMembershipFee = 500;
        //TODO: måske oprette junior/senior som en boolean

        if (age < 18 && isActive) {
            yearlyMembershipFee = 1000;
        } else if (age > 18 && isActive) {
            yearlyMembershipFee = 1600;
        } else if (age > 60 && isActive) { //check if it works, condition isActive always false??
            yearlyMembershipFee = (1600*0.75);
        }
        return yearlyMembershipFee;
    }

    //------------------------------------------------------
}
