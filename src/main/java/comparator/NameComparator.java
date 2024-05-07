package comparator;

import domain_model.CompetitionMember;

import java.util.Comparator;

public class NameComparator implements Comparator<CompetitionMember> {
    @Override
    public int compare(CompetitionMember d1, CompetitionMember d2) {
        return (d1.getMemberFirstName().compareTo(d2.getMemberFirstName()) +
                d1.getMemberLastName().compareTo(d2.getMemberLastName()));
    }

}
