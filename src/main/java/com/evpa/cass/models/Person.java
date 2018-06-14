package com.evpa.cass.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.UUID;

@Table
@Data
@AllArgsConstructor
public class Person {
    @PrimaryKey()
    private String id;

    private String name;
    private int age;

    public Person withId() {
        this.id = UUID.randomUUID().toString();
        return this;
    }
}
