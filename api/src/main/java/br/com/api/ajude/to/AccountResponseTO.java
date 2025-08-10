package br.com.api.ajude.to;

import java.time.LocalDateTime;

public record AccountResponseTO(
        String name,
        String email,
        String nationalIdentifier,
        LocalDateTime createdAt) {
}
