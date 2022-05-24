package com.hoxton.maven_spring_boot_demo;

import java.util.ArrayList;
import java.util.List;

public class Quote {
  public static List<Quote> allQuotes = new ArrayList<Quote>();

  public Integer id;
  public String name;
  public String quote;


  public Quote() {
    super();
  }

  public static List<Quote> getAllQuotes() {
    return allQuotes;
  }
  
  public static Quote createQuote(String name, String quote, Person person){
    Quote newQuote = new Quote();

    newQuote.name = person.name;
    newQuote.quote = quote;
    
    newQuote.id = generateNewId();
    allQuotes.add(newQuote);

    person.quotes.add(newQuote);

    return newQuote;
  }

  public static Quote getQuoteById(Integer id){
    for(Quote quote : allQuotes){
      if(quote.id == id) return quote;
    }

    return null;
  }

  public static Quote updateQuote(Integer id, Quote quote){
    Quote foundQuote = getQuoteById(id);
    if(foundQuote == null) return null;
    
    if(quote.name != null) foundQuote.name = quote.name;
    if(quote.quote != null)foundQuote.quote = quote.quote;

    return foundQuote;
  }

  public static Boolean deleteQuote(Integer id) {
    Quote quoteToDelete = Quote.getQuoteById(id);
   if(quoteToDelete == null) return false;

    Quote.getAllQuotes().remove(quoteToDelete);
    return true;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", Quote: " + quote + ", Id: " + id;
  }

  public static Integer findLargestQuoteId(){
    Integer largestId = 0;
    
    for(Quote quote : allQuotes){
      if(quote.id > largestId) largestId = quote.id;
    }
    return largestId;
  }

  public static Integer generateNewId(){
    return findLargestQuoteId() + 1;
  }
}
