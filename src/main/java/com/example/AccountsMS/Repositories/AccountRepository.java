package com.example.AccountsMS.Repositories;

import com.example.AccountsMS.Models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Accounts,Long> {


    List<Accounts> findByUserId(Long userId);
}
