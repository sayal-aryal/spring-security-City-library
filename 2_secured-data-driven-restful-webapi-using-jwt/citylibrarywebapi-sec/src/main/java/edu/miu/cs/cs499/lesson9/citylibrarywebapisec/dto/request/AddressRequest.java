package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.request;

public record AddressRequest(
        String street,
        String city,
        String state,
        String zipCode
) {
}
