package com.hoxton.maven_spring_boot_demo;

import java.util.ArrayList;

import com.hoxton.maven_spring_boot_demo.helpers.api.QuoteWithPerson;

public class Person {
  public String name;
  public Integer age;
  public ArrayList<Quote> quotes = new ArrayList<Quote>();

  public static ArrayList<Person> people = new ArrayList<Person>();

  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
    this.quotes = new ArrayList<Quote>();

    people.add(this);
  }

  public void addQuote(Quote quote, Person person) {
    person.quotes.add(quote);
  }

  public static Person getPersonByName(String name) {
    for (Person person : people) {
      if (person.name == name)
        return person;
    }

    return null;
  }

  public static Person getPersonByQuoteId(Integer id) {
    for (Person person : people) {
      for (Quote quote : person.quotes) {
        if (quote.id == id) {

          // return { name: person.name, age: person.age };
        }
      }
    }

    return null;
  }

  public static ArrayList<QuoteWithPerson> getAllQuotesEver() {
    ArrayList<QuoteWithPerson> allQuotes = new ArrayList<QuoteWithPerson>();
    for (Person person : people) {
      for (Quote quote : person.quotes) {
        QuoteWithPerson sanitizedQuote = new QuoteWithPerson();
        sanitizedQuote.id = quote.id;
        sanitizedQuote.quote = quote.quote;
        sanitizedQuote.quotee = person;

        allQuotes.add(sanitizedQuote);
      }
    }
    return allQuotes;
  }

  public static ArrayList<Person> getAllPersonsAndQuotes() {
    return people;
  }
}
