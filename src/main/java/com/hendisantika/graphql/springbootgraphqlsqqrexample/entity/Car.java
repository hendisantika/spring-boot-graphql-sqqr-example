package com.hendisantika.graphql.springbootgraphqlsqqrexample.entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-graphql-sqqr-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2018-12-08
 * Time: 05:57
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Car {
    @Id
    @GeneratedValue
    @GraphQLQuery(name = "id", description = "A car's id")
    private Long id;

    @GraphQLQuery(name = "name", description = "A car's name")
    private @NonNull String name;
}