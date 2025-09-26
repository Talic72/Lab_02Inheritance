package main;

public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double annualSalary)
    {
        super(firstName, lastName, ID, title, YOB, 0.0);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() { return annualSalary; }

    @Override
    public double calculateWeeklyPay(double hoursWorked)
    {
        return annualSalary / 52.0;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked)
    {
        double weekly = calculateWeeklyPay(hoursWorked);
        System.out.printf("%s %s (ID:%s) - Weekly pay (part of $%.2f annual): $%.2f%n",
                getFirstName(), getLastName(), getID(), annualSalary, weekly);
    }

    @Override
    public String toCSV()
    {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toXML()
    {
        return super.toXML().replace("</Person>", "  <annualSalary>" + annualSalary + "</annualSalary>\n</Person>");
    }

    @Override
    public String toJSON()
    {
        return super.toJSON().replaceFirst("\\}$", ", \"annualSalary\": " + annualSalary + " }");
    }
}