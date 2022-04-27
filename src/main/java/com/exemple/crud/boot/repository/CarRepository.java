package com.exemple.crud.boot.repository;

import com.exemple.crud.boot.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
