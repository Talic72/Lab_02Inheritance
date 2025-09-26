import main.SalaryWorker;
import main.Worker;

import java.util.ArrayList;
import java.util.List;

public class InheritanceDemo {
    public static void main(String[] args) {
        List<Worker> staff = new ArrayList<>();

        //hourly
        staff.add(new Worker("Alicia","Sovil","76575","Ms",2000, 15.00));
        staff.add(new Worker("Bobby","Brownon","86758","R.N.",1979, 20.30));
        staff.add(new Worker("Carolin","Dickinson","86575","Ms",1999, 18.50));

        //salary
        staff.add(new SalaryWorker("David","Davis","1w232","Mr",1989, 67050));
        staff.add(new SalaryWorker("Evelyn","Morris","3w500","Ms",1991, 79850));
        staff.add(new SalaryWorker("Frank","O'hare","9w166","Prof",1992, 104500));

        double[] weeks = {40.0, 50.0, 40.0};

        for (int week = 0; week < weeks.length; week++) {
            double hoursWorked = weeks[week];

            System.out.println("\n=== Week " + (week + 1) + " (" + (int) hoursWorked + " hrs) ===");
            System.out.printf("%-20s %-6s %-6s %-10s %-10s %-10s%n",
                    "Name", "ID", "Hours", "Regular", "Overtime", "Total");

            for (Worker w : staff) {
                if (w instanceof SalaryWorker) {
                    double pay = w.calculateWeeklyPay(hoursWorked);
                    System.out.printf("%-20s %-6s %-6.0f %-10s %-10s $%-9.2f%n",
                            w.getFirstName() + " " + w.getLastName(), w.getID(), hoursWorked, "-", "-", pay);

                }
                else
                {
                    double regularHours = Math.min(40.0, hoursWorked);
                    double overtimeHours = Math.max(0.0, hoursWorked - 40.0);

                    double regularPay = regularHours * w.getHourlyPayRate();
                    double overtimePay = overtimeHours * w.getHourlyPayRate() * 1.5;
                    double totalPay = regularPay + overtimePay;

                    System.out.printf("%-20s %-6s %-6.0f $%-9.2f $%-9.2f $%-9.2f%n",
                            w.getFirstName() + " " + w.getLastName(), w.getID(), hoursWorked, regularPay, overtimePay, totalPay);
                }
            }
        }
    }
}
