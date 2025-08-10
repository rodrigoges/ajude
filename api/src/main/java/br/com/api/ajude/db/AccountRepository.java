package br.com.api.ajude.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findByEmail(String email);
    Optional<Account> findByNationalIdentifier(String nationalIdentifier);
}
