package domain_model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

//TODO - Hvordan håndterer vi member type? String metoden vs. enums?
public abstract class Member {
    private String memberFirstName;
    private String memberLastName;
    private LocalDate dateOfBirth;
    private double debt;
    private boolean isActive;
    private String memberShipType;
    private double membershipFee;


    public Member(String memberFirstName, String memberLastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.dateOfBirth = dateOfBirth;
        this.debt = debt;
        this.isActive = isActive;
        this.membershipFee = calculateMembershipFee();
        //this.memberShipType = calculateMembershipType();

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

    public double getMembershipFee() {
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
    public String calculateMembershipType() {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();
        String membersShipType;
        if (age < 18) {
            return membersShipType = "junior";
        } else {
            return membersShipType = "senior";
        }
    }

        public double calculateMembershipFee() {
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(dateOfBirth, currentDate).getYears();
            double yearlyMembershipFee = 500;
            //TODO refaktorer så vi kun tjekker isActive en gang

            if (age < 18 && isActive) {
                yearlyMembershipFee = 1000;
            } else if (age >= 18 && age <= 59 && isActive) {
                yearlyMembershipFee = 1600;
            } else if (age > 60 && isActive) {
                yearlyMembershipFee = (1600 * 0.75);
            }
            return yearlyMembershipFee;
        }

    @Override
    public String toString() {
        String result = "";
        result += "Medlem: " + memberFirstName + memberLastName + "\n" + "Fødselsdag: " + dateOfBirth + "\n" + "Restance: " + debt + "\n"
                + "Pris for medlemsskab: " + calculateMembershipFee();
        if (isActive) {
            result += "\n" + "Aktivitetsstatus: Aktiv";
        } else {
            result += "\n" + "Aktivitetsstatus: Passiv";
        }
        return result + "\n";
    }


    //------------------------------------------------------
}
