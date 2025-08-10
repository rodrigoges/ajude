package br.com.api.ajude.to;

public record AccountRequestTO(
        String name,
        String email,
        String password,
        String nationalIdentifier) {
}
