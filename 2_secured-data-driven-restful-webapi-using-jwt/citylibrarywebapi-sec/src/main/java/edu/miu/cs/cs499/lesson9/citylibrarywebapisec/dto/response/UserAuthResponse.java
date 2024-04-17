package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.response;

public record UserAuthResponse(
        String jwtToken,
        String firstName,
        String lastName
) {
}
