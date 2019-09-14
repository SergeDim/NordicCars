package testgroup.nordiccars.model;

public class Customer
{
	int cid;
	String name;
	String address;

    public Customer()
    {
    }
    
    public Customer(Integer custId, String theName, String theAddr)
    {
    	cid = custId;
    	name = theName;
    	address = theAddr;
	}
    
	public String getName() {
		return name;
	}

	public int getId() {
		return cid;
	}
}
