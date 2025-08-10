package br.com.api.ajude.api;

import br.com.api.ajude.services.AccountService;
import br.com.api.ajude.to.AccountRequestTO;
import br.com.api.ajude.to.AccountResponseTO;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/accounts")
@Log4j2
public class AccountController {

    private static final Logger log = LogManager.getLogger(AccountController.class);
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseTO> create(@RequestBody @Valid AccountRequestTO accountRequestTO) {
        log.info("Starting the create account flow for e-mail {}", accountRequestTO.email());
        var accountResponse = accountService.create(accountRequestTO);
        log.info("Exiting the create account flow for e-mail {}", accountResponse.email());
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponse);
    }
}
