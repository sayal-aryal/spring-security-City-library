package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.controller;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.request.PublisherRequest;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response.PublisherResponse;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/citylibrary/api/v1/publisher"})
public class PublisherController {
    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<PublisherResponse>> listPublishers() {
        return ResponseEntity.ok(publisherService.getPublishers());
    }

    @PostMapping(value = {"/new"})
    public ResponseEntity<PublisherResponse> addNewPublisher(@Valid @RequestBody PublisherRequest publisherRequest) {
        return new ResponseEntity<>(publisherService.createNewPublisher(publisherRequest),
                HttpStatus.CREATED);
    }

}
