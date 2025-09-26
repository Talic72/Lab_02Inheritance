package main;

public class Worker extends Person {
    private double hourlyPayRate;
    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate)
    {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() { return hourlyPayRate; }

    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours;
        double overtimeHours;

        if (hoursWorked <= 40)
        {
            regularHours = hoursWorked;
            overtimeHours = 0;
        }
        else
        {
            regularHours = 40;
            overtimeHours = hoursWorked - 40;
        }
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        return regularPay + overtimePay;
    }

    public void displayWeeklyPay(double hoursWorked)
    {
        double regularHours;
        double overtimeHours;

        if (hoursWorked <= 40) {
            regularHours = hoursWorked;
            overtimeHours = 0;
        }
        else
        {
            regularHours = 40;
            overtimeHours = hoursWorked - 40;
        }

        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double total = regularPay + overtimePay;
        System.out.printf("%s %s (ID:%s) - Regular: %.2f hrs -> $%.2f; Overtime: %.2f hrs -> $%.2f; Total: $%.2f%n",
                getFirstName(), getLastName(), getID(), regularHours, regularPay, overtimeHours, overtimePay, total);
    }

    @Override
    public String toCSV()
    {
        return super.toCSV() + "," + hourlyPayRate;
    }

    @Override
    public String toXML()
    {
        return super.toXML().replace("</Person>", "  <hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate>\n</Person>");
    }

    @Override
    public String toJSON()
    {
        return super.toJSON().replaceFirst("\\}$", ", \"hourlyPayRate\": " + hourlyPayRate + " }");
    }
}