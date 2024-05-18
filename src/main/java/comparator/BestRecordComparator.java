package comparator;

import domain_model.CompetitionMember;

import java.util.Comparator;

public class BestRecordComparator implements Comparator<CompetitionMember> {
    @Override
    public int compare(CompetitionMember member1, CompetitionMember member2) {
        return Double.compare(member1.getBestTrainingRecord(), member2.getBestTrainingRecord());
    }
}




