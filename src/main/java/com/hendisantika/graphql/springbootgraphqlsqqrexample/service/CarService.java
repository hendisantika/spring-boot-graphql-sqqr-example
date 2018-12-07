package com.hendisantika.graphql.springbootgraphqlsqqrexample.service;

import com.hendisantika.graphql.springbootgraphqlsqqrexample.entity.Car;
import com.hendisantika.graphql.springbootgraphqlsqqrexample.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-graphql-sqqr-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2018-12-08
 * Time: 05:59
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}