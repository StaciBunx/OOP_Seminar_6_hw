package Task3.dip;

import java.util.ArrayList;
import java.util.List;

public class Report implements Calculate {

    @Override
    public List<ReportItem> calculate() {
        List<ReportItem> items = new ArrayList<ReportItem>();
        items.add(new ReportItem("First", (float) 11));
        items.add(new ReportItem("Second", (float) 35));
        return items;
    }

}
