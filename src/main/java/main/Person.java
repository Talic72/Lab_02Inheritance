package main;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getYOB() {
        return YOB;
    }
    public String toCSV()
    {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }

    public String toJSON()
    {
        return String.format("{\"firstName\":\"%s\",\"lastName\":\"%s\",\"ID\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                firstName, lastName, ID, title, YOB);
    }

    public String toXML() {
        return "<main.Person>\n" +
                "  <firstName>" + firstName + "</firstName>\n" +
                "  <lastName>" + lastName + "</lastName>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <title>" + title + "</title>\n" +
                "  <YOB>" + YOB + "</YOB>\n" +
                "</main.Person>";
    }
}