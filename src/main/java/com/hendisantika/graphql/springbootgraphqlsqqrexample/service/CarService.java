package com.hendisantika.graphql.springbootgraphqlsqqrexample.service;

import com.hendisantika.graphql.springbootgraphqlsqqrexample.entity.Car;
import com.hendisantika.graphql.springbootgraphqlsqqrexample.repository.CarRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
public class CarService {

    private final CarRepository carRepository;
    private final GiphyService giphyService;

    public CarService(CarRepository carRepository, GiphyService giphyService) {
        this.carRepository = carRepository;
        this.giphyService = giphyService;
    }

    @GraphQLQuery(name = "cars")
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GraphQLQuery(name = "car")
    public Optional<Car> getCarById(@GraphQLArgument(name = "id") Long id) {
        return carRepository.findById(id);
    }

    @GraphQLMutation(name = "saveCar")
    public Car saveCar(@GraphQLArgument(name = "car") Car car) {
        return carRepository.save(car);
    }

    @GraphQLMutation(name = "deleteCar")
    public void deleteCar(@GraphQLArgument(name = "id") Long id) {
        carRepository.deleteById(id);
    }

    @GraphQLQuery(name = "isCool")
    public boolean isCool(@GraphQLContext Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }

    @GraphQLQuery(name = "giphyUrl")
    public String getGiphyUrl(@GraphQLContext Car car) {
        return giphyService.getGiphyUrl(car.getName());
    }

    @GraphQLQuery
    public Pageable page(@GraphQLArgument(name = "paging") Pageable page) {
        return page;
    }
}