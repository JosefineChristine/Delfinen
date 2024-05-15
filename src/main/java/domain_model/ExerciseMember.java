package domain_model;

import java.time.LocalDate;

public class ExerciseMember extends Member {

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public ExerciseMember(String memberFirstName, String memberLastName, LocalDate dateOfBirth, double debt, boolean isActive) {
        super(memberFirstName,
              memberLastName,
              dateOfBirth,
              debt,
              isActive);
//        super.setMemberShipType("exerciser");
    }

    //***TO STRING***---------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return  "***MEMBER'S INFORMATION***\n" +
                "Name: "                       + getMemberFirstName() + " "  + getMemberLastName() + '\n' +
                "Date of birth: "              + getDateOfBirth()     + '\n'     +
                "Active member: "              + isActive() + '\n'    +
                "Member type: "                + getMemberShipType()  + '\n'     +
                "Yearly membership fee: "      + getMembershipFee()   + " DKK\n" +
                "Debt: "                       + getDebt()            + " DKK\n" ;
    }

    //------------------------------------------------------------------------------------------------------------------
}