package testgroup.nordiccars.model;

import java.util.Date;

public class Car
{
	private long valid_timeout = 60*1000; //milliseconds
    private String vin;
    private String regNum;
    private Date lastPing;
    private Customer owner;

    public Car()
    {
    }
    
/*    public Car(String theVin, String theRegNum, Integer custId)
    {
    	vin = theVin;
    	regNum = theRegNum;
    	ownerId = custId;
	}*/
  
    public Car(String theVin, String theRegNum, Customer customer)
    {
    	vin = theVin;
    	regNum = theRegNum;
    	owner = customer;
	}

	// + Getters and setters

	public String getVin() {
		return vin;
	}

	public void setVin(String theVin) {
		vin = theVin;
	}
	
	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String string) {
		regNum = string;
	}

	public Date getLastPing() {
		return lastPing;
	}

	public void setLastPing(Date date) {
		lastPing = date;
		System.out.println("Set LastPing: "+this.toString());
	}

	public boolean isConnected()
	{
		//System.out.println(this.toString());
		
		if (lastPing==null)
		  return false;
		return (new Date().getTime() - lastPing.getTime()) <= valid_timeout;
	}
	
	public int getCustomerId() {
		return owner.getId();
	}
	
	public String getCustomer() {
		return owner.getName();
	}

	public String getStatus() {
		return isConnected()? "Connected" : "Disconnected";
	}
	
	public String toString(){
		return vin+" '"+regNum+"' ("+lastPing+")";
	}

	// milliseconds
	public long getValidTimeout() {
		return valid_timeout;
	}
}
