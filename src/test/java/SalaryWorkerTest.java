import main.SalaryWorker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {

    @Test
    void testSalaryWorkerWeeklyPay()
    {
        SalaryWorker sw = new SalaryWorker("Carol", "White", "S300", "Ms", 1990, 52000);

        double weeklyPay = sw.calculateWeeklyPay(40); // hours are ignored
        assertEquals(1000.0, weeklyPay, 0.001);
    }

    @Test
    void testSalaryWorkerWeeklyPayDifferentHours()
    {
        SalaryWorker sw = new SalaryWorker("Carol", "White", "S300", "Ms", 1990, 52000);

        double weeklyPay = sw.calculateWeeklyPay(60);
        assertEquals(1000.0, weeklyPay, 0.001);
    }

    @Test
    void testSalaryWorkerToCSV()
    {
        SalaryWorker sw = new SalaryWorker("Carol", "White", "S300", "Ms", 1990, 52000);
        String csv = sw.toCSV();

        assertTrue(csv.contains("52000.0"));
    }

    @Test
    void testSalaryWorkerToXML()
    {
        SalaryWorker sw = new SalaryWorker("Carol", "White", "S300", "Ms", 1990, 52000);
        String xml = sw.toXML();

        assertTrue(xml.contains("<annualSalary>52000.0</annualSalary>"));
    }

    @Test
    void testSalaryWorkerToJSON()
    {
        SalaryWorker sw = new SalaryWorker("Carol", "White", "S300", "Ms", 1990, 52000);
        String json = sw.toJSON();

        assertTrue(json.contains("\"annualSalary\": 52000.0"));
    }
}