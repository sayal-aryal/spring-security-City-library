package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.dto.request;

public record UserAuthRequest(
        String username,
        String password
) {
}
