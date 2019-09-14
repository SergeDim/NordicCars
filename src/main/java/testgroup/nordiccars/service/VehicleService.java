package testgroup.nordiccars.service;

import java.util.List;

import testgroup.nordiccars.model.Car;

public interface VehicleService
{
    List<Car> allCars();
    void add(Car car);
    void delete(Car car);
    void edit(Car car);
    Car getById(String id);
	void ping(Car car);
}
