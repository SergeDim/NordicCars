package testgroup.nordiccars.junit;

import static org.junit.Assert.*;

import org.junit.*;

import testgroup.nordiccars.model.Car;

public class CarNamingTest
{
    private Car vehicle;
    
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before CarNamingTest.class");
    }
 
    @AfterClass
    public  static void afterClass() {
        System.out.println("After CarNamingTest.class");
    }
 
    @Before
    public void initTest() {
        vehicle = new Car();
    }
 
    @After
    public void afterTest() {
        vehicle = null;
    }
 
    @Test
    public void testSetRegNo() throws Exception
    {
    	String s="STLM8888";
    	vehicle.setRegNum(s);
        assertEquals(vehicle.getRegNum(), s);
    }
    
    @Test
    public void testSetVin() throws Exception
    {
    	String s="Vecicle_ID_Number";
    	vehicle.setVin(s);
        assertEquals(vehicle.getVin(), s);
    }
}
