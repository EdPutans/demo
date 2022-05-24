package com.hoxton.maven_spring_boot_demo;

import java.util.ArrayList;

public class Person {
  public String name;
  public Integer age;
  public ArrayList<Quote> quotes = new ArrayList<Quote>();

  public static ArrayList<Person> people = new ArrayList<Person>();

  static {
    Person John = new Person("John", 30);
    Person Steve = new Person("Steve", 20);

    Quote.createQuote("Make memes, not war!" , "Mark Twain", John);
    Quote.createQuote("Stop making quotes I never said!" , "Albert Einstein", John);
    Quote.createQuote("Some relationships in life are one to many, and thats okay" , "Nicolas Marcora", John);
  }

  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
    this.quotes = new ArrayList<Quote>();

    people.add(this);
  }

  public void addQuote(Quote quote, Person person) {
    person.quotes.add(quote);
  }

  public static ArrayList<Person> getAllPersonsAndQuotes(){
    return people;
  }
}
