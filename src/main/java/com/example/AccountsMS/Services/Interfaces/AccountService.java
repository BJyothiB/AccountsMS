package com.example.AccountsMS.Services.Interfaces;

import com.example.AccountsMS.Models.Accounts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountService {
    Accounts addAccount(Accounts account);
    List<Accounts> getAllAccounts();

    Accounts updateAccount(Accounts account);
    String deleteAccount(Long accountID);

    Optional<Accounts> getAccount(Long accountID);

    BigDecimal getAccountBalance(Long accountId);

    List<Accounts> findByUserId(Long userId);

    List<Accounts> getAccountsByUserId(Long userId);
}

