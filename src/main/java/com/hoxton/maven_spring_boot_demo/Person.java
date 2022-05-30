package com.hoxton.maven_spring_boot_demo;

public class Person {
  public String firstName;
  public String lastName;
  public Integer yearOfBirth;

  public static Person createPerson(String firstName, String lastName, Integer yearOfBirth) {
    Person person = new Person();

    person.firstName = firstName;
    person.lastName = lastName;
    person.yearOfBirth = yearOfBirth;

    return person;
  }
}
