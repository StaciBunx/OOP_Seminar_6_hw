package Task3;

import Task3.dip.PrintReport;
import Task3.dip.Report;

public class Main {
    public static void main(String[] args) {
        Report report = new Report();
        PrintReport pr = new PrintReport();
        pr.output(report.calculate());
    }
}
