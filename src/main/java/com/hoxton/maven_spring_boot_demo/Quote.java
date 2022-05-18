package com.hoxton.maven_spring_boot_demo;

import java.util.ArrayList;
import java.util.List;

public class Quote {
  public static List<Quote> allQuotes = new ArrayList<Quote>();

  public String name;
  public String quote;

  static {
    createQuote("Make memes, not war!" , "Mark Twain");
    createQuote("Stop making quotes I never said!" , "Albert Einstein");
    createQuote("Some relationships in life are one to many, and thats okay" , "Nicolas Marcora");
  }

  public Quote() {
    super();
  }

  public static List<Quote> getAllQuotes() {
    return allQuotes;
  }
  public static Quote createQuote(String name, String quote){
    Quote newQuote = new Quote();
    newQuote.name = name;
    newQuote.quote = quote;
    // bonus
    newQuote.id = generateNewId();

    allQuotes.add(newQuote);
    return newQuote;
  }

  // bonus
  public Integer id;
  public static Integer findLargestQuoteId(){
    Integer largestId = 0;
    
    for(Quote quote : allQuotes){
      if(quote.id > largestId){
        largestId = quote.id;
      }
    }
    return largestId;
  }

  public static Integer generateNewId(){
    return findLargestQuoteId() + 1;
  }
}
