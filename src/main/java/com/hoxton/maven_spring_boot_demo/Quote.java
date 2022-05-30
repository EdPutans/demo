package com.hoxton.maven_spring_boot_demo;

import java.util.ArrayList;
import java.util.List;

import com.hoxton.maven_spring_boot_demo.helpers.api.QuoteWithPerson;
import com.hoxton.maven_spring_boot_demo.helpers.api.QuoteWithPersonRequestBody;

public class Quote {
  // list of all quotes

  public Integer id;
  public String quote;

  static {
    new Person("Steve", 20);

    Person John = new Person("John", 30);
    Quote.createQuote("Make memes, not war!", "Mark Twain", John);
    Quote.createQuote("Stop making quotes I never said!", "Albert Einstein", John);
    Quote.createQuote("Some relationships in life are one to many, and thats okay", "Nicolas Marcora", John);
  }

  public Quote() {
    super();
  }

  public static Quote createQuote(String name, String quote, Person person) {
    Quote newQuote = new Quote();
    newQuote.quote = quote;
    newQuote.id = generateNewId();

    person.quotes.add(newQuote);

    return newQuote;
  }

  public static Quote getQuoteById(Integer id) {
    for (Quote quote : Person.getAllQuotesEver()) {
      if (quote.id == id)
        return quote;
    }

    return null;
  }

  public static Quote updateQuote(Integer id, QuoteWithPersonRequestBody quote) {
    Quote foundQuote = getQuoteById(id);

    if (foundQuote == null)
      return null;

    if (quote.quote != null)
      foundQuote.quote = quote.quote;
    if (quote.name != null) {
      Person foundPerson = Person.getPersonByName(quote.name);
      foundPerson.name = quote.name;
    }

    return foundQuote;
  }

  public static Boolean deleteQuote(Integer id) {
    Quote quoteToDelete = Quote.getQuoteById(id);
    if (quoteToDelete == null)
      return false;

    Person.getAllQuotesEver().remove(quoteToDelete);
    return true;
  }

  @Override
  public String toString() {
    return "Name: " + this.getQuotee().name + ", Quote: " + quote + ", Id: " + id;
  }

  public static Integer findLargestQuoteId() {
    Integer largestId = 0;

    for (Quote quote : Person.getAllQuotesEver()) {
      if (quote.id > largestId)
        largestId = quote.id;
    }
    return largestId;
  }

  public Person getQuotee() {
    return Person.getPersonByQuoteId(this.id);
  }

  private static Integer generateNewId() {
    return findLargestQuoteId() + 1;
  }

  public String getBigPeepee() {
    return "Big";
  }

  public Person getQuotee(Integer quoteId) {
    // public static Person getPersonByQuoteId(Integer quoteId) {
    for (Person person : Person.people) {
      for (Quote quote : person.quotes) {
        if (quote.id == quoteId)
          return person;
      }
    }
    return null;
  }

  public static ArrayList<Quote> getAllQuotesWithPerson() {
    ArrayList<Quote> allQuotes = new ArrayList<Quote>();

    for (Quote quote : Person.getAllQuotesEver()) {
      // QuoteWithPerson quoteWithPerson = new QuoteWithPerson();
      // quoteWithPerson.quote = quote.quote;

      quote.getQuotee();
      quote.getBigPeepee();
      // quoteWithPerson.quotee = new Person(person.name, person.age);
      // quoteWithPerson.quotee.name = person.name;
      // quoteWithPerson.quotee.age = person.age;

      allQuotes.add(quote);
    }
    return allQuotes;
  }

  /**
   * THIS DONT WORK
   * public static ArrayList<QuoteWithPerson> getAllQuotesWithPerson() {
   * ArrayList<QuoteWithPerson> allQuotesWithPerson = new
   * ArrayList<QuoteWithPerson>();
   * 
   * for (Quote quote : allQuotes) {
   * QuoteWithPerson quoteWithPerson = new QuoteWithPerson();
   * 
   * quoteWithPerson.quote = quote.quote;
   * quoteWithPerson.quotee = quote.getWhoQuoteBelongsTo();
   * 
   * allQuotesWithPerson.add(quoteWithPerson);
   * }
   * return allQuotesWithPerson;
   * }
   */
}
