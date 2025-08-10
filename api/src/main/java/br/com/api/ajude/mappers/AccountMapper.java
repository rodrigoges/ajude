package br.com.api.ajude.mappers;

import br.com.api.ajude.db.Account;
import br.com.api.ajude.to.AccountRequestTO;
import br.com.api.ajude.to.AccountResponseTO;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountResponseTO mapToAccountTO(Account account) {
        return new AccountResponseTO(
                account.getName(),
                account.getEmail(),
                account.getNationalIdentifier(),
                account.getCreatedAt()
        );
    }

    public Account mapToAccount(AccountRequestTO accountRequestTO) {
        var account = new Account();
        account.setName(accountRequestTO.name());
        account.setEmail(accountRequestTO.email());
        account.setPassword(accountRequestTO.password());
        account.setNationalIdentifier(accountRequestTO.nationalIdentifier());
        return account;
    }
}
