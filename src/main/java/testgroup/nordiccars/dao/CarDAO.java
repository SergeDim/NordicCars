package testgroup.nordiccars.dao;

import java.util.List;

import testgroup.nordiccars.model.Car;

public interface CarDAO 
{
    List<Car> allCars();
    void add(Car car);
    void delete(Car car);
    void edit(Car car);
    Car getById(String id);
}