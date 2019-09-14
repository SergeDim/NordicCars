package testgroup.nordiccars.dao;

import java.util.List;

import testgroup.nordiccars.model.Customer;

public interface CustomerDAO
{
    List<Customer> allCustomers();
    Customer getById(int id);
}
