package testgroup.nordiccars.junit;

import static org.junit.Assert.*;

import org.junit.*;

import testgroup.nordiccars.dao.CarDAO;
import testgroup.nordiccars.dao.CarDAOImpl;
import testgroup.nordiccars.model.Car;

public class CarDAOImplTest
{
	private String vin = "VOLVOTESTVIN";
	private CarDAO dao;
    private Car vehicle;
    
    @BeforeClass
    public static void beforeClass() {
        //System.out.println("Before CarDAOImplTest.class");
    }
 
    @AfterClass
    public  static void afterClass() {
        //System.out.println("After CarDAOImplTest.class");
    }
 
    @Before
    public void initTest() {
    	dao = new CarDAOImpl();
        vehicle = new Car(vin, "STLM8888", null);
    }
 
    @After
    public void afterTest() {
    	dao = null;
        vehicle = null;
    }
 
    // Use vin instead of getVin() in order to not depend on getVin() correctness;
    @Test
    public void testCarDAOImplAdd() throws Exception
    {
    	dao.add(vehicle);
        assertEquals(dao.getById(vin), vehicle);
    }
    
    @Test
    public void testCarDAOImplRemove() throws Exception
    {
    	String vin2 = "YS2R4X20005387055";
    	Car car2 = dao.getById(vin2);
    	boolean bExists = car2!=null;
    	dao.delete(car2);
    	boolean bRemove = dao.getById(vin2)==null;
        assertTrue(bExists && bRemove);
    }
}
