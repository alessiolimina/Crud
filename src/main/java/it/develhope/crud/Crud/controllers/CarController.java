package it.develhope.crud.Crud.controllers;

import it.develhope.crud.Crud.entities.Car;
import it.develhope.crud.Crud.repositories.CarRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/")
    public Car createCar(@RequestBody Car car) {
        Car newCar = carRepository.saveAndFlush(car);
        return newCar;
    }

    @GetMapping("/")
    public List<Car> getAllCars() {
        List<Car> allCars = carRepository.findAll();
        return allCars;
    }

    @GetMapping("/{id}")
    public Car getSingleCar(@PathVariable long id) {
        if (carRepository.existsById(id)) {
            Car car = carRepository.getReferenceById(id);
            return car;
        } else {
            Car car = new Car();
            return car;
        }
    }

    @PutMapping("/{id}")
    public Car updateCarType(@PathVariable long id, @RequestParam String type) {
        if (carRepository.existsById(id)) {
            Car car = carRepository.getReferenceById(id);
            car.setType(type);
            car = carRepository.saveAndFlush(car);
            return car;
        } else {
            Car car = new Car();
            return car;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteOneCar(@PathVariable long id, HttpServletResponse response){
        if(carRepository.existsById(id)){
            carRepository.deleteById(id);
        } else {
            response.setStatus(409);
        }
    }

    @DeleteMapping("/")
    public void deleteAllCars(){
        carRepository.deleteAll();
    }
}
//todo try API calls using Postman