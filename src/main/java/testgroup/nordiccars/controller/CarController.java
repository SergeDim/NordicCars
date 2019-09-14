package testgroup.nordiccars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import testgroup.nordiccars.model.Car;
import testgroup.nordiccars.service.VehicleService;

@Controller
public class CarController
{
	// -- @Autowired - choose a proper Intf implementation from available ones
    @Autowired
    private VehicleService carService;
    
    // ---- MAIN VIEW ----
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allCars() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cars");
        
        List<Car> cars = carService.allCars();
        modelAndView.addObject("carsList", cars);
        
        return modelAndView;
    }

    // ---- data table ----
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ModelAndView allCarsData() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("carsData");
        
        List<Car> cars = carService.allCars();
        modelAndView.addObject("carsList", cars);
        
        return modelAndView;
    }
    
    // ---- SIMULATOR ----
    @RequestMapping(value = "/onroad", method = RequestMethod.GET)
    public ModelAndView allCarsOnRoad() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("simulator");
        return modelAndView;
    }
    
    // ---- PING ----
    @RequestMapping(value="/ping/{id}", method = RequestMethod.GET)
    public ModelAndView pingCar(@PathVariable("id") String id)
    {
        ModelAndView modelAndView = new ModelAndView();
        Car car = carService.getById(id);
        if (car!=null){
        	System.out.println("PingCar: "+id);
        	carService.ping(car);
        }
        modelAndView.setViewName("carPing");
        modelAndView.addObject("car", car);
        return modelAndView;
    }
    
/*
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") String id)
    {
    	Car car = carService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("car", car);
        return modelAndView;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editCar(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:");
        carService.edit(car);
        return modelAndView;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCar(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:");
        carService.add(car);
        return modelAndView;
    }
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCar(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Car car = carService.getById(id);
        carService.delete(car);
        return modelAndView;
    }
    
 */
}
