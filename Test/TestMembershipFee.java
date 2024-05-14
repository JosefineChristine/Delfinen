import domain_model.CompetitionMember;
import domain_model.ExerciseMember;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMembershipFee {

    @Test
    public void testCalculateMembershipFee() {

        // Create new LocalDate objects
        LocalDate birthday1 = LocalDate.of(1990, 05, 12);
        LocalDate birthday2 = LocalDate.of(2010, 01, 22);
        LocalDate birthday3 = LocalDate.of(1955, 03, 15);
        LocalDate birthday4 = LocalDate.of(1999, 04, 28);

        // Create new Member objects
        CompetitionMember competitionMember1 = new CompetitionMember("Example first name", "Example surname", birthday1, 0, true); // Active competition member over 18
        CompetitionMember competitionMember2 = new CompetitionMember("Example first name", "Example surname", birthday2, 0, true); // Active competition member under 18
        ExerciseMember exerciseMember1 = new ExerciseMember("Example first name", "Example surname", birthday3, 0, true); // Active exercise member over 65
        ExerciseMember exerciseMember2 = new ExerciseMember("Example first name", "Example surname", birthday4, 0, false); // Passive exercise member over 18

        // Calculate the membership fee
        double fee1 = competitionMember1.calculateMembershipFee();
        double fee2 = competitionMember2.calculateMembershipFee();
        double fee3 = exerciseMember1.calculateMembershipFee();
        double fee4 = exerciseMember2.calculateMembershipFee();

        // Verify that the membership fee has been calculated
        assertEquals(1600, fee1); // Expected vs actual
        assertEquals(1000, fee2);
        assertEquals(1200, fee3);
        assertEquals(500, fee4);
    }
}
