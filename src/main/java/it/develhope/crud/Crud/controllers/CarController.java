package it.develhope.crud.Crud.controllers;

import it.develhope.crud.Crud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CarController {

    @Autowired
    private CarRepository carRepository;
}
