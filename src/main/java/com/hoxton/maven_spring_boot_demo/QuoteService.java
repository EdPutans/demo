package com.hoxton.maven_spring_boot_demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
  @Autowired
  private QuoteRepository quoteRepo;

  public Collection<Quote> readMarksFreakingQuotes() {
    return quoteRepo.findMarkFreakingTwainQuotes();
}
}
