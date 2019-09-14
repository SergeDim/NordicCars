package testgroup.nordiccars.integration;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.junit.experimental.categories.Category;

import testgroup.nordiccars.model.Car;
import testgroup.nordiccars.service.VechicleServiceImpl;
import testgroup.nordiccars.service.VehicleService;

@Category(IntegrationTest.class)
public class CarIntegrationTest
{
	private String vin = "VOLVOINTEGRATIONVIN";
	private VehicleService service;
    private Car vehicle;
    
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before CarIntegrationTest.class");
    }
 
    @AfterClass
    public  static void afterClass() {
        System.out.println("After CarIntegrationTest.class");
    }
 
    @Before
    public void initTest() {
    	service = new VechicleServiceImpl(true);
        vehicle = new Car(vin, "STLM4444", null);
    }
 
    @After
    public void afterTest() {
    	service = null;
        vehicle = null;
    }
 
    //@Test
    public void sampleIntegrationTest() {
        System.out.println("--> CarIntegrationTest::sampleIntegrationTest");
    }
    
    @Test
    public void testServiceListCars() throws Exception
    {
    	System.out.println("\n  service="+service);
    	service.add(vehicle);
    	System.out.println("  service.add(vehicle) passed");
    	List<Car> cars = service.allCars();
    	boolean b = cars.contains(vehicle);
    	System.out.println("  cars.contains(vehicle)="+b);
    	System.out.println();
        assertTrue(b);
    }
    
    @Test
    public void testServicePing() throws Exception
    {
    	String vin2 = "YS2R4X20005387055";
    	Car car2 = service.getById(vin2);
    	service.ping(car2);
        assertEquals(car2.getStatus(), "Connected");
    }
}
