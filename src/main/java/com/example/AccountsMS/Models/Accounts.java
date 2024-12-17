package com.example.AccountsMS.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
    @Table
    @Getter
    @Setter
    public class Accounts {

        // private String accountId;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long account_id; //(PRIMARY KEY)

/*

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
        private Users user;
*/

    @Column(name = "user_id")
    private Long userId;

    private String accountNumber;

        private String accountType;

        private BigDecimal balance ;

        private String currency = "USD";

        private LocalDateTime createdAt = LocalDateTime.now();

    }


