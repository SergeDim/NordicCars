package testgroup.nordiccars.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.*;

import testgroup.nordiccars.model.Car;

public class CarPingTest
{
    private Car vehicle;
    
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before CarPingTest.class");
    }
 
    @AfterClass
    public  static void afterClass() {
        System.out.println("After CarPingTest.class");
    }
 
    @Before
    public void initTest() {
        vehicle = new Car("VOLVOTESTVIN", "STLM8888", null);
    }
 
    @After
    public void afterTest() {
        vehicle = null;
    }
 
    @Test
    public void testSetLastPing() throws Exception
    {
    	Date dt = new Date();
    	vehicle.setLastPing(dt);
        assertEquals(vehicle.getLastPing(), dt);
    }
    
    @Test
    public void testIsConnectedNoPing() throws Exception
    {
    	Date dt = null;
    	vehicle.setLastPing(dt);
        assertFalse(vehicle.isConnected());
    }
    
    @Test
    public void testIsConnectedTrue() throws Exception
    {
    	Date dt = new Date();
    	vehicle.setLastPing(dt);
        assertTrue(vehicle.isConnected());
    }
    
    @Test
    public void testTimeIsOut() throws Exception
    {
    	Date dt = new Date(System.currentTimeMillis() - (vehicle.getValidTimeout()+1));
    	vehicle.setLastPing(dt);
        assertFalse(vehicle.isConnected());
    }
}
