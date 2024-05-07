package comparator;

import domain_model.Record;

import java.util.Comparator;

public class RecordComparator implements Comparator<Record> {
    @Override
    public int compare(Record r1, Record r2) {
        return Double.compare(r1.getResult(), r2.getResult());
    }
}
