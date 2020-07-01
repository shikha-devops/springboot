package com.example.webapp.bootstrap;

import com.example.webapp.domain.Author;
import com.example.webapp.domain.Book;
import com.example.webapp.domain.Publisher;
import com.example.webapp.repository.AuthorRepository;
import com.example.webapp.repository.BookRepository;
import com.example.webapp.repository.PublisherRepostiory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepostiory publisherRepostiory;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepostiory publisherRepostiory) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepostiory = publisherRepostiory;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Shikha", "Sahu");
        Book ddd = new Book("Domain Design ","ismn");
        Publisher publisher = new Publisher();
        publisher.setName("Shikha");
        publisher.setAddressLine1("Wakad");
        publisher.setCity("Pune");
        publisher.setState("Mah");
        publisher.setZip("411057");
         publisherRepostiory.save(publisher);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepostiory.save(publisher);


        System.out.println("Publisher"+publisherRepostiory.count());

        Author rod = new Author("Pratyush","Sarbere");
        Book noEJB = new Book("J2EE","12333");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepostiory.save(publisher);
        System.out.println("Start spring boot");
        System.out.println("no of book"+bookRepository.count());
        System.out.println("no of book"+publisher.getBooks().size());



    }
}
