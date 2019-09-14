package testgroup.nordiccars.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import testgroup.nordiccars.model.Car;
import testgroup.nordiccars.model.Customer;

@Repository
public class CarDAOImpl implements CarDAO
{
    private static Map<String, Car> cars = new HashMap<>();

    static {
    	Object[] arrCars[]={
    	  {"YS2R4X20005399401", "ABC123", 0},
    	  {"VLUR4X20009093588", "DEF456", 0},
    	  {"VLUR4X20009048066", "GHI789", 0},
    	  
    	  {"YS2R4X20005388011", "JKL012", 1},
    	  {"YS2R4X20005387949", "MNO345", 1},

    	  {"VLUR4X20009048066", "PQR678", 2},
    	  {"YS2R4X20005387055", "STU901", 2}   	 
    	};
    	for (Object[] carData : arrCars) {
    		Customer customer = CustomerDAOImpl.getCustomer((Integer)carData[2]);
            Car car = new Car((String)carData[0], (String)carData[1], customer);
            cars.put(car.getVin(), car);
		}
    }
    @Override
    public List<Car> allCars() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public void add(Car car) {
        cars.put(car.getVin(), car);
    }

    @Override
    public void delete(Car car) {
    	cars.remove(car.getVin());
    }

    @Override
    public void edit(Car car) {
    	cars.put(car.getVin(), car);
    }

    @Override
    public Car getById(String id) {
        return cars.get(id);
    }
}
