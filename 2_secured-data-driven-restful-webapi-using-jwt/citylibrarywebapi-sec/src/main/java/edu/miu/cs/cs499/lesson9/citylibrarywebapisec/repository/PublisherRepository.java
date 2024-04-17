package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.repository;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.model.Publisher;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

//@Repository
public interface PublisherRepository extends ListCrudRepository<Publisher, Integer> {

    public List<Publisher> findPublishersByNameContaining(String param);
    public Publisher getPublisherByNameEndingWith(String end);
}
