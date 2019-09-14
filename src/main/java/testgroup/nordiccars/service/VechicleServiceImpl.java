package testgroup.nordiccars.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testgroup.nordiccars.dao.CarDAO;
import testgroup.nordiccars.dao.CustomerDAO;
import testgroup.nordiccars.model.Car;
import testgroup.nordiccars.model.Customer;

@Service
public class VechicleServiceImpl implements VehicleService
{
	@Autowired
    private CarDAO carDAO;
	
    @Override
    public List<Car> allCars() {
        return carDAO.allCars();
    }

    @Override
    public void add(Car car) {
        carDAO.add(car);
    }

    @Override
    public void delete(Car car) {
        carDAO.delete(car);
    }

    @Override
    public void edit(Car car) {
        carDAO.edit(car);
    }

    @Override
    public Car getById(String id) {
        return carDAO.getById(id);
    }

	@Override
	public void ping(Car car) {
		car.setLastPing(new Date());
	}
}
