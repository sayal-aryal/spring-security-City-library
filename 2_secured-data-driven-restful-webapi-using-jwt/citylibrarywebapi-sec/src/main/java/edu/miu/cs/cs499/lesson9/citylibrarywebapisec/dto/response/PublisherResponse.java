package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response;

public record PublisherResponse(
        Integer publisherId,
        String name,
        AddressResponse primaryAddress) {
}
