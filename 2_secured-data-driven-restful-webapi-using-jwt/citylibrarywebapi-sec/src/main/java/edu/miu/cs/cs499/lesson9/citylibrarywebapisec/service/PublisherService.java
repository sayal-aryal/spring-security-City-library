package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.request.PublisherRequest;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response.PublisherResponse;

import java.util.List;

public interface PublisherService {

    public abstract List<PublisherResponse> getPublishers();
    PublisherResponse createNewPublisher(PublisherRequest newPublisherRequest);
}
