package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service.impl;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.request.PublisherRequest;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response.AddressResponse;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response.PublisherResponse;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.model.Address;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.model.Publisher;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.repository.PublisherRepository;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

//    @Autowired
    private PublisherRepository publisherRepository;

//    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<PublisherResponse> getPublishers() {
        return publisherRepository.findAll()
                .stream()
                .map(p -> new PublisherResponse(
                        p.getPublisherId(),
                        p.getName(),
                        new AddressResponse(
                                p.getPrimaryAddress().getAddressId(),
                                p.getPrimaryAddress().getStreet(),
                                p.getPrimaryAddress().getCity(),
                                p.getPrimaryAddress().getState(),
                                p.getPrimaryAddress().getZipCode()
                        )
                )).toList();
    }

    @Override
    public PublisherResponse createNewPublisher(PublisherRequest newPublisherRequest) {
        var newPublisher = new Publisher(null,
                newPublisherRequest.name(),
                new Address(newPublisherRequest.primaryAddress().street(),
                        newPublisherRequest.primaryAddress().city(),
                        newPublisherRequest.primaryAddress().state(),
                        newPublisherRequest.primaryAddress().zipCode()));
        var savedPublisher = publisherRepository.save(newPublisher);
        return new PublisherResponse(
                savedPublisher.getPublisherId(),
                savedPublisher.getName(),
                new AddressResponse(
                        savedPublisher.getPrimaryAddress().getAddressId(),
                        savedPublisher.getPrimaryAddress().getStreet(),
                        savedPublisher.getPrimaryAddress().getCity(),
                        savedPublisher.getPrimaryAddress().getState(),
                        savedPublisher.getPrimaryAddress().getZipCode()
                )
        );
    }
}
