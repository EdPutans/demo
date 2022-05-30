package com.hoxton.maven_spring_boot_demo;

import java.util.ArrayList;
import java.util.List;

public class Quote {
  public static List<Quote> allQuotes = new ArrayList<Quote>();

  public Integer id;
  public Person quotee;
  public String quote;

  static {
    createQuote("Make memes, not war!", "Mark", "Twain", 1893);
    createQuote("Stop making quotes I never said!", "Albert", "Einstein", 1482);
    createQuote("Some relationships in life are one to many, and thats okay", "Nicolas", "Marcora", 2021);
  }

  public Quote() {
    super();
  }

  public static List<Quote> getAllQuotes() {
    return allQuotes;
  }

  public static Quote createQuote(String quote, String firstName, String lastName, Integer yearofBirth) {
    Quote newQuote = new Quote();
    newQuote.quote = quote;
    newQuote.id = generateNewId();
    newQuote.quotee = Person.createPerson(firstName, lastName, yearofBirth);
    allQuotes.add(newQuote);

    return newQuote;
  }

  public static Quote getQuoteById(Integer id) {
    for (Quote quote : allQuotes) {
      if (quote.id == id)
        return quote;
    }

    return null;
  }

  public static Quote updateQuote(Integer id, String quote, String firstName, String lastName, Integer yearOfBirth) {
    Quote foundQuote = getQuoteById(id);
    if (foundQuote == null)
      return null;

    if (firstName != null)
      foundQuote.quotee.firstName = firstName;
    if (lastName != null)
      foundQuote.quotee.lastName = lastName;
    if (yearOfBirth != null)
      foundQuote.quotee.yearOfBirth = yearOfBirth;
    if (quote != null)
      foundQuote.quote = quote;

    return foundQuote;
  }

  public static Boolean deleteQuote(Integer id) {
    Quote quoteToDelete = Quote.getQuoteById(id);
    if (quoteToDelete == null)
      return false;

    Quote.getAllQuotes().remove(quoteToDelete);
    return true;
  }

  @Override
  public String toString() {
    return "Name: " + this.quotee.firstName + " " + this.quotee.lastName + ", " + this.quotee.yearOfBirth + ", Quote: "
        + quote + ", Id: " + id;
  }

  public static Integer findLargestQuoteId() {
    Integer largestId = 0;

    for (Quote quote : allQuotes) {
      if (quote.id > largestId)
        largestId = quote.id;
    }
    return largestId;
  }

  public static Integer generateNewId() {
    return findLargestQuoteId() + 1;
  }
}
