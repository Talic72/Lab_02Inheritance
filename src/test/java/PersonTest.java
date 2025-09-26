package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonConstructorAndGetters()
    {
        Person p = new Person("John", "Doe", "123", "Mr.", 1990);

        assertEquals("John", p.getFirstName());
        assertEquals("Doe", p.getLastName());
        assertEquals("123", p.getID());
        assertEquals("Mr.", p.getTitle());
        assertEquals(1990, p.getYOB());
    }

    @Test
    void testToCSV()
    {
        Person p = new Person("John", "Doe", "123", "Mr.", 1990);
        String expected = "John,Doe,123,Mr.,1990";
        assertEquals(expected, p.toCSV());
    }

    @Test
    void testToJSON()
    {
        Person p = new Person("John", "Doe", "123", "Mr.", 1990);
        String expected = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"ID\":\"123\",\"title\":\"Mr.\",\"YOB\":1990}";
        assertEquals(expected, p.toJSON());
    }

    @Test
    void testToXML()
    {
        Person p = new Person("John", "Doe", "123", "Mr.", 1990);
        String expected = "<main.Person>\n" +
                "  <firstName>John</firstName>\n" +
                "  <lastName>Doe</lastName>\n" +
                "  <ID>123</ID>\n" +
                "  <title>Mr.</title>\n" +
                "  <YOB>1990</YOB>\n" +
                "</main.Person>";
        assertEquals(expected, p.toXML());
    }
}