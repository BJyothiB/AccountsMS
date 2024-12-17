package com.example.AccountsMS.Services;


import com.example.AccountsMS.Models.Accounts;
import com.example.AccountsMS.Repositories.AccountRepository;
import com.example.AccountsMS.Services.Interfaces.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
    public class AccountServiceImpl implements AccountService {
        private static final Logger logger = LogManager.getLogger(com.example.AccountsMS.Services.AccountServiceImpl.class);

        private final AccountRepository accountRepository;


        public AccountServiceImpl(AccountRepository accountRepository) {
            this.accountRepository = accountRepository;
        }

        @Override
        public Accounts addAccount(Accounts account) {
            logger.info("New request to add Account"); //common

            logger.error("New request to add Account with type  {} with balance {}. There was a error",
                    account.getAccountType(), account.getBalance()); //always

            return accountRepository.save(account);
        }

        @Override
        public List<Accounts> getAllAccounts() {
            return accountRepository.findAll();
        }

        @Override
        public Optional<Accounts> getAccount(Long accountID) {
            logger.info("new request to get AccountbyID");
            return accountRepository.findById(accountID);
        }

        @Override
        public Accounts updateAccount(Accounts account) {
            logger.info("new request to update Account");
            return accountRepository.save(account);
        }

        @Override
        public String deleteAccount(Long accountID) {
            accountRepository.deleteById(accountID);
            logger.info("new request to delete Account");
            String response = ("Account ID " + accountID + " is successfully deleted");
            return response;

        }

        @Override
        // Method to get the balance of an account
        public BigDecimal getAccountBalance(Long accountId) {
            Optional<Accounts> accountOptional = accountRepository.findById(accountId);
            if (accountOptional.isPresent()) {
                return accountOptional.get().getBalance();
            } else {
                throw new RuntimeException("Account not found with id " + accountId);
            }
        }

        @Override
        public List<Accounts> findByUserId(Long userId) {
            return List.of();
        }

        @Override
        public List<Accounts> getAccountsByUserId(Long userId) {
            return accountRepository.findByUserId(userId);
        }


    }



