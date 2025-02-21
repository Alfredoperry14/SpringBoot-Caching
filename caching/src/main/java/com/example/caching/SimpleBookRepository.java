package com.example.caching;


import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.Cacheable;

@Component
public class SimpleBookRepository implements BookRepository{
    
    @Override
    @Cacheable("Books")
    public Book getByIsbn(String isbn){
        simulateSlowService();
        return new Book(isbn, "Some Book");
        
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
