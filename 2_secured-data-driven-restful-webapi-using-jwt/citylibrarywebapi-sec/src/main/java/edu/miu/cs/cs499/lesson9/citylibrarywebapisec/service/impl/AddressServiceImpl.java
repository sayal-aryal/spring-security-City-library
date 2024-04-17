package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service.impl;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response.AddressResponse2;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response.PublisherResponse2;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressResponse2> getAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(a -> new AddressResponse2(
                        a.getAddressId(),
                        a.getStreet(), a.getCity(), a.getState(),
                        a.getZipCode(), new PublisherResponse2(
                                a.getPublisher().getPublisherId(),
                                a.getPublisher().getName()
                )
                )).toList();
    }

}
