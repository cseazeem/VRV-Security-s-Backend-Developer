package com.cseazeem.server.dtos;

public record JobRequest(
        String title,
        String company,
        String location,
        String skills,
        String experience,
        String type
) {
}
