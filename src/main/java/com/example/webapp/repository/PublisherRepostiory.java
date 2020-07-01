package com.example.webapp.repository;

import com.example.webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepostiory extends CrudRepository<Publisher,Long> {
}
