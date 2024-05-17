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
           super.setMemberShipType("exerciser");
    }

    //***TO STRING***---------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        String medlemsStatus = isActive() ?  "Aktiv" : "Passiv";

        return  "***Medlemsinformation***\n" +
                "Navn: "                       + getMemberFirstName() + " "  + getMemberLastName() + '\n' +
                "Fødselsdag: "              + getDateOfBirth()            + '\n'     +
                "Medlemsstatus: "              + medlemsStatus                  + '\n'     +
                "Medlemstype: "                + getMemberShipType()         + '\n'     +
                "Årligt kontigent: "      + getMembershipFee()          + " DKK\n" +
                "Restance: "                       + getDebt()                   + " DKK\n";
    }

    //------------------------------------------------------------------------------------------------------------------
}