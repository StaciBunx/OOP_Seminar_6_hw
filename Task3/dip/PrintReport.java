package Task3.dip;

import java.util.List;

public class PrintReport implements Print {

    @Override
    public void output(List<ReportItem> items) {
        System.out.println("Output to printer");
        for (ReportItem item : items) {
            System.out.println(item);
        }

    }
}
