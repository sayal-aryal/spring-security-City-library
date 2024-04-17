package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response;

public record AddressResponse2(
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode,
        PublisherResponse2 publisher
) {
}
