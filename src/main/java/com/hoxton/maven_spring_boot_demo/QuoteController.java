package com.hoxton.maven_spring_boot_demo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
  
  @RequestMapping(value ="/quotes", method = RequestMethod.GET)
  public  List<Quote> getQuotes() {
    return Quote.getAllQuotes();
  }
}
