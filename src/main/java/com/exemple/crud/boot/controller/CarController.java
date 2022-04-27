package com.exemple.crud.boot.controller;

import com.exemple.crud.boot.domain.Car;
import com.exemple.crud.boot.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {

    CarRepository carRepository;

    @GetMapping("/car")
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        return carRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/car")
    @ResponseStatus(HttpStatus.CREATED)
    public Car saveCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @PutMapping("car/{id}")
    public  ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car){
        if(!carRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        car.setId(id);
        car = carRepository.save(car);
        return ResponseEntity.ok(car);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
        if(!carRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
