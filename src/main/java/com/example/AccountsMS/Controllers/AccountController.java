package com.example.AccountsMS.Controllers;

import com.example.AccountsMS.Models.Accounts;
import com.example.AccountsMS.Services.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountServiceImpl accountService;


  /*  @GetMapping("/account")
    public String getaccount(){


        return "Account info is going to be Generated..!";
    }*/


    @GetMapping("/account")
    public List<Accounts> getAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/account")
    public Accounts addAccount(@RequestBody Accounts account){
        return accountService.addAccount(account);
    }
    @PutMapping("/account")
    public ResponseEntity<Accounts> updateAccount(@RequestBody Accounts account) {

        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }
    @DeleteMapping("/account/{accountID}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountID) {
        String response = accountService.deleteAccount(accountID);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/account/{accountID}")
    public ResponseEntity<Optional<Accounts>>getAccountbyID(@PathVariable Long accountID) {

        return new ResponseEntity<>(accountService.getAccount(accountID), HttpStatus.OK);
    }

    // Get the balance of an account by accountId
    @GetMapping("/{accountId}/balance")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable Long accountId) {
        try {
            BigDecimal balance = accountService.getAccountBalance(accountId);
            return ResponseEntity.ok(balance);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null); // Account not found
        }
    }

    @GetMapping("/users/{userId}")
    public List<Accounts> getAllAccountsForUser(@PathVariable Long userId) {
        return accountService.getAccountsByUserId(userId);
    }




    @ExceptionHandler
    public ResponseEntity<?> respondWithError(Exception e){
        return new ResponseEntity<>("Exception Occurred.More Info :"
                + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}


