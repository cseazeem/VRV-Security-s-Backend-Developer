package com.cseazeem.server.dtos;

public record RegisterApplicant(
        String fullname,
        String username,
        String email,
        String password,
        String contact,
        String skills
) {
}
