package com.hoxton.maven_spring_boot_demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class QuoteController {
  
  @RequestMapping(value ="", method = RequestMethod.GET)
  public ResponseEntity<List<Quote>> getQuotes() {
    return ResponseEntity
    .status(HttpStatus.OK)                 
      .body(Quote.getAllQuotes());
  }

  @PostMapping(value="")
    public ResponseEntity<Quote> addQuote(@RequestBody Quote quote) {

    Quote createdQuote = Quote.createQuote(quote.name, quote.quote);

    return ResponseEntity
    .status(HttpStatus.OK)                 
      .body(createdQuote);
  }
  
  @GetMapping(value="/{id}") 
  public ResponseEntity<?> getQuoteById(@PathVariable("id") String id) {
    Integer idInt = Integer.parseInt(id);

    Quote quote = Quote.getQuoteById(idInt);
    if(quote == null) return QuoteError.create("Quote not found", HttpStatus.NOT_FOUND);

    return ResponseEntity
        .status(HttpStatus.OK)                 
          .body(quote);
  }

  @PatchMapping(value="/{id}")
  public ResponseEntity<?> updateQuote(@PathVariable("id") String id, @RequestBody Quote quote) {
    Integer idInt = Integer.parseInt(id);
    Quote updatedQuote = Quote.updateQuote(idInt, quote);

    if(updatedQuote == null) return QuoteError.create("Quote not found", HttpStatus.NOT_FOUND);

    return ResponseEntity
      .status(HttpStatus.OK)                 
        .body(updatedQuote);
  }

  @DeleteMapping(value="/{id}")
  public ResponseEntity<?> deleteQuote(@PathVariable("id") String id) {
    Integer idInt = Integer.parseInt(id);

    Boolean successfullyDeletedQuote = Quote.deleteQuote(idInt);
    if(!successfullyDeletedQuote) 
      return QuoteError.create("Quote not found", HttpStatus.NOT_FOUND);
    
    return ResponseEntity
      .status(HttpStatus.OK)                 
        .body("Quote with id " + id + " deleted!");
  }
}