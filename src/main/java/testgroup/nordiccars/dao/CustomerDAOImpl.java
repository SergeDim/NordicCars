package testgroup.nordiccars.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import testgroup.nordiccars.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
	private static Map<Integer, Customer> customers = new HashMap<>();

    static {
    	Object[] arrCustomers[]={
    	  {0, "Kalles Grustransporter AB", "Cementvaegen 8, 111 11, Soedertaelje"},
    	  {1, "Jonas Bulk AB", "Balkvaegen 12, 222 22, Stockholm"},
    	  {2, "Haralds Vaerdertransporter AB", "Budgetvaegen 1, 333 33, Uppsala"}
    	};
    	for (Object[] custData : arrCustomers) {
    		Customer customer = new Customer((Integer)custData[0], (String)custData[1], (String)custData[2]);
            customers.put(customer.getId(), customer);
		}
    }
    // DEBUG-INIT
	public static Customer getCustomer(Integer id) {
		return customers.get(id);
	}

	@Override
	public List<Customer> allCustomers() {
        return new ArrayList<>(customers.values());
	}

	@Override
	public Customer getById(int id) {
        return customers.get(id);
	}
	// -- NOT INTERFACED --
    //@Override
    public void add(Customer cust) {
        customers.put(cust.getId(), cust);
    }

    //@Override
    public void delete(Customer cust) {
    	customers.remove(cust.getId());
    }

    //@Override
    public void edit(Customer cust) {
    	customers.put(cust.getId(), cust);
    }
}
