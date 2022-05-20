package com.hoxton.maven_spring_boot_demo;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.core.style.ToStringCreator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
  
  @RequestMapping(value ="/quotes", method = RequestMethod.GET)
  public List<Quote> getQuotes() {
    return Quote.getAllQuotes();
  }

  @RequestMapping(value="/quotes", method = RequestMethod.POST)
    public Quote addQuote(@RequestBody Quote quote) {

    return Quote.createQuote(quote.name, quote.quote);
  }
  
  @GetMapping(value="/quotes/{id}") 
  public Quote getQuoteById(@PathVariable("id") String id) {
    Integer idInt = Integer.parseInt(id);

    Quote quote = Quote.getQuoteById(idInt);
    System.out.print(quote.toString()); // hope you didnt fucking forget to BUILD A CLASS OVERRIDE, JUST TO LOG A FUCKING VARIABLE!??

    return quote;
  }
}
