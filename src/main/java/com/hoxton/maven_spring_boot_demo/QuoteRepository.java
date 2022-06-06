package com.hoxton.maven_spring_boot_demo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

  @Query(value = "SELECT * FROM quoterunis q where q.quoteeruni = 'Mark Twain';", nativeQuery = true)
  Collection<Quote> findMarkFreakingTwainQuotes();
}
  
