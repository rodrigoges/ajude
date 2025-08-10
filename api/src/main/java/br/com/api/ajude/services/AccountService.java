package br.com.api.ajude.services;

import br.com.api.ajude.db.AccountRepository;
import br.com.api.ajude.exceptions.FlowException;
import br.com.api.ajude.mappers.AccountMapper;
import br.com.api.ajude.to.AccountRequestTO;
import br.com.api.ajude.to.AccountResponseTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);
    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Transactional
    public AccountResponseTO create(AccountRequestTO accountRequestTO) {
        log.info("Initializing creating account for e-mail {}", accountRequestTO.email());
        validatingIfEmailAlreadyExists(accountRequestTO.email());
        validatingIfNationalIdentifierAlreadyExists(accountRequestTO.nationalIdentifier());
        var account = accountMapper.mapToAccount(accountRequestTO);
        var accountRegistered = accountRepository.save(account);
        var accountResponseTO = accountMapper.mapToAccountTO(accountRegistered);
        log.info("Finalizing creating account for e-mail {}", accountResponseTO.email());
        return accountResponseTO;
    }

    public void validatingIfEmailAlreadyExists(String email) {
        log.info("Validating if e-mail {} already registered.", email);
        accountRepository.findByEmail(email).orElseThrow(
                () -> new FlowException(HttpStatus.CONFLICT, "E-mail already registered.")
        );
    }

    public void validatingIfNationalIdentifierAlreadyExists(String nationalIdentifier) {
        log.info("Validating if national identifier {} already registered.", nationalIdentifier);
        accountRepository.findByNationalIdentifier(nationalIdentifier).orElseThrow(
                () -> new FlowException(HttpStatus.CONFLICT, "National identifier already registered.")
        );
    }
}
