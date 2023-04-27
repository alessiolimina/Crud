package it.develhope.crud.Crud.controllers;

import it.develhope.crud.Crud.entities.Car;
import it.develhope.crud.Crud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/")
    public Car createCar(@RequestBody Car car){
        Car newCar = carRepository.saveAndFlush(car);
        return newCar;
    }

    @GetMapping("/")
    public List<Car> getAllCars(){
        List<Car> allCars = carRepository.findAll();
        return allCars;
    }
}
