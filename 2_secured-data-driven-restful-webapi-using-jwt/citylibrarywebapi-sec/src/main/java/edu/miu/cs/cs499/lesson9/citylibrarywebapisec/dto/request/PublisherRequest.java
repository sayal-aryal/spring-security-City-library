package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PublisherRequest(
        @NotBlank(message = "Publisher Name cannot be null or empty or blank")
        String name,
        AddressRequest primaryAddress) {
}
