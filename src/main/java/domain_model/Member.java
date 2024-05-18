package domain_model;

import java.time.LocalDate;
import java.time.Period;


public abstract class Member {
    private String memberFirstName;
    private String memberLastName;
    private LocalDate dateOfBirth;
    private double debt;
    private boolean isActive;
    private String memberShipType;
    private String ageGroup;
    private double membershipFee;


    public Member(String memberFirstName, String memberLastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.dateOfBirth = dateOfBirth;
        this.debt = debt;
        this.isActive = isActive;
        this.membershipFee = calculateMembershipFee();
        this.ageGroup = calculateMembershipType();

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


    public String getAgeGroup() {
        return ageGroup;
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


    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    //************METHODS********---------------------------------------------------------------------------------------
    public String calculateMembershipType() {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(getDateOfBirth(), currentDate).getYears();
        String membersShipType;
        if (age < 18) {
            membersShipType = "junior";
        } else {
            membersShipType = "senior";
        }
        setMemberShipType(membersShipType);
        return membersShipType;
    }

    public double calculateMembershipFee() {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();
        double yearlyMembershipFee = 500;

        if (isActive) {
            if (age < 18) {
                yearlyMembershipFee = 1000;
            } else if (age > 60) {
                yearlyMembershipFee = (1600 * 0.75);
            } else {
                yearlyMembershipFee = 1600;
            }
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
