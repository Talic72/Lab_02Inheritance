import main.Worker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void testWorkerWeeklyPayLessThan40Hours()
    {
        Worker worker = new Worker("Bob", "Jones", "W200", "Mr", 1985, 20.0);
        double pay = worker.calculateWeeklyPay(30);

        assertEquals(600.0, pay, 0.001);
    }

    @Test
    void testWorkerWeeklyPayExactly40Hours()
    {
        Worker worker = new Worker("Bob", "Jones", "W200", "Mr", 1985, 20.0);
        double pay = worker.calculateWeeklyPay(40);

        assertEquals(800.0, pay, 0.001);
    }

    @Test
    void testWorkerWeeklyPayOver40Hours()
    {
        Worker worker = new Worker("Bob", "Jones", "W200", "Mr", 1985, 20.0);
        double pay = worker.calculateWeeklyPay(45);

        assertEquals(950.0, pay, 0.001);
    }

    @Test
    void testWorkerToCSV()
    {
        Worker worker = new Worker("Bob", "Jones", "W200", "Mr", 1985, 20.0);
        String csv = worker.toCSV();

        assertTrue(csv.contains("20.0"));
    }

    @Test
    void testWorkerToXML()
    {
        Worker worker = new Worker("Bob", "Jones", "W200", "Mr", 1985, 20.0);
        String xml = worker.toXML();

        assertTrue(xml.contains("<hourlyPayRate>20.0</hourlyPayRate>"));
    }

    @Test
    void testWorkerToJSON()
    {
        Worker worker = new Worker("Bob", "Jones", "W200", "Mr", 1985, 20.0);
        String json = worker.toJSON();

        assertTrue(json.contains("\"hourlyPayRate\": 20.0"));
    }
}