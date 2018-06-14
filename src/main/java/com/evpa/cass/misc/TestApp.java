package com.evpa.cass.misc;

import com.evpa.cass.util.OptionalUtility;

import java.util.Optional;

public class TestApp {
    public static void main(String[] args) {
        Car car = new Car();
        //Car car = null;
        Insurance insurance = new Insurance();
        insurance.setName("AFI");

        Person person = new Person();
        person.setAge(25);
        //Optional<Car> optionalCar = Optional.empty();
        //Optional<Car> optionalCar = Optional.of(car);
        Optional<Car> optionalCar = Optional.ofNullable(car);
        person.setCar(optionalCar);

        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        car.setInsurance(optionalInsurance);

        optionalInsurance.filter(insur -> "AFI".equals(insur.getName()))
            .ifPresent(x -> System.out.println("line 21: " + x.getName()));

        //car.setInsurance(optionalInsurance);
        System.out.println(optionalCar.orElse(new Car().withColor("Silver")));
        Optional<String> insuranceName = optionalInsurance.map(Insurance::getName);

        System.out.println(person.getCar() + " : " + insuranceName);

        Optional<Person> optionalPerson = Optional.of(person);
        Optional<String> name = optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                ;

        System.out.println(name);
        System.out.println(getCarInsuranceName(optionalPerson));
        System.out.println(getCarInsuranceName(optionalPerson,21));

        Integer integer = OptionalUtility.stringToInt("23").orElse(0);
        System.out.println("integer:" + integer);
    }

    public static String getCarInsuranceName(Optional<Person> optionalPerson, int minAge) {
        return optionalPerson.filter(person -> person.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    private static String getCarInsuranceName(Optional<Person> optionalPerson) {
        return optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
