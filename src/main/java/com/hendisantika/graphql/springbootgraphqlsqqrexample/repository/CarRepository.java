package com.hendisantika.graphql.springbootgraphqlsqqrexample.repository;

import com.hendisantika.graphql.springbootgraphqlsqqrexample.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-graphql-sqqr-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2018-12-08
 * Time: 05:58
 * To change this template use File | Settings | File Templates.
 */
@Repository
interface CarRepository extends JpaRepository<Car, Long> {
}
