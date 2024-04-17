package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.repository;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.model.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepository extends ListCrudRepository<Address, Integer> {
}
